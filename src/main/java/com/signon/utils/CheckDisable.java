package com.signon.utils;

import com.signon.model.Nominations;
import com.signon.model.Rewards;
import com.signon.repository.NominationsRepository;
import com.signon.repository.RewardsRepository;
import com.signon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;


public class CheckDisable {

    @Autowired
    private RewardsRepository rewardsRepository;

    @Autowired
    private NominationsRepository nominationsRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Rewards> checkForDisable(String email) {


        String user_id = userRepository.getIdByEmail(email);

        /*ArrayList<Nominations> listOfNominations = (ArrayList<Nominations>) nominationsRepository.findAll();

        int i = 0;
        while (i < listOfNominations.size()) {
            Nominations nominations = listOfNominations.get(i);
            long nomination_id = nominations.getNominationID();

            ArrayList<Rewards> listOfRewards = (ArrayList<Rewards>) rewardsRepository.findAll();
            int j = 0;
            while (j < listOfRewards.size()) {

//             */  // Rewards reward = listOfRewards.get(j);
//                long reward_id = reward.getId();

//                long checkedId=nominationsRepository.getNominationId( user_id,  reward_id);
//
//                if(nomination_id==checkedId){
//
//                    nominations.setDisable(true);
//                }
//                j++;
//
//                nominationsRepository.findAllById()
//                return
                nominationsRepository.setDisable(user_id);

                List<Rewards> list = nominationsRepository.getRewards();


        return list;
    }

}
