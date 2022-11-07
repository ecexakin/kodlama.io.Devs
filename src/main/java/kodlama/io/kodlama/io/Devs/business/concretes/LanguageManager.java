package kodlama.io.kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.kodlama.io.Devs.entities.Language;


@Service //otomatik newle // business nesnesi
public class LanguageManager implements LanguageService {

	private LanguageRepository languageRepository;

	
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public List<Language> getAll() {
		return languageRepository.getAll();
	}

	@Override
	public void delete(int id) {
		languageRepository.delete(id);
	}

	@Override
	public void update(Language language, int id) {
		languageRepository.update(language, id);
	}

	@Override
	public void create(Language language, int id) throws Exception {
		if (language.getName().isEmpty()) {
			throw new Exception("İsim boş olamaz");
		} else if (!this.isValid(language)) {
			throw new Exception("Bu dil zaten mevcut!");
		} else {
			languageRepository.create(language, id);
		}

	}

	@Override
	public boolean isValid(Language language) {
		for (Language language3 : languageRepository.getAll()) {
			if (language3.getName().equalsIgnoreCase(language.getName())) {
				return false;
			}
		}
		return true;

	}

}
