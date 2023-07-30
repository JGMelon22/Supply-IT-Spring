package com.dpi.itsupply.repository;

import com.dpi.itsupply.model.ErroQuiq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErroQuiqRepository extends JpaRepository<ErroQuiq, Integer> {
}
