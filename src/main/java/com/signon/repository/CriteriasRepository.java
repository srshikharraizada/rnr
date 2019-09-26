package com.signon.repository;

        import com.signon.model.Criterias;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.stereotype.Repository;


@Repository
public interface CriteriasRepository extends CrudRepository<Criterias,Long> {
}
