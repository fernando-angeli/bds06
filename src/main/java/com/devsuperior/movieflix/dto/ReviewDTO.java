package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {

    private Long id;
    private String text;
    private Long userId;
    private Long movieId;

    public ReviewDTO(Review entity) {
        id = entity.getId();
        text = entity.getText();
        userId = entity.getUser().getId();
        movieId = entity.getMovie().getId();
    }
}
