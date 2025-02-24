package com.devsuperior.uri2611;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2611.dto.MovieMinDTO;
import com.devsuperior.uri2611.projections.MovieMinProjection;
import com.devsuperior.uri2611.repositories.MovieRepository;



@SpringBootApplication
public class Uri2611Application implements CommandLineRunner {
	
	@Autowired
	private MovieRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<MovieMinProjection> list = repository.search1("Action");
		List<MovieMinDTO> result = list.stream().map(x-> new MovieMinDTO(x)).collect(Collectors.toList());
		
		System.out.println("\n***RESULTADO SQL RAÍZ***\n");
		for(MovieMinDTO obj :result) {
			System.out.println(obj);
			
		}
		System.out.println("\n\n");
		
		List<MovieMinDTO> list1 = repository.search2("Action");
		System.out.println("\n***RESULTADO JPQL***\n");
		for(MovieMinDTO obj :list1) {
			System.out.println(obj);
			
		}
	}
}
