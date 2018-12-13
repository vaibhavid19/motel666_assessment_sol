package com.motel666.userEventService.repository;

import com.motel666.userEventService.model.UserEvent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserEventRepository extends CrudRepository<UserEvent, Long> {

    @Query("from UserEvent UE where UE.name=:name")
    public List<UserEvent> findByUserName(@Param("name") String name);

    @Query("select u from UserEvent a where u.timestamp <= :toDate AND u.timestamp >= :fromDate")
    List<UserEvent> findAllBetweenTimestamp(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
}
