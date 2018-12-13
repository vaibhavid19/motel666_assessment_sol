package com.motel666.userEventService.repository;

import com.motel666.userEventService.model.UserEvent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserEventRepository extends CrudRepository<UserEvent, Long> {

    /*Iterable<Visit> findAllByStatusOrStatusAndRegisterDateGreaterThan(VisitStatus status1,
                                                                      VisitStatus status2,
                                                                      Date date);

    Iterable<Visit> findAllByStatusAndRegisterDateGreaterThan(VisitStatus status,
                                                              Date date);

    Optional<Visit> findFirstByPhoneNumberAndRegisterDateGreaterThan(Long phoneNumber,
                                                                     Date date);*/

    @Query("from UserEvent UE where UE.name=:name")
    public List<UserEvent> findByUserName(@Param("name") String name);

    //@Query("from Item i where i.id=:id AND i.name=:name")
    //public Optional<Item> findByItemNameAndId(@Param("id") int id, @Param("name") String name);
}
