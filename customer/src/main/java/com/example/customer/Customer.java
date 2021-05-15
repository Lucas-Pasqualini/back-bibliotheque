package com.example.customer;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;

@Getter
@Setter
@Data
public class Customer implements Persistable<Integer> {

    @Id
    private Integer id;
    private String name;
    private int age;
    private String password;
    private String login;
    private String category;

    @Transient
    private boolean newCustomer;

    @Override
    @Transient
    public boolean isNew() {
        return this.newCustomer || id == null;
    }

    public Customer setAsNew(){
        this.newCustomer = true;
        return this;
    }
}
