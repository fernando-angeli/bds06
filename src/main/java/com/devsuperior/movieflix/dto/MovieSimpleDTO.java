package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Movie;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieSimpleDTO {

    private Long id;
    private String title;
    private String subTitle;
    private Integer year;
    private String imgUrl;

    public MovieSimpleDTO(Movie entity) {
        id = entity.getId();
        title = entity.getTitle();
        subTitle = entity.getSubTitle();
        year = entity.getYear();
        imgUrl = entity.getImgUrl();
    }

}
