package com.salvadorbravo.crudbooks.services;

import com.salvadorbravo.crudbooks.model.Book;
import com.salvadorbravo.crudbooks.model.Category;
import com.salvadorbravo.crudbooks.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book saveBook(Book book) {
        return this.bookRepository.save(book);
    }

    @Override
    public Book updateBook(Integer idBook, Book book) {
        book.setIdBook(idBook);
        return this.bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book getBookById(Integer idBook) {
        return this.bookRepository.findById(idBook).orElse(new Book(999, "Book not found", false, new Category(999, "NO CATEGORY")));
    }

    @Override
    public void deleteBook(Integer idBook) {
        this.bookRepository.deleteById(idBook);
    }



    /*
    @Override
    public Book validAndReturnBook(int idBook) {
        if (idBook > 0) {
            return bookRepository.getBookById(idBook);
        } else {
            return new Book(0, "Invalid Book ID", true);
        }
    }
     */
}
