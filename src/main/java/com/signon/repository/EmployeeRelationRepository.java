package com.signon.repository;

import com.signon.model.EmployeeRelation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRelationRepository extends CrudRepository<EmployeeRelation, Long> {
}
