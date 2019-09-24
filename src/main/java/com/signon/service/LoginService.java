package com.signon.service;


import com.signon.model.UserInfo;

import java.util.List;
import java.util.Optional;

public interface LoginService {

    String login(String token) throws Exception;

    Optional<UserInfo> findById(Long id);

    Optional<UserInfo> findByemail(String email);

    UserInfo saveLogin(UserInfo userInfo);

    List<UserInfo> findAll();

    void deleteById(Long id);

    void deleteByemail(String email);


}
