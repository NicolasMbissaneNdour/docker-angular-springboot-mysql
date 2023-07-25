import { Injectable } from '@angular/core';
import { Book } from '../entity/book';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  private  url = "http://localhost:8080/book";

  books: Book[] = [];
  bookSubject: Subject<Book[]> = new Subject<Book[]>();

  constructor(private http: HttpClient) { }

  public async get() {
    this.http.get(this.url).subscribe({
      next: (v) => this.books = <Book[]> v,
      error: (e) => this.books = [],
      complete: () => this.emmitBookSubject()
    })
  }

  public async post(book: Book) {
    this.http.post(this.url,book).subscribe({
      next: (v) => this.books.push(<Book> v),
      error: (e) => console.log(e),
      complete: () => this.emmitBookSubject()
    })
  }

  public emmitBookSubject() {
    this.bookSubject.next(this.books);
  }

}
