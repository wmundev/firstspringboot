package com.example.demo.Repository;

import com.example.demo.domain.Bookmark;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarkRepository extends CrudRepository<Bookmark, Long> {

    Bookmark findByAccountUsername(String username);

}
