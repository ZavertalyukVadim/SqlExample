package com.example.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "rents")
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "`from`")
    private LocalDate from;

    @Column(name = "`to`")
    private LocalDate to;

    @Column(name = "announcement_id")
    private Integer announcementsId;

    public Integer getAnnouncementsId() {
        return announcementsId;
    }

    public void setAnnouncementsId(Integer announcementsId) {
        this.announcementsId = announcementsId;
    }

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }
}
