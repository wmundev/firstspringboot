package com.example.demo.Repository;

import com.example.demo.domain.Bookmark;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BookmarkRepository extends JpaRepository <Bookmark, Long> {

    Collection<Bookmark> findByAccountUsername(String username);

}
