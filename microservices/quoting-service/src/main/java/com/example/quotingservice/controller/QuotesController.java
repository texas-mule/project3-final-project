package com.example.quotingservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quotingservice.domain.Quotes;
@RestController
@RequestMapping("/quote-service")
public class QuotesController{
	
	private static List<Quotes> movieList = new ArrayList<>();
    static {
        movieList.add(new Quotes( 1, "org_name", 300.00, 3030.00, "apple"));
      
    }
    @GetMapping("/quote")
    public ResponseEntity<?> getMovies() {
        return ResponseEntity.ok(movieList);
    }
  

}
