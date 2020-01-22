package com.texoit;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import com.texoit.model.Movie;
import com.texoit.repository.MovieRepository;

@SpringBootApplication
public class TexoApiApplication  implements CommandLineRunner{

	@Autowired
	private MovieRepository movieRepository;
	
	public static void main(String[] args) throws IOException, CsvException {
		SpringApplication.run(TexoApiApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
	
		Reader reader = Files.newBufferedReader(Paths.get("movielist.csv"));

        CsvToBean<Movie> csvToBean = new CsvToBeanBuilder<Movie>(reader)
        		.withSeparator(';')
                .withType(Movie.class)
                .build();

        List<Movie> movies = csvToBean.parse();

        for (Movie movie : movies) {
        	movieRepository.save(movie);
        }	
        
        
	}

}
