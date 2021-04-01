package com.example.Ahmed.Pi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Ahmed.Pi.domain.Agent;


@Repository
public interface AgentRespository extends JpaRepository<Agent, Long> {

	List<Agent> findByLastName(@Param("name") String name);
}
