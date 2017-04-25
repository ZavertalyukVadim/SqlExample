package com.example.service;

import com.example.dao.AnnouncementDao;
import com.example.dao.RentDao;
import com.example.entity.Announcement;
import com.example.entity.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AnnouncementService {
    private final AnnouncementDao announcementDao;
    private final RentDao rentDao;

    @Autowired
    public AnnouncementService(AnnouncementDao announcementDao, RentDao rentDao) {
        this.announcementDao = announcementDao;
        this.rentDao = rentDao;
    }

    public List<Announcement> getAllAnnouncement() {
        return announcementDao.findAll();
    }

    public List<Rent> getAllRents() {
        return rentDao.findAll();
    }

    public void addTestInformation() {
        Announcement announcement = new Announcement();
        announcement.setDescription("Description");
        announcement.setLivingPlaces(1);
        announcement.setRooms(1);
        announcement.setTitle("Title");
        announcementDao.save(announcement);
        Rent rent = new Rent();
        rent.setAnnouncement(announcement);
        rent.setFrom(LocalDate.of(2017, 4, 10));
        rent.setTo(LocalDate.of(2017, 4, 15));
        rentDao.save(rent);
        Rent rent1 = new Rent();
        rent1.setAnnouncement(announcement);
        rent1.setFrom(LocalDate.of(2017, 4, 20));
        rent1.setTo(LocalDate.of(2017, 4, 25));
        rentDao.save(rent1);
        Rent rent2 = new Rent();
        rent2.setAnnouncement(announcement);
        rent2.setFrom(LocalDate.of(2017, 4, 25));
        rent2.setTo(LocalDate.of(2017, 4, 30));
        rentDao.save(rent2);
    }

    public List<Announcement> search() {
        return announcementDao.searchSql(LocalDate.of(2017, 4, 16), LocalDate.of(2017, 4, 18));
    }
}
