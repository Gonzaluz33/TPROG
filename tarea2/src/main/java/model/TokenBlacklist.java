package model;

import java.util.HashMap;
import java.util.Map;


public class TokenBlacklist {
	private static final TokenBlacklist instance = new TokenBlacklist();
	private static Map<String, Long> blacklistedTokens = new HashMap<>();

	public TokenBlacklist() {
		// TODO Auto-generated constructor stub
	}
	
	public static TokenBlacklist getInstance() {
        return instance;
    }
	

    public void blacklistToken(String token, Long expirationTime) {
        cleanExpiredTokens();
        blacklistedTokens.put(token, expirationTime);
    }


    public boolean isTokenBlacklisted(String token) {
        return blacklistedTokens.containsKey(token);
    }


    private void cleanExpiredTokens() {
        long currentTime = System.currentTimeMillis() / 1000;
        blacklistedTokens.entrySet().removeIf(entry -> entry.getValue() <= currentTime);
    }
	

}
