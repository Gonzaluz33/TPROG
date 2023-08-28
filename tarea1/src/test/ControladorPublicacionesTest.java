package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import excepciones.*;
import logica.Fabrica;
import logica.IControladorPublicaciones;
import logica.ManejadorOfertaLaboral;
import logica.ManejadorPublicaciones;
import logica.ManejadorUsuarios;
import utils.DTTipoPublicacion;

public class ControladorPublicacionesTest {

	private static IControladorPublicaciones controladorPublicaciones;
	
	private static ManejadorUsuarios manejadorU;
	private static ManejadorOfertaLaboral manejadorOL;
	private static ManejadorPublicaciones manejadorP;
	
	
	@BeforeAll
	public static void iniciar() {
		Fabrica fabrica = Fabrica.getInstance();
		controladorPublicaciones = fabrica.getIControladorPublicaciones();
		
		manejadorU = ManejadorUsuarios.getInstance();
		manejadorOL = ManejadorOfertaLaboral.getInstance();
		manejadorP = ManejadorPublicaciones.getInstance();
	}
	
	@BeforeEach
	public void limpiarColecciones() {
		manejadorU.limpiarColeccionUsuarios();
		manejadorOL.limpiarColeccionOfertasLaborales();
		manejadorOL.limpiarColeccionKeywords();
		manejadorP.limpiarColeccionPublicaciones();
		manejadorP.limpiarColeccionPaquetes();
		manejadorP.limpiarColeccionTipos();
	}
	
	// tests altaTipoPublicacionOL()
	@Test
	public void altaTipoPublicacionOL_OK() {
		String nombreTipoP = "nombreTipoP";
		String descripcionTipoP = "descripcionTipoP";
		int exposicionTipoP = 4;
		Integer duracionTipoP = 24;
		Integer costoPublicTipoP = 69;
		LocalDate fechaTipoP = LocalDate.now();
		
		try {
			controladorPublicaciones.altaTipoPublicacionOL(nombreTipoP, descripcionTipoP, exposicionTipoP, duracionTipoP, costoPublicTipoP, fechaTipoP);
		} catch (TipoPublicExisteException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		
		assertEquals(controladorPublicaciones.obtenerTipos().size(), 1);
		DTTipoPublicacion tipoDT = controladorPublicaciones.obtenerTipos().get(0);
		assertEquals(tipoDT.getNombre(), nombreTipoP);
		assertEquals(tipoDT.getDescripcion(), descripcionTipoP);
		assertEquals(tipoDT.getExposicion(), exposicionTipoP);
		assertEquals(tipoDT.getDuracion(), duracionTipoP);
		assertEquals(tipoDT.getCosto(), costoPublicTipoP);
		assertEquals(tipoDT.getAlta(), fechaTipoP);
	}
	
	@Test
	public void altaTipoPublicacionOL_Repetida() {

		String nombreTipoP = "nombreTipoP";
		String descripcionTipoP = "descripcionTipoP";
		int exposicionTipoP = 4;
		Integer duracionTipoP = 24;
		Integer costoPublicTipoP = 69;
		LocalDate fechaTipoP = LocalDate.now();
		
		try {
			controladorPublicaciones.altaTipoPublicacionOL(nombreTipoP, descripcionTipoP, exposicionTipoP, duracionTipoP, costoPublicTipoP, fechaTipoP);
		} catch (TipoPublicExisteException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}

		assertEquals(controladorPublicaciones.obtenerTipos().size(), 1);
		assertThrows(TipoPublicExisteException.class, () -> controladorPublicaciones.altaTipoPublicacionOL(nombreTipoP, descripcionTipoP, exposicionTipoP, duracionTipoP, costoPublicTipoP, fechaTipoP));
	}
	
	// tests obtenerTipos()
	@Test
	public void testObtenerTipos_SinTipos() {
		assertEquals(controladorPublicaciones.obtenerTipos().size(), 0);
	}
	
}
