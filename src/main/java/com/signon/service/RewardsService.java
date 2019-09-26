package com.signon.service;

import com.signon.model.Rewards;

import java.util.List;
import java.util.Optional;

public interface RewardsService {

    public Rewards Update(Long id, Rewards createreward);

    public Rewards updateAwardStatus(Long id, Rewards createreward);

    Optional<Rewards> findById(Long id);

    Rewards save(Rewards rewards);

    List<Rewards> findAll();

    void deleteById(long id);

    List<Rewards> findByDiscontinued();

    List<Rewards> findByNominationClosed();

    List<Rewards> findByRolled();

    Rewards function(Rewards reward);

}
