package com.signon.service.impl;

import com.signon.enums.FrequencyEnum;
import com.signon.model.Rewards;
import com.signon.model.RewardsCriterias;
import com.signon.repository.RewardsCriteriasRepository;
import com.signon.repository.RewardsRepository;
import com.signon.service.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class RewardsServiceImpl implements RewardsService {

    @Autowired
    private RewardsRepository rewardsRepository;

    @Autowired
    private RewardsCriteriasRepository rewardsCriteriasRepository;



    String[] monthName = {"January", "February",
            "March", "April", "May", "June", "July",
            "August", "September", "October", "November",
            "December"};

    Calendar cal = Calendar.getInstance();
    String month = monthName[cal.get(Calendar.MONTH)];

    String year = String.valueOf(cal.get(Calendar.YEAR));


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
    public Rewards Update(Long id, Rewards createreward) {
        Rewards Createaward1 = rewardsRepository.findById(id).get();
        Createaward1.setReward_name(createreward.getReward_name());
        Createaward1.setFrequency(createreward.getFrequency());
        Createaward1.setDescription(createreward.getDescription());
        Createaward1.setStart_date(createreward.getStart_date());
        Createaward1.setEnd_date(createreward.getEnd_date());
        Createaward1.setAward_status(createreward.getAward_status());
        Createaward1.setDiscontinuingDate(createreward.getDiscontinuingDate());
        Createaward1.setDiscontinuingReason(createreward.getDiscontinuingReason());
        Createaward1.setSelf_nominate(createreward.isSelf_nominate());
        Createaward1.setNominations_allowed(createreward.getNominations_allowed());

        Rewards update = rewardsRepository.save(Createaward1);
        return update;
    }

    @Override
    public Rewards updateAwardStatus(Long id, Rewards createreward) {
        Rewards Createaward1 = rewardsRepository.findById(id).get();
        Createaward1.setReward_name(Createaward1.getReward_name());
        Createaward1.setFrequency(Createaward1.getFrequency());
        Createaward1.setDescription(Createaward1.getDescription());
        Createaward1.setStart_date(Createaward1.getStart_date());
        Createaward1.setEnd_date(Createaward1.getEnd_date());
        Createaward1.setDiscontinuingDate(Createaward1.getDiscontinuingDate());
        Createaward1.setDiscontinuingReason(Createaward1.getDiscontinuingReason());
        Createaward1.setSelf_nominate(Createaward1.isSelf_nominate());
        Createaward1.setNominations_allowed(Createaward1.getNominations_allowed());
        Createaward1.setAward_status(createreward.getAward_status());

        Rewards update = rewardsRepository.save(Createaward1);
        return update;
    }


    @Override
    public Rewards discontinuing(Long id, Rewards createreward) {
        Rewards Createaward1 = rewardsRepository.findById(id).get();
        Createaward1.setReward_name(Createaward1.getReward_name());
        Createaward1.setFrequency(Createaward1.getFrequency());
        Createaward1.setDescription(Createaward1.getDescription());
        Createaward1.setStart_date(Createaward1.getStart_date());
        Createaward1.setEnd_date(Createaward1.getEnd_date());
        Createaward1.setDiscontinuingDate(createreward.getDiscontinuingDate());
        Createaward1.setDiscontinuingReason(createreward.getDiscontinuingReason());
        Createaward1.setSelf_nominate(Createaward1.isSelf_nominate());
        Createaward1.setNominations_allowed(Createaward1.getNominations_allowed());
        Createaward1.setAward_status(createreward.getAward_status());

        Rewards update = rewardsRepository.save(Createaward1);
        return update;
    }

    public ResponseEntity<?> rewardsSave(Rewards rewards) {



        if(rewards.getFrequency()== FrequencyEnum.Annually)
            rewards.setReward_name(rewards.getReward_name()+" for year " + year);

        else
            rewards.setReward_name(rewards.getReward_name()+" for month " + month);

        Rewards rewardData= save(rewards);

        long id = rewards.getId();

        RewardsCriterias rewardsCriterias=new RewardsCriterias();
        System.out.println(rewards.getCriterias().size());

        for(int i=0; i<rewards.getCriterias().size(); i++){
            rewardsCriterias = new RewardsCriterias();

            rewardsCriterias.setRewardId(id);
            rewardsCriterias.setCriteriaId(rewards.getCriterias().get(i).getCriteriaId());
            rewardsCriterias.setCompulsory(rewards.getCriterias().get(i).getCompulsory());

            rewardsCriteriasRepository.save(rewardsCriterias);
        }

        HashMap<String,Object> s=new HashMap<>();
        s.put("criterias",rewardsCriterias);
        s.put("rewards",rewards);
        Object returnValue=s;
        return ResponseEntity.ok(s);
    }
/*

    @Override
    public Rewards function(Rewards reward) {
        Rewards rewardData = save(reward);
        System.out.println("Reward:" + reward.getId());
*/





//        RewardsCriteriasId rewardsCriteriasId = new RewardsCriteriasId();
//        System.out.println(reward.getCriterias().size());
//
///*        for(int i=0;i<reward.getCriterias().size();i++){
//            rewardsCriterias = new RewardsCriterias();
//
//            rewardsCriterias.setCriterias(reward.getCriterias());
//
//        }*/
//        RewardsCriterias rewardsCriterias;
//
//        long id = reward.getId();
//
//        for (Iterator<RewardsCriterias> it = reward.getCriterias().iterator(); it.hasNext(); ) {
//            RewardsCriterias f = it.next();
//            RewardsCriterias d = new RewardsCriterias();
////            rewardsCriteriasId = new RewardsCriteriasId();
//            System.out.println("Reward:" + f.getCriterias().getCriteriaId());
//
//            Criterias c = f.getCriterias();
//            Rewards r = f.getRewards();
//            Boolean b = f.getCompulsory();
//
//             new RewardsCriterias(r, c, b);

//            d.setCriterias(f.getCriterias());


//            rewardsCriteriasRepository.save(d);


//        }


//
//        RewardsCriterias rewardsCriterias = new RewardsCriterias();

        /*for (long i = 0; i < reward.getCriterias().size(); i++) {
            rewardsCriterias = new RewardsCriterias();


            rewardsCriterias.setRewardId(id);
            rewardsCriterias.setCriteriaId(reward.getCriterias().getClass().get);
        }*/
//
////        Set<Criterias> rewardsCriterias1=reward.getCriterias();
////        rewardsCriterias.setRewardId(reward.getId());
//////        rewardsCriterias.setCriteriaId(rewardsCriterias1.);
////        System.out.println(" "+rewardsCriterias1.getClass());
        }

//            return save(reward);


