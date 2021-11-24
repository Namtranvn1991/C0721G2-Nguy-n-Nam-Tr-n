package com.main.demo.repository;

import com.main.demo.model.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IBorrowBookRepo extends JpaRepository<BorrowBook,Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE book.borrow_book SET `status` = 0 WHERE (id_borrow_book = ?1);", nativeQuery = true)
    void returnBook(Integer id);

}
