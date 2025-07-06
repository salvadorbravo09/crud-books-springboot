package com.salvadorbravo.crudbooks.repository;

import com.salvadorbravo.crudbooks.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    // Book getBookById(int idBook);
}
