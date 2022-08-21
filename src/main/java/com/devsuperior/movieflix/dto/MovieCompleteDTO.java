package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Movie;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieCompleteDTO {

    private Long id;
    private String title;
    private String subTitle;
    private Integer year;
    private String imgUrl;
    private String synopsis;
    private GenreDTO genre;

    public MovieCompleteDTO(Movie entity) {
        id = entity.getId();
        title = entity.getTitle();
        subTitle = entity.getSubTitle();
        year = entity.getYear();
        imgUrl = entity.getImgUrl();
        synopsis = entity.getSynopsis();
        genre = new GenreDTO(entity.getGenre());
    }

}
