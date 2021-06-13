package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ExperienceForCvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ExperienceForCv;

@RestController
@RequestMapping("/api/experiences")
public class ExperiencesController {

	private ExperienceForCvService experienceForCvService;

	@Autowired
	public ExperiencesController(ExperienceForCvService experienceForCvService) {
		super();
		this.experienceForCvService = experienceForCvService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ExperienceForCv experienceForCv){
		return this.experienceForCvService.add(experienceForCv);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody ExperienceForCv experienceForCv){
		return this.experienceForCvService.update(experienceForCv);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id){
		return this.experienceForCvService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<ExperienceForCv> getById(@RequestParam int id){
		return this.experienceForCvService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<ExperienceForCv>> getAll(){
		return this.experienceForCvService.getAll();
	}
	
	@GetMapping("/getAllByJobseekerIdOrderByEndAtDesc")
	public DataResult<List<ExperienceForCv>> getAllByJobseekerIdOrderByEndAtDesc(@RequestParam("id") int id){
		return this.experienceForCvService.getAllByJobseekerIdOrderByEndAtDesc(id);
	}
	
	@GetMapping("/getAllByJobseekerId")
	public DataResult<List<ExperienceForCv>> getAllByJobseekerId(@RequestParam int id){
		return this.experienceForCvService.getAllByJobseekerId(id);
	}
}
