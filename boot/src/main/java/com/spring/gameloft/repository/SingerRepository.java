package com.spring.gameloft.repository;

import com.spring.gameloft.domain.Singer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface SingerRepository extends JpaRepository<Singer, Long> {
    //this interface has to be named like: <EntityName>Repository

    List<Singer> findAllByLastName(String lastName);

    @Query("Select s from Singer s WHERE s.firstName = :firstName")
    Stream<Singer> findAllByFirstName(@Param("firstName") String firstName);

    @Query(nativeQuery = true, value = "select * from singer")
    List<Singer> getSingersWithNatvieQuery();

    @Query("update Singer s set s.firstName = s.firstName + 'updated' where s.albums is not null")
    @Modifying
    int updateSinger();



}