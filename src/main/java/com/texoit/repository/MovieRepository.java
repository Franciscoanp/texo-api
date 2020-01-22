package com.texoit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.texoit.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

	@Query(value = "SELECT * FROM MOVIE WHERE WINNER = 'yes'", nativeQuery = true)
	public List<Movie> findWinners();
}
