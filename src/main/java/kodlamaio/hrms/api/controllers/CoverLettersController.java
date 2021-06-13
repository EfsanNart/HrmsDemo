package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CoverLetterForCvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CoverLetterForCv;

@RestController
@RequestMapping("/api/coverletters")
public class CoverLettersController {

	
	private CoverLetterForCvService coverLetterForCVService;

	@Autowired
	public CoverLettersController(CoverLetterForCvService coverLetterForCVService) {
		super();
		this.coverLetterForCVService = coverLetterForCVService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CoverLetterForCv coverLetterForCv){
		return this.coverLetterForCVService.add(coverLetterForCv);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CoverLetterForCv coverLetterForCv){
		return this.coverLetterForCVService.update(coverLetterForCv);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id){
		return this.coverLetterForCVService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<CoverLetterForCv> getById(@RequestParam("id") int id){
		return this.coverLetterForCVService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CoverLetterForCv>> getAll(){
		return this.coverLetterForCVService.getAll();
	}
	
}
