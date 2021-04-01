package com.example.Ahmed.Pi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ahmed.Pi.domain.Agent;
import com.example.Ahmed.Pi.domain.Status;
import com.example.Ahmed.Pi.domain.Visite;
import com.example.Ahmed.Pi.repository.AgentRespository;
import com.example.Ahmed.Pi.repository.VisiteRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/agents")

public class AgentController {
	@Autowired
	private AgentRespository agentRepository;
	
	@GetMapping("/getAllagents")
	public List<Agent> getAllVisites() {
		return agentRepository.findAll();
	}
	
	@GetMapping("/getAgent/{id}")
	public ResponseEntity<Agent> getVisiteById(@PathVariable(value = "id") Long id) {
		Agent agent = agentRepository.findById(id).get();
		return ResponseEntity.ok().body(agent);
	}

	
	@PostMapping("/createAgent")
	public Agent createAgent( @RequestBody Agent agent) {
		return agentRepository.save(agent);
	}

	@PutMapping("/updateAgent/{id}")
	public ResponseEntity<Agent> updateContract(@PathVariable(value = "id") Long id,
			@RequestParam String contract){
		Agent agent = agentRepository.findById(id).get();

		agent.setContract(contract);
		
		final Agent updatedAgent = agentRepository.save(agent);
		return ResponseEntity.ok(updatedAgent);
	}
	


	@DeleteMapping("/deleteAgent/{id}")
	public Map<String, Boolean> deleteAgent(@PathVariable(value = "id") Long id){
		Agent agent = agentRepository.findById(id).get();

		agentRepository.delete(agent);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	
	
	@GetMapping("/searchAgent/{name}")
	public List<Agent> searchAgent(@PathVariable(value = "name") String name) {
		List<Agent> agents = agentRepository.findByLastName(name);
		return agents;
	}
}