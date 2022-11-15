package kodlama.io.kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.kodlama.io.Devs.business.requests.CreateLanguageRequest;
import kodlama.io.kodlama.io.Devs.business.requests.DeleteLanguageRequest;
import kodlama.io.kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import kodlama.io.kodlama.io.Devs.business.responses.GetAllLanguagesResponse;

@RestController // springden gelir //annotation //bilgilendirme
@RequestMapping("/api/languages") // iletişim //adres
public class LangugagesController {
	private LanguageService languageService; // business

	@Autowired // kim implemente ediyor bak newle
	public LangugagesController(LanguageService languageService) {
		this.languageService = languageService;
	}

	@GetMapping("/getall")
	public List<GetAllLanguagesResponse> getAll() {
		return languageService.getAll();
	}

	@PostMapping("/add")
	public void add(CreateLanguageRequest createLanguageRequest) {
		this.languageService.add(createLanguageRequest);
	}

	@DeleteMapping("/delete")
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {
		this.languageService.delete(deleteLanguageRequest);
	}

	@PutMapping("/update")
	public void update(UpdateLanguageRequest updateLanguageRequest,int id) {
		this.languageService.update(updateLanguageRequest,id);
	}

	/*
	 * @PostMapping("/add") public void create(Language language, int id) throws
	 * Exception {
	 * 
	 * languageService.create(language, id); }
	 * 
	 * @DeleteMapping("/delete") public void delete(int id) {
	 * 
	 * languageService.delete(id); }
	 * 
	 * @PutMapping("/update") public void update(Language language, int id) {
	 * 
	 * languageService.update(language, id); }
	 */
}
