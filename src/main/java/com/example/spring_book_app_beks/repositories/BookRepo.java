package com.example.spring_book_app_beks.repositories;

import com.example.spring_book_app_beks.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Azat Ibraev
 */
@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
}
