package com.library.management.controller;

import com.library.management.dto.BookRequest;
import com.library.management.dto.BookResponse;
import com.library.management.service.BookService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService=bookService;
    }
    @PostMapping
    public BookResponse createBook(@RequestBody BookRequest bookRequest){
        return bookService.createBook(bookRequest);
    }

    @GetMapping
    public List<BookResponse> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PutMapping("/{id}")
    public BookResponse updateBook(@PathVariable Long id, @RequestBody BookRequest bookRequest){
        return bookService.updateBook(id, bookRequest);
    }

    @GetMapping("/{id}")
    public BookResponse getBookById(@PathVariable Long id){
       return  bookService.getBookById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

}
