package com.example.dao;

import com.example.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnnouncementDao extends JpaRepository<Announcement,Integer>{

    @Query("SELECT a from Announcement a")
    List<Announcement> search(

    );
}
