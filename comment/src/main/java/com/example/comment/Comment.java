package com.example.comment;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;

@Getter
@Setter
@Data
public class Comment implements Persistable<Integer> {

    @Id
    private Integer id;
    private String title;
    private String content;

    @Transient
    private boolean newComment;

    @Override
    @Transient
    public boolean isNew() {
        return this.newComment || id == null;
    }

    public Comment setAsNew(){
        this.newComment = true;
        return this;
    }
}
