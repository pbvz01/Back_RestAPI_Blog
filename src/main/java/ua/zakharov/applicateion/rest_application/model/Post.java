package ua.zakharov.applicateion.rest_application.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "post")
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "category")
    private String category;

    @Column(name = "full_text")
    private String full_text;

    @Column(name = "views")
    private Integer views;

    @Column(name = "check_admin",
            nullable = false)
    private Boolean check = false;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User user;
}
