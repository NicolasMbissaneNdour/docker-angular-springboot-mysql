package com.example.server.book;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookService {

  private BookRepository repo;

  public Book save(Book book) {
    return repo.save(book);
  }

  public Optional<Book> find(Integer id) {
    return repo.findById(id);
  }

  public List<Book> find() {
    return repo.findAll();
  }

  public Optional<Book> findByTitle(String title) {
    return repo.findByTitle(title);
  }

  public Optional<Book> findByAuthor(String author) {
    return repo.findByAuthor(author);
  }

}
