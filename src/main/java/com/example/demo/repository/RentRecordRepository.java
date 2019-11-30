package com.example.demo.repository;

import com.example.demo.entity.RentRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RentRecordRepository extends JpaRepository<RentRecord,Integer> {
    @Query(value = "select * from rent_record where renter_id = ?1",nativeQuery = true)
    public List<RentRecord> findAllByRenterId(String renter_id);

    @Query(value = "select * from rent_record where rent_id = ?1",nativeQuery = true)
    public List<RentRecord> findByRent_id(int rent_id);

    @Query(value = "select * from rent_record where rent_id = ?1 and status='payed'",nativeQuery = true)
    public RentRecord findPayedRecord(int rent_id);

    @Query(value = "select * from rent_record where rent_id = ?1 and status='confirmed'",nativeQuery = true)
    public RentRecord findconfirmedRecord(int rent_id);

    @Query(value = "select * from rent_record where rent_id = ?1 and status!='canceled' or 'finished'",nativeQuery = true)
    public RentRecord findUncompletedRecord(int rent_id);
}
