package com.texoit;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.texoit.model.Movie;
import com.texoit.repository.MovieRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MovieResourceTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	
	@MockBean
	private MovieRepository movieRepository;
	
	@TestConfiguration
	static class Config {
		@Bean
		public RestTemplateBuilder restTemplateBuilder() {
			return new RestTemplateBuilder().basicAuthentication("texo", "");
		}
	}
	
	
	
	@Test
    public void listMoviesWhenUsernameAndPasswordAreCorrectShouldReturnStatusCode200() {
        List<Movie> students = Arrays.asList(new Movie(1L, 1980, "Can't Stop the Music", "Associated Film Distribution", "Allan Carr", "yes"), 
        									new Movie(2L, 1980, "Cruising", "Lorimar Productions", "Jerry Weintraub", ""));
        BDDMockito.when(movieRepository.findAll()).thenReturn(students);
        ResponseEntity<String> response = restTemplate.getForEntity("/movies/", String.class);
        Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    public void getMoviesByIdWhenUsernameAndPasswordAreCorrectShouldReturnStatusCode200() {
        ResponseEntity<Movie> response = restTemplate.getForEntity("/movies/{id}", Movie.class, 1L);
        Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    public void getMoviesByIdWhenUsernameAndPasswordAreCorrectAndStudentDoesNotExistShouldReturnStatusCode404() {
        ResponseEntity<Movie> response = restTemplate.getForEntity("/movies/{id}", Movie.class, -1);
        Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(404);
    }
	
	
}
