package com.signon.repository;

import com.signon.model.Nominations;
import com.signon.model.Rewards;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NominationsRepository extends CrudRepository<Nominations, String> {

    @Query(value = "select nomination_id from nominations where user_id=?1, rewardid=?2", nativeQuery = true)
    public long getNominationId(String user_id,long reward_id);


    @Query(value = "update nominations set disable=true where user_id=?1 ",nativeQuery = true)
    void setDisable(String user_id);


    @Query(value = "select * from rewards where id in(select rewardid from nominations where disable=false )",nativeQuery = true)
    List<Rewards> getRewards();

}
