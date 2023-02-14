package com.example.week5_project5.Controller;

import com.example.week5_project5.ApiException;
import com.example.week5_project5.Model.Book;
import com.example.week5_project5.Services.Book_Service;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class Book_Controller {
    
    private final Book_Service book_service;

    @GetMapping("/get")
    public ResponseEntity getBook(){
        List<Book> books = book_service.getBook();
        return ResponseEntity.status(200).body(books);
    }

    @PostMapping("/add")
    public ResponseEntity addBook(@Valid @RequestBody Book books){
        book_service.addBook(books);
        return ResponseEntity.status(200).body("Book Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBook(@PathVariable Integer id, @Valid @RequestBody Book books) {
        book_service.updateBook(id,books);
        return ResponseEntity.status(200).body("Book updated");

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable Integer id) {
        book_service.deleteBook(id);
        return ResponseEntity.status(200).body("Book deleted");

    }

    //1.Create endpoint that takes storeid and return all the books
    @GetMapping("/books/{store_id}")
    public ResponseEntity findAllBook(@PathVariable Integer store_id) {
        List<Book> book = book_service.findAllBook(store_id);
        return ResponseEntity.status(200).body(book);
    }

    //3.Create endpoint that takes bookId and return number of books available

    @GetMapping("/booknum/{id}")
    public ResponseEntity BooksAvailble(@PathVariable Integer id){
        Book book = book_service.BooksAvailble(id);
        return ResponseEntity.status(200).body(book.getBookCount());
    }

    //4.Create endpoint that takes a book name and return all book information
    @GetMapping("/search/{name}")
    public ResponseEntity findByBookName(@PathVariable String name){
        Book book = book_service.findByBookName(name);
        return ResponseEntity.status(200).body(book);
    }

    //5.Create endpoint that return all books under a specific genre
    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Book>> findByGenre(@PathVariable String genre){
        List<Book> books = book_service.findByGenre(genre);
        return ResponseEntity.status(200).body(books);
    }
}
