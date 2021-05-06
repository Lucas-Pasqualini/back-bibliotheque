package com.example.comment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path="api/comment")
public class CommentController {
    CommentService commentService;

    @GetMapping("/{id}")
    public Mono<Comment> getCommentById(@PathVariable("id") Integer id) {
        return commentService.getCommentById(id);
    }

    @GetMapping("/search/{title}")
    public Mono<Comment> getCommentByTitle(@PathVariable("title") String title){
        return commentService.getCommentByTitle(title);
    }
}
