package com.example.week5_project5.Services;

import com.example.week5_project5.ApiException;
import com.example.week5_project5.Model.Book;
import com.example.week5_project5.Model.Store;
import com.example.week5_project5.Repository.Book_Repository;
import com.example.week5_project5.Repository.Store_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Book_Service {
    private final Book_Repository book_repository;
    private final Store_Repository store_repository;
    public List<Book> getBook(){
        return book_repository.findAll();
    }
    public void addBook(Book books){
        book_repository.save(books);
    }

    public void updateBook(Integer id , Book books){
        Book book= book_repository.findBookById(id);
        if(book == null) {
            throw new ApiException("Book not found");
        }
       book.setName(books.getName());
        book.setBookCount(books.getBookCount());
        book.setGenre(books.getGenre());
        book_repository.save(book);
    }

    public void deleteBook(Integer id){
        Book books= book_repository.findBookById(id);
        if(books == null) {
            throw new ApiException("Book not found");
        }
        book_repository.deleteById(id);
    }


    //1.Create endpoint that takes storeid and return all the books
    public List<Book> findAllBook(Integer store_id){
        Store store = store_repository.findStoreById(store_id);
        if (store == null) {
            throw new ApiException("Wrong Data");
        }
        return book_repository.getBooksByStoreId(store_id);
    }

    //3.Create endpoint that takes bookId and return number of books available

    public Book BooksAvailble(Integer id){
        Book books= book_repository.findBookById(id);
        if (books == null && books.getId()== id ) {
            throw new ApiException("Wrong id");
        }
        return book_repository.findBookByBookCount(books.getBookCount());

    }

        //4.Create endpoint that takes a book name and return all book information
        public Book findByBookName(String name){
            Book book = book_repository.findBookByName(name);
            if(book == null){
                throw new ApiException("Incorrect Input");
            }
            return book;
        }

        //5.Create endpoint that return all books under a specific genre
        public List<Book> findByGenre(String genre){
           List<Book> books = (List<Book>) book_repository.findBookByGenre(genre);

            if (books == null){
                throw new ApiException("Incorrect Input");
            }
           return books;
        }


}