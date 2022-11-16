package ua.zakharov.applicateion.rest_application.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.zakharov.applicateion.rest_application.model.Post;
import ua.zakharov.applicateion.rest_application.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("")
    public List<Post> getAllPost() {
        return postService.getAllPosts();
    }
}
