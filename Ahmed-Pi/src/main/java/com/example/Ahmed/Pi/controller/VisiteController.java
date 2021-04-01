package com.example.Ahmed.Pi.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
@RequestMapping("/visites")

public class VisiteController {

	@Autowired
	private VisiteRepository visiteRepository;
	@Autowired
	private AgentRespository agentRepository;
	
	@GetMapping("/getAllvisites")
	public List<Visite> getAllVisites() {
		return visiteRepository.findAll();
	}
	
	@GetMapping("/getvisite/{id}")
	public ResponseEntity<Visite> getVisiteById(@PathVariable(value = "id") Long id) {
		Visite visite = visiteRepository.findById(id).get();
		return ResponseEntity.ok().body(visite);
	}

	
	@PostMapping("/createVisite")
	public Visite createVisite( @RequestBody Visite visite) {
		return visiteRepository.save(visite);
	}

	@PutMapping("/approveVisite/{id}")
	public ResponseEntity<Visite> approveVisite(@PathVariable(value = "id") Long id){
		Visite visite = visiteRepository.findById(id).get();

		visite.setStatus(Status.approved);
		
		final Visite updatedVisite = visiteRepository.save(visite);
		return ResponseEntity.ok(updatedVisite);
	}
	
	@PutMapping("/declineVisite/{id}")
	public ResponseEntity<Visite> declineVisite(@PathVariable(value = "id") Long id){
		Visite visite = visiteRepository.findById(id).get();

		visite.setStatus(Status.declined);
		
		final Visite updatedVisite = visiteRepository.save(visite);
		return ResponseEntity.ok(updatedVisite);
	}
	
	@PutMapping("/processVisite/{id}")
	public ResponseEntity<Visite> processVisite(@PathVariable(value = "id") Long id){
		Visite visite = visiteRepository.findById(id).get();

		visite.setStatus(Status.pending);
		
		final Visite updatedVisite = visiteRepository.save(visite);
		return ResponseEntity.ok(updatedVisite);
	}
	

	@DeleteMapping("/deleteVisite/{id}")
	public Map<String, Boolean> deleteVisite(@PathVariable(value = "id") Long id){
		Visite visite = visiteRepository.findById(id).get();

		visiteRepository.delete(visite);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	
	@GetMapping("/getvisiteByAgent/{id}")
	public List<Visite> getvisiteByAgent(@PathVariable(value = "id") Long id) {
		List<Visite> visites = visiteRepository.findVisiteByAgent(id);
		return visites;
	}
	
	@GetMapping("/getvisiteByAgentPaginated/{id}")
	public List<Visite> getvisiteByAgentPaginated(@PathVariable(value = "id") Long id,
			@RequestParam int page, @RequestParam int size) {
		List<Visite> visites = visiteRepository.getVisitesWithPagination(id, PageRequest.of(page,size));
		return visites;
	}

	@PutMapping("/affectAgent/{agentId}/{visiteId}")
	public Visite affectAgent(@PathVariable(value = "agentId") Long agentId,
			@PathVariable(value = "visiteId") Long visiteId){
		Visite visite = visiteRepository.findById(visiteId).get();
		Agent agent = agentRepository.findById(agentId).get();		
		visite.setAgent(agent);
		visiteRepository.save(visite);
		return visite;
	}
	
}
