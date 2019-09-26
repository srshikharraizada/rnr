package com.signon.repository;

import com.signon.model.Rewards;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RewardsRepository extends CrudRepository<Rewards, Long> {


    @Query(value = "SELECT * FROM createreward WHERE award_status = 1",
            nativeQuery=true)
    List<Rewards> findByRolled();

    @Query(value = "SELECT * FROM createreward WHERE award_status = 2",
            nativeQuery=true)
    List<Rewards> findByNominationClosed();

    @Query(value = "SELECT * FROM createreward WHERE award_status = 3",
            nativeQuery=true)
    List<Rewards> findByDiscontinued();

    @Transactional
    @Modifying
    @Query(value = "Update rewards set regenerated=false where id=?1", nativeQuery = true)
    void updateToNull(long id);
}
