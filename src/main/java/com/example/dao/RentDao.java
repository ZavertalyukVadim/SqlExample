package com.example.dao;

import com.example.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentDao extends JpaRepository<Rent,Integer>{
}
