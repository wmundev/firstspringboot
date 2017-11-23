package com.example.demo.Controller;


import com.example.demo.Repository.AccountRepository;
import com.example.demo.Repository.BookmarkRepository;
import com.example.demo.domain.Bookmark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping
public class BookmarkRestController {

    AccountRepository accountRepository;
    BookmarkRepository bookmarkRepository;

    @Autowired
    BookmarkRestController(AccountRepository accountRepository, BookmarkRepository bookmarkRepository){
        this.accountRepository = accountRepository;
        this.bookmarkRepository = bookmarkRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    Collection<Bookmark> readBookmarks(@PathVariable String userId){
        this.validateUser(userId);
    }

    private void validateUser(String userId){
        this.accountRepository.findByUserName(userId).orElseThrow(() -> new UserNotFoundException(userId));
    }


}
