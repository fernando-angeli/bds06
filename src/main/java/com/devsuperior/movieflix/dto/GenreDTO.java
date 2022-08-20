package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreDTO {

    private Long id;
    private String name;
    private Set<MovieDTO> movies = new HashSet<MovieDTO>();

    public GenreDTO(Genre entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public GenreDTO(Genre genre, Set<Movie> movies){
        this(genre);
        movies.forEach(mov -> this.movies.add(new MovieDTO(mov)));
    }

}
