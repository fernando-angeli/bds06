package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Genre;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreDTO {

    private Long id;
    private String name;

    public GenreDTO(Genre entity) {
        id = entity.getId();
        name = entity.getName();
    }

}
