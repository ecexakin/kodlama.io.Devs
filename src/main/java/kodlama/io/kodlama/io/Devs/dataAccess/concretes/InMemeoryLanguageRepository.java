package kodlama.io.kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.kodlama.io.Devs.entities.Language;
@Repository //data access nesnesidir. 

public class InMemeoryLanguageRepository implements LanguageRepository {

	List<Language> languages;
	
	public InMemeoryLanguageRepository() {
		languages = new ArrayList<Language>();
		languages.add(new Language(1,"C#"));
		languages.add(new Language(2,"Java"));
		languages.add(new Language(3,"Python"));

		
	}
	
	@Override
	public List<Language> getAll(){
		return languages;
	}
	//@Override
	//public void add(Language language) {
	//	return languages.add(Language);

	@Override
	public void create(Language language, int id) {
		languages.add(language);
		
	}

	@Override
	public void delete(int id) {
		for (Language language1 : languages) {
			if (language1.getId()==id) {
				languages.remove(id);
			}
		}
	}

	@Override
	public void update(Language language, int id) {
		for (Language language2 : languages) {
			if (language2.getId()==id) {
				language.setId(language2.getId()); 
				language.setName(language2.getName());
				
			}
		}
		
		
	}
		
	//}

}