package com.example.spring_book_app_beks.services;

import com.example.spring_book_app_beks.dto.request.BookSaveRequest;
import com.example.spring_book_app_beks.dto.response.SimpleResponse;
import com.example.spring_book_app_beks.exceptions.BookNotFoundException;
import com.example.spring_book_app_beks.models.Book;
import com.example.spring_book_app_beks.repositories.BookRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Azat Ibraev
 */
@Service
public class BookService {

    private  final BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    public Book findById(Long bookId) {
//        boolean b = bookRepo.existsById(bookId);
//       if (!b) {
//           throw new BookNotFoundException(
//                   "Book with id = " + bookId + " not found"
//           );
//       }
//       return bookRepo.getById(bookId);
        return getBookById(bookId);
    }

        private Book getBookById(Long bookId){
            return bookRepo.findById(bookId).
                    orElseThrow(()-> new BookNotFoundException(
                            "Book with id = " + bookId + " not found"
                    ));

        }


    public Book save(BookSaveRequest bookSaveRequest) {
        Book book =new Book(bookSaveRequest.getName(),
                bookSaveRequest.getAuthor(), bookSaveRequest.getPrice());
       return bookRepo.save(book);

    }

    public SimpleResponse deleteById(Long bookId) {
        boolean existsById = bookRepo.existsById(bookId);
        if(!existsById) {
            throw new BookNotFoundException(
                     "Book with id = " + bookId + " not found!"
            );
        }
        bookRepo.deleteById(bookId);

        return new SimpleResponse(
                "DELETED",
                "Successfully delete book"
        );
    }

    @Transactional
    public Book updateBookById(Long bookId, BookSaveRequest bookSaveRequest) {

        Book book = getBookById(bookId);

        String currentName = book.getName();
        String newName = bookSaveRequest.getName();


        if(newName != null && !currentName.equals(newName)) {
            book.setName(newName);
        }

        String currentAuthorName = book.getAuthor();
        String newAuthorName = bookSaveRequest.getAuthor();
        if(newAuthorName != null && !newAuthorName.equals(currentAuthorName)) {
            book.setAuthor(newAuthorName);
        }

     book.setPrice(bookSaveRequest.getPrice());
        return book;
    }
}
