package ua.zakharov.applicateion.rest_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.zakharov.applicateion.rest_application.model.Post;
import ua.zakharov.applicateion.rest_application.model.User;
import ua.zakharov.applicateion.rest_application.repository.PostRepository;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public List<Post> getPostsByAdminChecking(boolean checkingOfAdmin) {
        return postRepository.findPostsByCheck(checkingOfAdmin);
    }

    public List<Post> getPostsByUser(User user) {
        return postRepository.findPostsByUser(user);
    }

    public Post getPostById(Long id) {
        return postRepository.findPostsById(id);
    }

    public Post savePost(Post post) {
        return postRepository.save(post);
    }

}
