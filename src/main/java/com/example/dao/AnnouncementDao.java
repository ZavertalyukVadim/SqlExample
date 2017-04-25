package com.example.dao;

import com.example.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AnnouncementDao extends JpaRepository<Announcement,Integer>{
    @Query("SELECT a from Announcement a INNER JOIN a.rents rents where " +
            "0 in  (select count(rent) from Rent rent where a.id=rent.announcement.id " +
            "and not (:#{#localDateTo} < rent.from or :#{#localDateTo} > rent.to) and (:#{#localDateFrom} > rent.from or :#{#localDateFrom} < rent.to)) group by a")
//            "((rents.from>:#{#localDateTo} and rents.to<:#{#localDateFrom}) or (rents.from>:#{#localDateTo} and rents.to<:#{#localDateFrom}) )")
//            "" +
//            " 1 in (select count(rent) from Rent rent where a.id=rent.announcement.id " +
//            "and rent.from>:#{#localDateTo} and rent.to<:#{#localDateFrom})")
    List<Announcement> search(@Param("localDateFrom") LocalDate localDateFrom, @Param("localDateTo") LocalDate localDateTo);
}
