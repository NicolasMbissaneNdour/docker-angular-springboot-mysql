package com.example.server.book;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/book")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
public class BookController {
  private  BookService bookService;

  @GetMapping
  public ResponseEntity<List<Book>> get() {
    return ResponseEntity.ok(bookService.find());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Book> getById(@PathVariable Integer id) {
    var book = bookService.find(id);
    if (book.isPresent()) {
      return ResponseEntity.ok(book.get());
    }

    return ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<Book> post(@RequestBody Book book) {
    return ResponseEntity.ok(bookService.save(book));
  }

}
