package kodlama.io.kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.kodlama.io.Devs.business.requests.CreateLanguageRequest;
import kodlama.io.kodlama.io.Devs.business.requests.DeleteLanguageRequest;
import kodlama.io.kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import kodlama.io.kodlama.io.Devs.business.responses.GetAllLanguagesResponse;
import kodlama.io.kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.kodlama.io.Devs.entities.Language;


@Service //otomatik newle // business nesnesi
public class LanguageManager implements LanguageService {

	private LanguageRepository languageRepository;

	
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public List<GetAllLanguagesResponse> getAll() {
		List<Language> languages = languageRepository.findAll();
		List<GetAllLanguagesResponse> languagesResponse = new ArrayList<GetAllLanguagesResponse>();
		
		
		for (Language language : languages) {
			GetAllLanguagesResponse responseItem = new GetAllLanguagesResponse();
			responseItem.setId(language.getId());
			responseItem.setName(language.getName());
			languagesResponse.add(responseItem);
		}
		return languagesResponse;
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) {
		Language language = new Language();
		language.setName(createLanguageRequest.getName());
		this.languageRepository.save(language);
		
	}


	

	/*
	 * @Override public void update(UpdateLanguageRequest updateLanguageRequest,int
	 * id) { Language updatedLanguage = languageRepository.findById(id).get() ;
	 * updatedLanguage.setName(updateLanguageRequest.);
	 * languageRepository.save(updatedLanguage);
	 * 
	 * }
	 */

	@Override
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {
		Language deletedLanguage = new Language();
		deletedLanguage.setId(deleteLanguageRequest.getId());
		this.languageRepository.delete(deletedLanguage);
		
	}

	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest, int id) {
		List<Language> languages = languageRepository.findAll();
		for (Language language : languages) {
			if (updateLanguageRequest.getId()==language.getId()) {
				language.setName(updateLanguageRequest.getName());
				this.languageRepository.save(language);
				
			} else {
				System.out.println("Güncelleme başarısız!");
			}
			
		}
		
	}
 

	/*
	 * @Override public void delete(CreateLanguageRequest createLanguageRequest) {
	 * languageRepository.delete(createLanguageRequest.);
	 * 
	 * }
	 */

	/*
	 * @Override public void delete(int id) { languageRepository.delete(id); }
	 * 
	 * @Override public void update(Language language, int id) {
	 * languageRepository.update(language, id); }
	 * 
	 * @Override public void create(Language language, int id) throws Exception { if
	 * (language.getName().isEmpty()) { throw new Exception("İsim boş olamaz"); }
	 * else if (!this.isValid(language)) { throw new
	 * Exception("Bu dil zaten mevcut!"); } else {
	 * languageRepository.create(language, id); }
	 * 
	 * }
	 * 
	 * @Override public boolean isValid(Language language) { for (Language language3
	 * : languageRepository.findAll()) { if
	 * (language3.getName().equalsIgnoreCase(language.getName())) { return false; }
	 * } return true;
	 * 
	 * }
	 */

}
