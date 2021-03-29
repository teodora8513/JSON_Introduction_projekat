package main;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import movie.Movie;

public class Main4 {
	public static void main(String[] args) {

		try(FileReader file = new FileReader("many_movies.json")){
			Gson gson = new Gson();
			//PRvi nacin
			//Movie[] movies = gson.fromJson(file, Movie[].class);
			//Drugi nacin
			//List<Movie> movies = Arrays.asList(gson.fromJson(file, Movie[].class));
			//Treci nacin
			Type typeToken = new TypeToken<LinkedList<Movie>>(){}.getType();
			
			List<Movie> movies = gson.fromJson(file, typeToken);
			for (Movie movie : movies) {
				System.out.println(movie.toString());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
