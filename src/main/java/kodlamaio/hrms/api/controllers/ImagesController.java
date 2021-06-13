package kodlamaio.hrms.api.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ImageForCvService;
import kodlamaio.hrms.business.abstracts.JobseekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ImageForCv;
import kodlamaio.hrms.entities.concretes.Jobseeker;
;

@RestController
@RequestMapping("/api/images")
public class ImagesController {

	private ImageForCvService imageForCvService;
	private JobseekerService jobseekerService;
	
	@Autowired
	public ImagesController(ImageForCvService imageForCvService, JobseekerService jobseekerService) {
		super();
		this.imageForCvService = imageForCvService;
		this.jobseekerService = jobseekerService;
	}
	
	@PostMapping(value = "/add")
	public Result add(@RequestParam(value = "id") int id, @RequestParam(value = "imageFile") MultipartFile imageFile) throws IOException{
		Jobseeker jobseeker = this.jobseekerService.getById(id).getData();
		ImageForCv imageForCv = new ImageForCv();
		imageForCv.setJobseeker(jobseeker);
		return this.imageForCvService.add(imageForCv, imageFile);
	}
	@PostMapping("/update")
	public Result update(@RequestBody ImageForCv imageForCv){
		return this.imageForCvService.update(imageForCv);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id){
		return this.imageForCvService.delete(id);
	}
	@GetMapping("/getbyid")
	public DataResult<ImageForCv> getById(@RequestParam("id") int id){
		return this.imageForCvService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<ImageForCv>> getAll(){
		return this.imageForCvService.getAll();
	}
	@GetMapping("/getByJobseekerId")
	public DataResult<ImageForCv> getByJobseekerId(@RequestParam int id){
		return this.imageForCvService.getByJobseekerId(id);
	}
	
}
