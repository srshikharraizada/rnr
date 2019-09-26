package com.signon.service.impl;


import com.signon.model.Designation;
import com.signon.model.Rewards;
import com.signon.model.RewardsCriterias;
import com.signon.repository.DesignationRepository;
import com.signon.repository.RewardsCriteriasRepository;
import com.signon.service.RewardsCriteriasService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RewardsCriteriasServiceImpl implements RewardsCriteriasService {

    RewardsCriteriasRepository rewardsCriteriasRepository;


    @Override
    public RewardsCriterias save(RewardsCriterias rewardsCriterias) {
        return rewardsCriteriasRepository.save(rewardsCriterias);
    }

    @Override
    public List<RewardsCriterias> findAll() {
        return (List<RewardsCriterias>) rewardsCriteriasRepository.findAll();
    }

    @Override
    public void deleteById(long id) {

        rewardsCriteriasRepository.deleteById(id);
    }

    @Override
    public Optional<RewardsCriterias> findById(Long rewardid) {
        return rewardsCriteriasRepository.findById(rewardid);
    }
}
