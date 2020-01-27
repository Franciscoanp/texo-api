package com.texoit;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import com.texoit.model.Movie;
import com.texoit.model.Producer;
import com.texoit.repository.MovieRepository;
import com.texoit.repository.ProducerRepository;

@SpringBootApplication
public class TexoApiApplication  implements CommandLineRunner{

	public static final String AND = " and ";
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private ProducerRepository producerRepository;
	
	public static void main(String[] args) throws IOException, CsvException {
		SpringApplication.run(TexoApiApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
	
//		Reader reader = Files.newBufferedReader(Paths.get("movielist.csv"));
//
//        CsvToBean<Movie> csvToBean = new CsvToBeanBuilder<Movie>(reader)
//        		.withSeparator(';')
//                .withType(Movie.class)
//                .build();
//
//        List<Movie> movies = csvToBean.parse();
//
//        for (Movie movie : movies) {
//        	movieRepository.save(movie);
//        }	
//        
//        for (Movie movie : movieRepository.findWinners()) {
//        	
//        	List<String> producersTemp1 = new ArrayList<>();
//        	List<Producer> producers = new ArrayList<>();
//        	Producer producerTemp = new Producer();
//        	
//        	producersTemp1.add(movie.getProducers().replace(AND , ", "));
//        	
//        	for (int i = 0; i < producersTemp1.size(); i++) {
//        		producerTemp.setName(producersTemp1.get(i));
//        		producers.add(producerTemp);
//        		
//        		String[] nomes = producerTemp.getName().split(", ");
//        		for (String nome : nomes) {
//        			Producer producer = new Producer();
//        			producer.setName(nome);
//        			producerRepository.save(producer);
//        		}
//        		
//        	}
//        	
//        }
        
        
        
	}

}
