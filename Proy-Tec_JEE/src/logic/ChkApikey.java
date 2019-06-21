package logic;

public class ChkApikey {
	private static String ApiKeyGET = "123ABC";
	private static String ApiKeyALL = "ABC123";
	
	public static Boolean isApiKeyGET(String apiKey) {
		return apiKey.equals(ApiKeyGET);
	}
	
	public static Boolean isApiKeyALL(String apiKey) {
		return apiKey.equals(ApiKeyALL);
	}
}
