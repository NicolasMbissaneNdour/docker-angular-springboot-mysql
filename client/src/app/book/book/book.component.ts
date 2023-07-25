import { Component } from '@angular/core';
import { BookService } from '../service/book.service';
import { Subscription } from 'rxjs';
import { Book } from '../entity/book';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.scss']
})
export class BookComponent {
  books: Book[] = [];
  bookSubs = this.bookService.bookSubject.subscribe(
    (value) => {
      this.books = value
    }
  );

  form: FormGroup = this.fb.group({
    title: new FormControl('',Validators.required),
    author: new FormControl('',Validators.required)
  })

  constructor(private bookService: BookService,private fb: FormBuilder) {}

  ngOnInit(): void {
    this.bookService.emmitBookSubject();
    this.bookService.get();
  }

  async onAdd() {
    await this.bookService.post(this.form.value);
    this.form.reset()
  }
}
