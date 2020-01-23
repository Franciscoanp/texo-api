package com.texoit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.texoit.model.Movie;
import com.texoit.repository.MovieRepository;

@Service
public class MovieService {

	public static final String AND = " and ";
	
	@Autowired
	private MovieRepository movieRepository;
	
	public List<Movie> findAll() {
		List<Movie> movies = movieRepository.findAll();
		return movies;
	}
	
	//mudar essa consulta para verificar se foi vencedor, atualmente está buscando todos os filmes indicados
	public List<Movie> findWinnersByName() {
		List<Movie> winners = movieRepository.findWinners();
		for (Movie movie : winners) {
			List<Movie> teste = movieRepository.findByProducersContainingIgnoreCase(movie.getProducers());
			System.out.println("O produtor: " +movie.getProducers() + " possui "  + teste.size() +" vitorias");
		}
		
		return winners;
	}

}
