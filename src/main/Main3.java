package main;

import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import movie.Movie;

public class Main3 {

	public static void main(String[] args) {
		Movie m1 = new Movie("245643", "Before Sunrise" , 1955, 0);
		Movie m2 = new Movie("2456sfes43", "Before Sunset" , 2004, 0);
		Movie m3 = new Movie("24sfd5643", "Before Midnight" , 2013, 0);
		
		//Movie[] movies = {m1, m2, m3};
		List<Movie> movies = new LinkedList<>();
		movies.add(m3);
		movies.add(m2);
		movies.add(m1);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		try (FileWriter writer = new FileWriter("many_movies.json")){
			gson.toJson(movies, writer);
		}catch(Exception e) {
			
		}
	}
}
