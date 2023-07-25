package com.example.server.book;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>{
  public Optional<Book> findByTitle(String title);
  public Optional<Book> findByAuthor(String author);

}
