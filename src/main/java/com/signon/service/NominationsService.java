package com.signon.service;

import com.signon.dto.NominationPojo;
import org.springframework.http.ResponseEntity;

public interface NominationsService {

    ResponseEntity<?> nominationsave(NominationPojo nominationPojo);

}
