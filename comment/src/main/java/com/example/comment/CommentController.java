package com.example.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path="api/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public Flux<Comment> getComments(){
        return commentService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Comment> getComment(@PathVariable("id") Integer id) {
        return commentService.findById(id);
    }

    @GetMapping("/search/{title}")
    public Mono<Comment> searchComment(@PathVariable("title") String title) {
        return commentService.findByTitle(title);
    }

    @PostMapping("/add")
    public Mono<Comment> addComment(@RequestBody Comment comment){
        return commentService.addComment(comment);
    }

    @DeleteMapping("/delete/{commentId}")
    public void deleteComment(@PathVariable("commentId") int commentId) {
        commentService.deleteComment(commentId);
    }

    @PutMapping("/update")
    public Mono<Comment> updateComment(@RequestBody Comment comment) {
        return commentService.updateComment(comment);
    }
}
