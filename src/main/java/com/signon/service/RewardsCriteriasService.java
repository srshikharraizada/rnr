package com.signon.service;

import com.signon.model.Criterias;
import com.signon.model.RewardsCriterias;

import java.util.List;
import java.util.Optional;

public interface RewardsCriteriasService {

  /*  Optional<RewardsCriterias> findById(Long rewardId);*/

    RewardsCriterias save(RewardsCriterias rewardsCriterias);


    List<RewardsCriterias> findAll();

 /*   void deleteById(long id);*/
}
