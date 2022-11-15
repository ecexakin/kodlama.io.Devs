package kodlama.io.kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.kodlama.io.Devs.business.requests.CreateLanguageRequest;
import kodlama.io.kodlama.io.Devs.business.requests.DeleteLanguageRequest;
import kodlama.io.kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import kodlama.io.kodlama.io.Devs.business.responses.GetAllLanguagesResponse;

public interface LanguageService {
	List<GetAllLanguagesResponse> getAll();

	void add(CreateLanguageRequest createLanguageRequest);

	void delete(DeleteLanguageRequest deleteLanguageRequest);
	void update(UpdateLanguageRequest updateLanguageRequest,int id);
	
	/*
	 * void update(UpdateLanguageRequest updateLanguageRequest,int id);
	 */ /*
		 *
		 *
		 * void create(Language language,int id) throws Exception; void delete(int id);
		 * void update(Language language,int id); boolean isValid(Language language);
		 */

}
