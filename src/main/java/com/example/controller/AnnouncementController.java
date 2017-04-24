package com.example.controller;

import com.example.entity.Announcement;
import com.example.entity.Rent;
import com.example.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class AnnouncementController {
    private final AnnouncementService announcementService;

    @Autowired
    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @GetMapping
    public List<Announcement> getAllAnnouncement(){
        return announcementService.getAllAnnouncement();
    }

    @GetMapping(value = "/rent")
    public List<Rent> getAllRents(){
        return announcementService.getAllRents();
    }

    @GetMapping
    @RequestMapping(value = "/test")
    public void addTestData(){
        announcementService.addTestInformations();
    }
}
