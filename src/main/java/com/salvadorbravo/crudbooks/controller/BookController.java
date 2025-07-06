package com.salvadorbravo.crudbooks.controller;

import com.salvadorbravo.crudbooks.model.Book;
import com.salvadorbravo.crudbooks.services.BookService;
import com.salvadorbravo.crudbooks.services.BookServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.status(HttpStatus.OK).body(books);
    }

    @GetMapping("/{idBook}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer idBook) {
        Book book = bookService.getBookById(idBook);
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        Book newBook = bookService.saveBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBook);
    }

    @PutMapping("/{idBook}")
    public ResponseEntity<Book> updateBook(@PathVariable Integer idBook, @RequestBody Book book) {
        Book updatedBook = bookService.updateBook(idBook, book);
        return ResponseEntity.status(HttpStatus.OK).body(updatedBook);
    }

    @DeleteMapping("/{idBook}")
    public ResponseEntity<Book> deleteBook(@PathVariable Integer idBook) {
        bookService.deleteBook(idBook);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    /*
    @GetMapping
    public Book getBooks() {
        return bookService.validAndReturnBook(1);
    }
     */
}
