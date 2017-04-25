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
            "and not (:#{#localDateTo} < rent.from or :#{#localDateTo} > rent.to) " +
            "and (:#{#localDateFrom} > rent.from or :#{#localDateFrom} < rent.to)) group by a")
    List<Announcement> search(@Param("localDateFrom") LocalDate localDateFrom, @Param("localDateTo") LocalDate localDateTo);

    @Query(value = "select announcements.id,announcements.title,announcements.description, announcements.rooms, announcements.living_places " +
            "from announcements inner join rents  on announcements.id=rents.announcement_id " +
            "where 0 in (select count(rents.id) from rents  " +
            "where announcements.id=rents.announcement_id and :#{#localDateTo}>=rents.from " +
            "and :#{#localDateTo}<=rents.to and (:#{#localDateFrom}>rents.from " +
            "or :#{#localDateFrom}<rents.to)) GROUP BY announcements.id ",nativeQuery = true)
    List<Announcement> searchSql(@Param("localDateFrom") LocalDate localDateFrom, @Param("localDateTo") LocalDate localDateTo);
}
