package ua.zakharov.applicateion.rest_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.zakharov.applicateion.rest_application.model.Post;
import ua.zakharov.applicateion.rest_application.model.User;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAll();
    List<Post> findPostsByCheck(boolean check);
    List<Post> findPostsByUser(User user);
    Post findPostsById(Long id);
    Post save(Post post);
}
