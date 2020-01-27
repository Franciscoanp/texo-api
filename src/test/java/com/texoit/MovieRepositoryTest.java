package com.texoit;

import org.assertj.core.api.Assertions;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.texoit.model.Movie;
import com.texoit.repository.MovieRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MovieRepositoryTest {

	@Autowired
	private MovieRepository movieRepository;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	
	@Test
	public void createShouldPersistData() {
		Movie movie = new Movie(1L, 1980, "Can't Stop the Music", "Associated Film Distribution", "Allan Carr", "yes");
		this.movieRepository.save(movie);
		
		Assertions.assertThat(movie.getId()).isNotNull();
		Assertions.assertThat(movie.getTitle()).isNotNull();
		Assertions.assertThat(movie.getTitle()).isEqualTo("Can't Stop the Music");
		Assertions.assertThat(movie.getProducers()).isEqualTo("Allan Carr");
		
	}
	
	@Test
	public void createWhenProducerIsNullShouldThrowConstraintViolationException() {
		thrown.expect(ConstraintViolationException.class);
		thrown.expectMessage("field producer is required");
		this.movieRepository.save(new Movie());
	}
	
}
