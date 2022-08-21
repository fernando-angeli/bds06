package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import lombok.*;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {

    private Long id;
    @NotBlank(message = "Não é permitido texto vazio na avaliação.")
    private String text;
    private Long movieId;
    private UserDTO user;
    
    public ReviewDTO(Review entity) {
        id = entity.getId();
        text = entity.getText();
        movieId = entity.getMovie().getId();
        user = new UserDTO(entity.getUser());
    }

    public ReviewDTO(Review entity, User user) {
        this(entity);
        this.user = new UserDTO(user);
    }

}
