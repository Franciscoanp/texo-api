package com.texoit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.texoit.model.Movie;
import com.texoit.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	public List<Movie> findAll() {
		List<Movie> movies = movieRepository.findAll();
		return movies;
	}
	
	public List<Movie> findWinners() {
		List<Movie> winners = movieRepository.findWinners();
		
		
		return winners;
	}
	
	
}
