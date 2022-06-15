package com.example.spring_book_app_beks.dto.apis;

import com.example.spring_book_app_beks.dto.request.BookSaveRequest;
import com.example.spring_book_app_beks.dto.response.SimpleResponse;
import com.example.spring_book_app_beks.models.Book;
import com.example.spring_book_app_beks.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Azat Ibraev
 */
@RestController
@RequestMapping("api/books")
@CrossOrigin
public class BookApi {

    private final BookService bookService;

    public BookApi(BookService bookService) {
        this.bookService = bookService;
    }

    //methods
    //findAll
    @GetMapping
    public List<Book> findAllBooks() {
        return bookService.findAll();
    }


    // findById
    @GetMapping("/find/{bookId}")
    public Book findById(@PathVariable Long bookId) {
        return bookService.findById(bookId);
    }

    //save
    @PostMapping("/save")
    public Book save(@RequestBody BookSaveRequest bookSaveRequest) {
        return bookService.save(bookSaveRequest);
    }

    //delete
    @DeleteMapping("/delete/{bookId}")
    public SimpleResponse deleteBookById(@PathVariable Long bookId) {
        return bookService.deleteById(bookId);
    }

    //update
    @PutMapping("/update/{bookId}")
    public Book updateBookById(@PathVariable Long bookId,
                               @RequestBody BookSaveRequest bookSaveRequest) {
        return bookService.updateBookById(bookId,bookSaveRequest);

    }
}
