package com.example.Ahmed.Pi.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Ahmed.Pi.domain.Status;
import com.example.Ahmed.Pi.domain.Visite;


@Repository
public interface VisiteRepository  extends JpaRepository<Visite, Long>{

	@Query("SELECT p FROM Visite p WHERE p.agent.id = :id")
	List<Visite> findVisiteByAgent(@Param("id") Long id);	
	
	@Query("SELECT p FROM Visite p WHERE p.agent.id = :id")
	List<Visite> getVisitesWithPagination(@Param("id") Long id,Pageable pageableRequest);	
	
	@Query("SELECT p FROM Visite p WHERE p.agent.id = :id")
	void  postponeVisite();
}
