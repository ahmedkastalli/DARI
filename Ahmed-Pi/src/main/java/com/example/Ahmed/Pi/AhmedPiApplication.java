package com.example.Ahmed.Pi;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.Ahmed.Pi.domain.Status;
import com.example.Ahmed.Pi.domain.Visite;
import com.example.Ahmed.Pi.repository.VisiteRepository;



@SpringBootApplication
public class AhmedPiApplication implements CommandLineRunner{
	@Autowired
	private VisiteRepository visiteRepository;

	
	public static void main(String[] args) {
		SpringApplication.run(AhmedPiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub*
//		Visite visite = new Visite() ;
//		
//		visite.setId(10);
//		visite.setStatus(Status.approved);
//		visite.setDate(new Date());
//		visiteRepository.save(visite);
//		
	} 

}
