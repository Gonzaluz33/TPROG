package controllers;

import java.io.IOException;
import java.security.Key;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Fabrica;
import model.IControladorUsuario;
import model.TokenBlacklist;
import utils.DTUsuario;

public class UtilidadesJWT {
	private static UtilidadesJWT instancia;
	private static final String secret_Key = "6a2b5c8e1f4a7d0987654321abcdef09";
	private UtilidadesJWT() {}
	public static UtilidadesJWT obtenerInstancia() {
        if (instancia == null) {
            instancia = new UtilidadesJWT();
        }
        return instancia;
    }

	public String obtenerTipoUsuarioPorRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    	Cookie[] cookies = req.getCookies();
        String jwtCookieName = "jwt";
        String jwt = null;
        String response = "invalido";
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (jwtCookieName.equals(cookie.getName())) {
                    jwt = cookie.getValue();
                    break;
                }
            }
            
            if (jwt != null) {
            	response = "visitante";
		        TokenBlacklist blacklist = TokenBlacklist.getInstance();
		       	 if(!blacklist.isTokenBlacklisted(jwt)) {
				             try {
				            	 Key secretKey = Keys.hmacShaKeyFor(secret_Key.getBytes());
				                 Jws<Claims> claimsJws = Jwts.parserBuilder()
				                         .setSigningKey(secretKey)
				                         .build()
				                         .parseClaimsJws(jwt);
				
				                 Claims claims = claimsJws.getBody();
				        	    String tipoUsuario = (String) claims.get("tipoUsuario");
				        	    response = tipoUsuario;
				        	    
				             } catch (Exception e) {
				            	 response = "visitante"; 
				             }
		        }
            }
        }else {
        	response = "visitante";
        }
		return response;  
    }
	
	public DTUsuario obtenerDatosDeUsuarioJWT(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		DTUsuario user = null;
		Cookie[] cookies = req.getCookies();
		String jwtCookieName = "jwt";
		String jwt = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (jwtCookieName.equals(cookie.getName())) {
					jwt = cookie.getValue();
					break;
				}
			}
		}
		if (jwt != null) {	
			TokenBlacklist blacklist = TokenBlacklist.getInstance();
			if (!blacklist.isTokenBlacklisted(jwt)) {
				try {
					Key secretKey = Keys.hmacShaKeyFor(secret_Key.getBytes());
					Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(jwt);
					Claims claims = claimsJws.getBody();
					String correo = (String) claims.get("email");
					Fabrica factory = Fabrica.getInstance();
					IControladorUsuario iconuser = factory.getIControladorUsuario();
					if (iconuser.usuarioExiste(correo)) {
						DTUsuario usuario = iconuser.consultarUsuarioPorCorreo(correo); 
						return usuario;
					} 

				} catch (Exception e) {

				}

			}

		} 
    
	return user;
	
	}

}
