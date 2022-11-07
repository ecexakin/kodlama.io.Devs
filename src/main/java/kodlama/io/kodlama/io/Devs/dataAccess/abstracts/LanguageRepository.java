package kodlama.io.kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;


import kodlama.io.kodlama.io.Devs.entities.Language;

public interface LanguageRepository {
	List<Language>  getAll();
	void create(Language language,int id);
	void delete(int id);
	void update(Language language,int id);
	

}
