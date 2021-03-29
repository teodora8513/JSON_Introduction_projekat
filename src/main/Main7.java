package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class Main7 {

	private static final String BASE_URL = "http://api.currencylayer.com";
	private static final String API_KEY = "2e4baadf5c5ae6ba436f53ae5558107f";
	private static final String SOURCE = "USD";
	private static final String CURRENCIES = "EUR";
	
	public static void main(String[] args) {
		try {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			URL url = new URL(BASE_URL + "/live?access_key="+API_KEY + ""
					+ "&source=" + SOURCE + "&currencies=" + CURRENCIES);
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			JsonObject rez = gson.fromJson(reader, JsonObject.class);
			
			if(!rez.get("success").getAsBoolean())
				throw new RuntimeException("Operacija nije true");
			System.out.println(rez);
			//Izvuci kurs dolar prema evro
			double kurs = rez.get("quotes").getAsJsonObject().get("USDEUR").getAsDouble();
			System.out.println("Kurs je " + kurs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
