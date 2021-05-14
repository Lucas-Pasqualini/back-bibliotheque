package com.example.book;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.annotation.Transient;

@Getter
@Setter
@Data
public class Book implements Persistable<Integer> {

    @Id
    private Integer id;
    private String title;
    private String category;
    private String author;
    private String cover;

    @Transient
    private boolean newBook;

    @Override
    @Transient
    public boolean isNew() {
        return this.newBook || id == null;
    }

    public Book setAsNew(){
        this.newBook = true;
        return this;
    }
}
