package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.MovieCompleteDTO;
import com.devsuperior.movieflix.dto.MovieSimpleDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private GenreService genreService;

    @Transactional(readOnly = true)
    public MovieCompleteDTO findById(Long id){
        Optional<Movie> movie = repository.findById(id);
        Movie entity = movie.orElseThrow(() -> new ResourceNotFoundException("Id " + id + " não encontrado"));
        return new MovieCompleteDTO(entity);
    }

    @Transactional(readOnly = true)
    public Page<MovieSimpleDTO> findByGenrePaged(Long genreId, Pageable pageable){
        Genre genre = genreId == 0 ? null : genreRepository.getOne(genreId);
        Page<Movie> pageMovie = repository.findByGenreId(genre, pageable);
        return pageMovie.map(MovieSimpleDTO::new);
    }

    @Transactional(readOnly = true)
    public List<ReviewDTO> getReviewsMovie(Long movieId) {
        return reviewService.findReviewByMovieId(movieId);
    }

    public Movie getEntityMovieById(Long movieId){
        MovieCompleteDTO dto = findById(movieId);
        Movie movie = new Movie();
        movie.setId(dto.getId());
        movie.setTitle(dto.getTitle());
        movie.setSubTitle(dto.getSubTitle());
        movie.setYear(dto.getYear());
        movie.setImgUrl(dto.getImgUrl());
        List<Review> reviews = reviewRepository.findAllByMovieId(movieId);
        reviews.stream().map(x -> movie.getReviews().add(x)).collect(Collectors.toList());
        Genre genre = new Genre();
        movie.setGenre(genreService.copyDtoToEntity(dto.getGenre(), genre));
        return movie;
    }

}
