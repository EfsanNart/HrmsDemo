package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;

public interface JobPostingService {

	
	Result add(JobPosting jobPosting);
	Result update(JobPosting jobPosting);
	Result delete(int id);
	Result changeOpenToClose(int id);
	DataResult<JobPosting> getById(int id);	
	DataResult<List<JobPosting>> getAll();
	DataResult<List<JobPosting>> getAllOpenJobPostingList();
	DataResult<List<JobPosting>> findAllByOrderByPublishedAt();
	DataResult<List<JobPosting>> getAllOpenJobPostingByEmployer(int id);
	
}
