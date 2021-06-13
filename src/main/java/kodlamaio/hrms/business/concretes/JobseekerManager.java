package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ExperienceForCvService;
import kodlamaio.hrms.business.abstracts.ForeignLanguageService;
import kodlamaio.hrms.business.abstracts.ImageForCvService;
import kodlamaio.hrms.business.abstracts.JobseekerService;
import kodlamaio.hrms.business.abstracts.LinkService;
import kodlamaio.hrms.business.abstracts.ProgrammingSkillService;
import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobseekerDao;
import kodlamaio.hrms.entities.concretes.Jobseeker;
import kodlamaio.hrms.entities.dtos.JobSeekerCVDto;
@Service
public class JobseekerManager implements JobseekerService {

private JobseekerDao jobseekerDao;
private ExperienceForCvService experienceForCvService;
private ForeignLanguageService foreignLanguageService;
private ImageForCvService imageForCvService;
private LinkService linkService;
private ProgrammingSkillService programmingSkillService;
private SchoolService schoolService;


public JobseekerManager(JobseekerDao jobseekerDao, ExperienceForCvService experienceForCvService,
		ForeignLanguageService foreignLanguageService, ImageForCvService imageForCvService,
		LinkService linkFService, ProgrammingSkillService programmingSkillService,
		SchoolService schoolService) {
	super();
	this.jobseekerDao = jobseekerDao;
	this.experienceForCvService = experienceForCvService;
	this.foreignLanguageService = foreignLanguageService;
	this.imageForCvService = imageForCvService;
	this.linkService = linkService;
	this.programmingSkillService = programmingSkillService;
	this.schoolService = schoolService;
}


	@Override
	public Result add(Jobseeker jobseeker) {
		this.jobseekerDao.save(jobseeker);
      return new SuccessResult("Jobseeker has been added.");
	}

	@Override
	public Result update(Jobseeker jobseeker) {
		this.jobseekerDao.save(jobseeker);
      return new SuccessResult("Jobseeker has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.jobseekerDao.deleteById(id);
      return new SuccessResult("Jobseeker has been deleted.");
	}

	@Override
	public DataResult<Jobseeker> getById(int id) {
		return new SuccessDataResult<Jobseeker>(this.jobseekerDao.getOne(id));
	}

	@Override
	public DataResult<List<Jobseeker>> getAll() {
		return new SuccessDataResult<List<Jobseeker>>(this.jobseekerDao.findAll());
	}

	@Override
	public DataResult<Jobseeker> getJobseekerByNationalId(String nationalId) {
		return new SuccessDataResult<Jobseeker>(this.jobseekerDao.findJobseekerByNationalId(nationalId));
	}
	@Override
	public DataResult<JobSeekerCVDto> getJobseekerCVById(int id) {
		Jobseeker jobseeker = this.jobseekerDao.getById(id);
		JobSeekerCVDto cv = new JobSeekerCVDto();
		cv.experiences = jobseeker.getExperiences();
		cv.languages = jobseeker.getLanguages();
		cv.image = jobseeker.getImage();
		cv.links = jobseeker.getLinks();
		cv.programingSkills = jobseeker.getProgramingSkills();
		cv.schools = jobseeker.getSchools();
		return new SuccessDataResult<JobSeekerCVDto>(cv);
	}
}
