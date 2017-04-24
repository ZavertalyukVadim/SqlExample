package com.example.dao;

import com.example.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementDao extends JpaRepository<Announcement,Integer>{
}
