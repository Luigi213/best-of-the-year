package org.java.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.java.project.Movie;
import org.java.project.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class YearController {
	
	@GetMapping("/hola")
	public String sayHelloSp(Model model,
			@RequestParam(name = "name") String name) {
		
		model.addAttribute("name", name);
		
		return "index";
	}
	

	private List<Movie> getBestMovies(){
		List<Movie> ml = new ArrayList<>();
		
		ml.add(new Movie(1, "ciao film"));
		ml.add(new Movie(2, "ciao1 film1"));
		ml.add(new Movie(3, "ciao2 film2"));
		
		return ml;
	}
	
	private List<Song> getBestSongs(){
		List<Song> sl = new ArrayList<>();
		
		sl.add(new Song(1, "ciao canzone"));
		sl.add(new Song(2, "ciao1 canzone1"));
		sl.add(new Song(3, "ciao2 canzone2"));
		return sl;
	}
	
	@GetMapping("/songs")
	public String listSongs(Model model) {
		List<Song> songs = getBestSongs();
		
		model.addAttribute("songs", songs);
		
		return "song";
	}
	
	@GetMapping("/movies")
	public String listMovies(Model model) {
		List<Movie> movies = getBestMovies();

		model.addAttribute("movies", movies);
		
		return "movie";
	}
	
	@GetMapping("/songs/{id}")
	public String getIdSongs(Model model,
			@PathVariable("id") int id) {
		Song song = null;
		for( Song s : getBestSongs()) {
			if(s.getId() == id) {				
				song = s; 
			}
		}
		model.addAttribute("song", song);
		
		return "song-detail";
	}
	
	@GetMapping("/movies/{id}")
	public String getIdMovies(Model model,
			@PathVariable("id") int id) {
		Movie movie = null;
		for( Movie m : getBestMovies()) {
			if(m.getId() == id) {				
				movie = m; 
			}
		}
		model.addAttribute("movie", movie);
		
		return "movie-detail";
	}
}
