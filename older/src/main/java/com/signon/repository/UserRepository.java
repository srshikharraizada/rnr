package com.signon.repository;

import com.signon.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserInfo,Long> {


    @Query(value = "DELETE from users where email = ?1  ", nativeQuery = true)
    void deleteByemail(String email);


    @Query(value = "SELECT * from users where email = ?1  ", nativeQuery = true)
    Optional<UserInfo> findByemail(String email);
}
