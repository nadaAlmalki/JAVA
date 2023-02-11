package com.example.week5_project5.Repository;

import com.example.week5_project5.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Book_Repository extends JpaRepository<Book, Integer> {
    Book findBookById(Integer id);

    List<Book> getBooksByStoreId(Integer id);

    Book findBookByBookCount(Integer bookcount);

    Book findBookByName(String name);

    Book findBookByGenre(String genre);
}
