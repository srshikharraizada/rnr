package com.signon.service.impl;

import com.signon.model.Rewards;
import com.signon.repository.RewardsRepository;
import com.signon.service.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RewardsServiceImpl implements RewardsService {

    @Autowired
    private RewardsRepository rewardsRepository;

    @Override
    public Rewards save(Rewards rewards) {
        return rewardsRepository.save(rewards);
    }

    @Override
    public List<Rewards> findAll() {
        return (List<Rewards>) rewardsRepository.findAll();
    }

    @Override
    public void deleteById(long id) {

        rewardsRepository.deleteById(id);
    }

    @Override
    public Optional<Rewards> findById(Long id) {
        return rewardsRepository.findById(id);
    }

    @Override
    public List<Rewards> findByDiscontinued() {
        return rewardsRepository.findByDiscontinued();
    }

    @Override
    public List<Rewards> findByNominationClosed() {
        return rewardsRepository.findByNominationClosed();
    }

    @Override
    public List<Rewards> findByRolled() {
        return rewardsRepository.findByRolled();
    }


    @Override
    public Rewards Update(Long id, Rewards createreward)
    {
        Rewards Createaward1=rewardsRepository.findById(id).get();
        Createaward1.setReward_name(createreward.getReward_name());
        Createaward1.setFrequency(createreward.getFrequency());
        Createaward1.setDescription(createreward.getDescription());
        Createaward1.setStart_date(createreward.getStart_date());
        Createaward1.setEnd_date(createreward.getEnd_date());
        Createaward1.setAward_status(createreward.getAward_status());
        Createaward1.setDiscontinuingDate(createreward.getDiscontinuingDate());
        Createaward1.setDiscontinuingReason(createreward.getDiscontinuingReason());
        Createaward1.setCriterias(createreward.getCriterias());
        Createaward1.setSelf_nominate(createreward.isSelf_nominate());
        Createaward1.setNominations_allowed(createreward.getNominations_allowed());

        Rewards update= rewardsRepository.save(Createaward1);
        return update;
    }

    @Override
    public Rewards updateAwardStatus(Long id, Rewards createreward)
    {
        Rewards Createaward1=rewardsRepository.findById(id).get();
        Createaward1.setReward_name(Createaward1.getReward_name());
        Createaward1.setFrequency(Createaward1.getFrequency());
        Createaward1.setDescription(Createaward1.getDescription());
        Createaward1.setStart_date(Createaward1.getStart_date());
        Createaward1.setEnd_date(Createaward1.getEnd_date());
        Createaward1.setDiscontinuingDate(Createaward1.getDiscontinuingDate());
        Createaward1.setDiscontinuingReason(Createaward1.getDiscontinuingReason());
        Createaward1.setCriterias(Createaward1.getCriterias());
        Createaward1.setSelf_nominate(Createaward1.isSelf_nominate());
        Createaward1.setNominations_allowed(Createaward1.getNominations_allowed());
        Createaward1.setAward_status(createreward.getAward_status());

        Rewards update= rewardsRepository.save(Createaward1);
        return update;
    }



}
