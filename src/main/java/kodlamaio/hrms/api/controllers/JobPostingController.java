package kodlamaio.hrms.api.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;

@RestController
@RequestMapping("/api/jobposting")
public class JobPostingController {

	private JobPostingService jobPostingService;

	@Autowired
	public JobPostingController(JobPostingService jobPostingService) {
		super();
		this.jobPostingService = jobPostingService;
	}

	
	@PostMapping("/add")
	
	public Result add(@RequestBody JobPosting jobPosting){
		return this.jobPostingService.add(jobPosting);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobPosting>> getAll(){		
		return this.jobPostingService.getAll();
	}
	
	@PostMapping("/changeOpenToClose")
	public Result changeOpenToClose(int id){
		return this.jobPostingService.changeOpenToClose(id);
	}
	
	@GetMapping("/getAllOpenJobPostingList")
	public DataResult<List<JobPosting>> getAllOpenJobPostingList(){
		return this.jobPostingService.getAllOpenJobPostingList();
	}
	
	@GetMapping("/findAllByOrderByPublishedAt")
	public DataResult<List<JobPosting>> findAllByOrderByPublishedAt(){
		return this.jobPostingService.findAllByOrderByPublishedAt();
	}
	
	@GetMapping("/getAllOpenJobPostingByEmployer")
	public DataResult<List<JobPosting>> getAllOpenJobPostingByEmployer(int id){
		return this.jobPostingService.getAllOpenJobPostingByEmployer(id);
	}
}
