package kodlama.io.kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.kodlama.io.Devs.business.abstracts.TechnologyService;
import kodlama.io.kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import kodlama.io.kodlama.io.Devs.business.requests.DeleteTechnologyRequest;
import kodlama.io.kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import kodlama.io.kodlama.io.Devs.business.responses.GetAllTechnologiesResponse;
import kodlama.io.kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.kodlama.io.Devs.entities.Language;
import kodlama.io.kodlama.io.Devs.entities.Technology;

@Service
public class TechnologyManager implements TechnologyService{

	private TechnologyRepository technologyRepository;
	

	public TechnologyManager(TechnologyRepository technologyRepository) {
		this.technologyRepository = technologyRepository;
	}

	@Override
	public List<GetAllTechnologiesResponse> getAll() {
		List<Technology> technologies = technologyRepository.findAll();
		List<GetAllTechnologiesResponse> technologiesResponse = new ArrayList<GetAllTechnologiesResponse>();
		
		for (Technology technology : technologies) {
			GetAllTechnologiesResponse responseItem = new GetAllTechnologiesResponse();
			responseItem.setId(technology.getId());
			responseItem.setName(technology.getName());
			technologiesResponse.add(responseItem);
		}
		return technologiesResponse;
		
	}

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) {
		Technology technology = new Technology();
		technology.setName(createTechnologyRequest.getName());
		this.technologyRepository.save(technology);
		
	}

	@Override
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		Technology deletedLanguage= new Technology();
		deletedLanguage.setId(deleteTechnologyRequest.getId());
		this.technologyRepository.delete(deletedLanguage);
		
	}

	@Override
	public void update(UpdateTechnologyRequest updateTechnologyRequest, int id) {
		
		List<Technology> technologies = technologyRepository.findAll();
		
		for (Technology technology : technologies) {
			if (updateTechnologyRequest.getId()==technology.getId()) {
				technology.setName(updateTechnologyRequest.getName());
				this.technologyRepository.save(technology);
				
			} else {
				System.out.println("Güncelleme başarısız");
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
