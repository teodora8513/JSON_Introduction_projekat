package main;

import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import movie.Movie;

public class Main1 {

	public static void main(String[] args) {
		Movie m= new Movie("tt00242", "From dusk till dawn", 1996, 7.2);
		String[] actors = {"George Clooney", "Quentin Tarantinov"};
		m.setActors(actors);
		try(FileWriter writer = new FileWriter("movie.json")){
		//Pravimo instancu gson-a
		Gson gson = new Gson();
		//Pravimo builder da bi json bio lepo formatiran
		Gson gsonPriti = new GsonBuilder().setPrettyPrinting().create();
		/*String json = gson.toJson(m);
		String jsonPriti = gsonPriti.toJson(m);
		
		System.out.println(jsonPriti);
		System.out.println(json);*/
		String jsonPriti = gsonPriti.toJson(m);
		writer.write(jsonPriti);
		}catch(Exception e) {
			
		}
	}
}
