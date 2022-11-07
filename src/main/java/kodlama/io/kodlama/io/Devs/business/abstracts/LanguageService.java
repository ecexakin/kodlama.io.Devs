package kodlama.io.kodlama.io.Devs.business.abstracts;

import java.util.List;
import kodlama.io.kodlama.io.Devs.entities.Language;


public interface LanguageService {
	List<Language> getAll();
	void create(Language language,int id) throws Exception;
	void delete(int id);
	void update(Language language,int id);
    boolean isValid(Language language);

}
