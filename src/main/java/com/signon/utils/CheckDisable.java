package com.signon.utils;

import com.signon.model.Rewards;
import com.signon.repository.NominationsRepository;
import com.signon.repository.RewardsRepository;
import com.signon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

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

              nominationsRepository.setDisable(user_id);

              List<Rewards> list = nominationsRepository.getRewards();


        return list;
    }

}
