package com.signon.repository;

import com.signon.model.Designation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignationRepository extends CrudRepository<Designation, Long> {
}
