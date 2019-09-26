package com.signon.service.impl;

import com.signon.dto.NominationPojo;
import com.signon.model.Evidences;
import com.signon.model.Nominations;
import com.signon.repository.EvidencesRepository;
import com.signon.repository.NominationsRepository;
import com.signon.service.NominationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Service
@Transactional
public class NominationsServiceImpl implements NominationsService {

    @Autowired
    NominationsRepository nominationsRepository;
    @Autowired
    EvidencesRepository evidencesRepository;

    @Override
    public ResponseEntity<?> nominationsave(NominationPojo nominationPojo) {
        Nominations nominations = new Nominations();
        nominations.setUserid(nominationPojo.getUserId());
        nominations.setFrequency(nominationPojo.getFrequency());
        nominations.setRewardID(nominationPojo.getRewardId());
        nominations.setEndingdate(nominationPojo.getEndingDate());
        nominations.setStartingdate(nominationPojo.getStartDate());
        nominations.setProjectname(nominationPojo.getProjectName());

        nominations = nominationsRepository.save(nominations);

         long nominationId = nominations.getNominationID();


        Evidences evidences = new Evidences();
        System.out.println(nominationPojo.getEvidencesPojoList().size());

        for(int i=0; i<nominationPojo.getEvidencesPojoList().size(); i++) {
            evidences = new Evidences();

            evidences.setNominationId(nominationId);
            evidences.setCriterianame(nominationPojo.getEvidencesPojoList().get(i).getCriteriaName());
            evidences.setEvidences(nominationPojo.getEvidencesPojoList().get(i).getEvidences());

            evidencesRepository.save(evidences);
        }


        HashMap<String,Object> s=new HashMap<>();
        s.put("evidences",evidences);
        s.put("nominations",nominations);
        Object returnValue=s;

        return ResponseEntity.ok(s);
    }

}
