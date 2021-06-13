package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ExperienceForCv;

public interface ExperienceForCvService {

	Result add(ExperienceForCv experienceForCV);
	Result update(ExperienceForCv experienceForCV);
	Result delete(int id);
	DataResult<ExperienceForCv> getById(int id);	
	DataResult<List<ExperienceForCv>> getAll();
	DataResult<List<ExperienceForCv>> getAllByJobseekerIdOrderByEndAtDesc(int id);
	DataResult<List<ExperienceForCv>> getAllByJobseekerId(int id);
	
}
