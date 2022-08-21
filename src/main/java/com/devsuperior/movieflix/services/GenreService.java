package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreService {

    @Autowired
    private GenreRepository repository;

    @Autowired
    private MovieRepository movieRepository;

    @Transactional
    public List<GenreDTO> findAll(){
        List<Genre> list = repository.findAll();
        return list.stream().map(GenreDTO::new).collect(Collectors.toList());
    }

    public Genre copyDtoToEntity(GenreDTO dto, Genre entity) {
        entity.setName(dto.getName());
        return entity;
    }
}
