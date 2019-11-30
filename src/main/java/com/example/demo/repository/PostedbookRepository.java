package com.example.demo.repository;

import com.example.demo.entity.Postedbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostedbookRepository extends JpaRepository<Postedbook,Integer> {
    @Query(value = "select * from postedbook where isbn = ?1 or book_name like CONCAT('%',?2,'%') and status='posted' order by rent_id asc ",nativeQuery = true)
    public List<Postedbook> findAllByIsbnOrBookName(String isbn,String book_name);
    @Query(value = "select * from postedbook where rent_user_id=?1 and status!='deleted'",nativeQuery = true)
    public List<Postedbook> findAllByRent_user_id(String rent_user_id);
}
