package org.java.project.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.java.project.Movie;
import org.java.project.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class YearController {
	
	@GetMapping("/hola")
	public String sayHelloSp(Model model,
			@RequestParam(name = "name") String name) {
		
		model.addAttribute("name", name);
		
		return "index";
	}
	

	private List<Movie> getBestMovies(){
		List<Movie> ml = new ArrayList<>();
		
		ml.add(new Movie(0, "ciao film"));
		ml.add(new Movie(1, "ciao1 film1"));
		ml.add(new Movie(2, "ciao2 film2"));
		
		return ml;
	}
	
	private List<Song> getBestSongs(){
		List<Song> sl = new ArrayList<>();
		
		sl.add(new Song(0, "ciao canzone"));
		sl.add(new Song(1, "ciao1 canzone1"));
		sl.add(new Song(2, "ciao2 canzone2"));
		return sl;
	}
	
	@GetMapping("/songs")
	public String listSongs(Model model) {
		String list = "";
		for( Song s : getBestSongs()) {	
			if(list.equals("")) {				
				list += s.getTitolo(); 
			} else {
				list += "," + s.getTitolo(); 
			}
		}
		model.addAttribute("name", list);
		
		return "index";
	}
	
	@GetMapping("/movies")
	public String listMovies(Model model) {
		String list = "";
		for( Movie m : getBestMovies()) {
			if(list.equals("")) {				
				list += m.getTitolo(); 
			} else {
				list += "," + m.getTitolo(); 
			}
		}
		model.addAttribute("name", list);
		
		return "index";
	}
	
	@GetMapping("/songs/{id}")
	public String getIdSongs(Model model,
			@PathVariable("id") int id) {
		String song = "";
		for( Song s : getBestSongs()) {
			if(s.getId() == id) {				
				song = s.getTitolo(); 
			}
			else {
				song = "nessuna canzone con questo id";
			}
		}
		model.addAttribute("name", song);
		
		return "index";
	}
	
	@GetMapping("/movies/{id}")
	public String getIdMovies(Model model,
			@PathVariable("id") int id) {
		String movie = "";
		for( Movie m : getBestMovies()) {
			if(m.getId() == id) {				
				movie = m.getTitolo(); 
			}
			else {
				movie = "nessuna canzone con questo id";
			}
		}
		model.addAttribute("name", movie);
		
		return "index";
	}
}
