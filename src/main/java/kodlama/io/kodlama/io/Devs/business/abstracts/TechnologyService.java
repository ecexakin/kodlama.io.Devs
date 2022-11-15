package kodlama.io.kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import kodlama.io.kodlama.io.Devs.business.requests.DeleteTechnologyRequest;
import kodlama.io.kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import kodlama.io.kodlama.io.Devs.business.responses.GetAllTechnologiesResponse;

public interface TechnologyService {


	List<GetAllTechnologiesResponse> getAll();

	void add(CreateTechnologyRequest createTechnologyRequest);

	void delete(DeleteTechnologyRequest deleteTechnologyRequest);
	void update(UpdateTechnologyRequest updateTechnologyRequest,int id);
}




