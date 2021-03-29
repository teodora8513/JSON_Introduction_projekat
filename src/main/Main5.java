package main;

import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;

public class Main5 {

	public static void main(String[] args) {
		try(FileWriter writer = new FileWriter("movie_manual.json")){
			JsonObject obj = new JsonObject();
			//Prvo je key drugo je vrednost
			obj.addProperty("imdbid", "34253kj");
			obj.addProperty("title", "From dusk till dawn");
			obj.addProperty("releaseYear", 1996);
			obj.addProperty("rating", 7.2);
			
			JsonArray actors = new JsonArray();
			actors.add("Tarantinov");
			actors.add("Clooney");
			
			obj.add("actors", actors);
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			gson.toJson(obj,writer);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
