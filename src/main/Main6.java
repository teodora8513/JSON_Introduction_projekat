package main;

import java.io.FileWriter;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;

public class Main6 {

	public static void main(String[] args) {
		try(FileWriter writer = new FileWriter("movie_manual.json")){
			Gson gson = new Gson();
			JsonObject m = gson.fromJson(writer, JsonObject.class);
			System.out.println(m.get("imdbid").getAsString());
			System.out.println(m.get("title").getAsString());
			System.out.println(m.get("releaseYear").getAsInt());
		
			double rating = m.get("rating").getAsDouble() -1;
			System.out.println(rating);
		
			JsonArray actors = m.getAsJsonArray("actors") ;
			//Dobijamo drugog glumca, index krece od 0
			System.out.println(actors.get(1).getAsString());
			
			//Set je mapa kljuca i elementa
			Set<Entry<String , JsonElement>> es = m.entrySet();
			
			for(Entry<String, JsonElement> element : es) {
				System.out.println(element);
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
