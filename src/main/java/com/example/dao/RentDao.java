package com.example.dao;

import com.example.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface RentDao extends JpaRepository<Rent,Integer>{

//    @Query(value = " SELECT rent from Rent rent where rent.from>:#{#localDateTo} or rent.to<:#{#localDateFrom} ")
//    List<Rent> search(@Param("localDateFrom") LocalDate localDateFrom, @Param("localDateTo") LocalDate localDateTo);
}
