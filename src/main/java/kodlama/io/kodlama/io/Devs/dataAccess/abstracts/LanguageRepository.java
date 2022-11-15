package kodlama.io.kodlama.io.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.kodlama.io.Devs.entities.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
	/*
	 * void create(Language language,int id); void delete(int id); void
	 * update(Language language,int id);
	 */
	

}
