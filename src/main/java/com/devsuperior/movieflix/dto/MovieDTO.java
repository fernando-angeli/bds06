package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MovieDTO {

    private Long id;
    private String title;
    private String subTitle;
    private Integer year;
    private String imgUrl;
    private String synopsis;
    private List<ReviewDTO> reviews = new ArrayList<>();
    private Long idGenre;

    public MovieDTO(Movie entity) {
        id = entity.getId();
        title = entity.getTitle();
        subTitle = entity.getSubTitle();
        year = entity.getYear();
        imgUrl = entity.getImgUrl();
        synopsis = entity.getSynopsis();
        idGenre = entity.getGenre().getId();
    }

    public MovieDTO(Movie movie, List<Review> reviews){
        this(movie);
        reviews.forEach(rev -> this.reviews.add(new ReviewDTO(rev)));
    }
}
