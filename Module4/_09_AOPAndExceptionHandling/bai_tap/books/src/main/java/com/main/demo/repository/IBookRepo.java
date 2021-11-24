package com.main.demo.repository;

import com.main.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IBookRepo extends JpaRepository<Book,Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE book SET quantity = quantity-1 WHERE (book_id = :id);", nativeQuery = true)
    void borrowBook(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE book SET quantity = quantity+1 WHERE (book_id = :id);", nativeQuery = true)
    void returnBook(@Param("id") Integer id);
}
