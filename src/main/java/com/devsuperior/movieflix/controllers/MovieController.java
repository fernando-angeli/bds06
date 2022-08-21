package com.devsuperior.movieflix.controllers;

import com.devsuperior.movieflix.dto.MovieCompleteDTO;
import com.devsuperior.movieflix.dto.MovieSimpleDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping("/{id}")
    public ResponseEntity<MovieCompleteDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<Page<MovieSimpleDTO>> findByGenrePaged(
            @RequestParam (defaultValue = "0")Long genreId,
            Pageable pageable){
        return ResponseEntity.ok().body(service.findByGenrePaged(genreId, pageable));
    }

    @GetMapping("/{movieId}/reviews")
    public ResponseEntity<List<ReviewDTO>> getReviewsMovie(@PathVariable Long movieId){
        return ResponseEntity.ok().body(service.getReviewsMovie(movieId));
    }

}
