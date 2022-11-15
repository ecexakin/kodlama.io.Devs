package kodlama.io.kodlama.io.Devs.webApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import kodlama.io.kodlama.io.Devs.business.abstracts.TechnologyService;
import kodlama.io.kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import kodlama.io.kodlama.io.Devs.business.requests.DeleteTechnologyRequest;
import kodlama.io.kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import kodlama.io.kodlama.io.Devs.business.responses.GetAllTechnologiesResponse;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {
	private TechnologyService technologyService;

	@Autowired
	public TechnologiesController(TechnologyService technologyService) {

		this.technologyService = technologyService;
	}
	
	@GetMapping("/getall")
	public List<GetAllTechnologiesResponse> getAll(){
		return technologyService.getAll();
	}
	@PostMapping("/add")
	public void add(CreateTechnologyRequest createTechnologyRequest) {
		this.technologyService.add(createTechnologyRequest);
	}
	@DeleteMapping("/delete")
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		this.technologyService.delete(deleteTechnologyRequest);
	}
	
	@PutMapping("/update")
	
	public void update(UpdateTechnologyRequest updateTechnologyRequest,int id) {
		this.technologyService.update(updateTechnologyRequest, id);
	}
	
	
	
	
	
}
