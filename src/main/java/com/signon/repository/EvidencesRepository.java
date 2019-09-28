package com.signon.repository;

import com.signon.model.Evidences;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EvidencesRepository extends CrudRepository<Evidences, List> {
}
