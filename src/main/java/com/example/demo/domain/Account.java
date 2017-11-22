package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;

@Entity
public class Account {
    @OneToMany(mappedBy = "account")
    private Set<Bookmark> bookmarks = new HashSet<>();


}
