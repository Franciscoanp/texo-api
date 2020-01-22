package com.texoit.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.texoit.model.Movie;
import com.texoit.service.MovieService;

@RestController
@RequestMapping(path = "/movies")
public class MovieResource {

	@Autowired
	private MovieService movieService;
	
	@GetMapping
	public ResponseEntity<List<Movie>> findAll() {
		return ResponseEntity.ok(movieService.findAll());
	}
	
	@GetMapping("/winners")
	public ResponseEntity<List<Movie>> findWinners() {
		return ResponseEntity.ok(movieService.findWinners());
	}
	
}
