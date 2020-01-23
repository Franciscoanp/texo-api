package com.texoit.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.texoit.model.Movie;
import com.texoit.repository.IProducerProjection;
import com.texoit.repository.ProducerRepository;
import com.texoit.service.MovieService;

@RestController
@RequestMapping(path = "/movies")
public class MovieResource {

	@Autowired
	private MovieService movieService;
	
	@Autowired
	private ProducerRepository producerRepository;
	
	@GetMapping
	public ResponseEntity<List<Movie>> findWinnersByName() {
		return ResponseEntity.ok(movieService.findWinnersByName());
	}
	
	@GetMapping("/winners")
	public ResponseEntity<List<IProducerProjection>> findAllProducer() {
		return ResponseEntity.ok(producerRepository.findAllProducer());
	}
	
	
	
}
