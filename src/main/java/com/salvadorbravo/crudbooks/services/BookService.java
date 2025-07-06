package com.salvadorbravo.crudbooks.services;

import com.salvadorbravo.crudbooks.model.Book;

import java.util.List;

public interface BookService {

    // Book validAndReturnBook(int idBook);

    Book saveBook(Book book);
    Book updateBook(Integer idBook, Book book);
    List<Book> getAllBooks();
    Book getBookById(Integer idBook);
    void deleteBook(Integer idBook);
}
