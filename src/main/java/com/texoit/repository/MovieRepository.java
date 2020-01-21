package com.texoit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.texoit.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
