package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.User;
import lombok.*;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String email;

    public UserDTO(User entity){
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
    }
}