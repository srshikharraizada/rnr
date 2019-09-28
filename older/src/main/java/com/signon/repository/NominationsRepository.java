package com.signon.repository;

import com.signon.model.Nominations;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NominationsRepository extends CrudRepository<Nominations, Long> {
}
