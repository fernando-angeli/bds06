package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repository;

    @Autowired
    private MovieService movieService;

    @Autowired
    private UserService userService;

    @Transactional(readOnly = true)
    public List<ReviewDTO> findReviewByMovieId(Long movieId){
        List<Review> reviews = repository.findAllByMovieId(movieId);
        return reviews.stream().map(ReviewDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public ReviewDTO insert(ReviewDTO dto){
        Review review = copyDtoToEntity(dto);
        review = repository.save(review);
        return new ReviewDTO(review, review.getUser());
    }

    private Review copyDtoToEntity(ReviewDTO dto){
        Review entity = new Review();
        entity.setText(dto.getText());
        entity.setUser(userService.authenticated());
        entity.setMovie(movieService.getEntityMovieById(dto.getMovieId()));
        return entity;
    }
}
