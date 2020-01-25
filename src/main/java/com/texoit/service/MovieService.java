package com.texoit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.texoit.model.Max;
import com.texoit.model.Min;
import com.texoit.model.MinMax;
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
	
	public MinMax findWinners() {
		MinMax minMax = new MinMax();
		
		int ultimoItem = 0;
		
		List<Integer> resultados = new ArrayList<>();
				
		for (Movie movie : movieRepository.findWinners()) {
			List<Movie> movies = movieRepository.findProducers(movie.getProducers());
			
			ultimoItem = movies.size() -1;
			
			checkMinAndMax(minMax, ultimoItem, resultados, movies);
		}
		
		return minMax;
	}

	private void checkMinAndMax(MinMax minMax, int ultimoItem, List<Integer> resultados, List<Movie> movies) {
		int resultado;
		if (movies.size() > 1) {
			
			resultado = movies.get(ultimoItem).getYear() - movies.get(0).getYear();
			resultados.add(resultado);
			resultados.sort((a, b) -> a.compareTo(b));
			
			if (resultado == 1) {
				Min min = new Min();
				min.setProducer(movies.get(1).getProducers());
				min.setInterval(resultado);
				min.setPreviousWin(movies.get(0).getYear());
				min.setFollowingWin(movies.get(ultimoItem).getYear());
				
				minMax.getMin().add(min);
				
			} 
			
			if (resultado == 13) {
				Max max = new Max();
				max.setProducer(movies.get(0).getProducers());
				max.setInterval(resultado);
				max.setPreviousWin(movies.get(0).getYear());
				max.setFollowingWin(movies.get(ultimoItem).getYear());
				
				minMax.getMax().add(max);
				
			} 
		}
	}

	

}
