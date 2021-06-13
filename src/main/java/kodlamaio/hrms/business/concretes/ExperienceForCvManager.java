package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ExperienceForCvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ExperienceForCVDao;
import kodlamaio.hrms.entities.concretes.ExperienceForCv;

@Service
public class ExperienceForCvManager implements ExperienceForCvService {


private ExperienceForCVDao experienceForCVDao;
	
	@Autowired
	public ExperienceForCvManager(ExperienceForCVDao experienceForCVDao) {
		super();
		this.experienceForCVDao=experienceForCVDao;
	}
	
	
	
	
	@Override
	public Result add(ExperienceForCv experienceForCV) {
		this.experienceForCVDao.save(experienceForCV);
		return new SuccessResult("Experience has been added.");
	}

	@Override
	public Result update(ExperienceForCv experienceForCV) {
		this.experienceForCVDao.save(experienceForCV);
		return new SuccessResult("Experience has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.experienceForCVDao.deleteById(id);
		return new SuccessResult("Experience has been deleted.");
	}

	@Override
	public DataResult<ExperienceForCv> getById(int id) {
		return new SuccessDataResult<ExperienceForCv>(this.experienceForCVDao.getById(id));
	}

	@Override
	public DataResult<List<ExperienceForCv>> getAll() {
		return new SuccessDataResult<List<ExperienceForCv>>(this.experienceForCVDao.findAll());
	}

	@Override
	public DataResult<List<ExperienceForCv>> getAllByJobseekerIdOrderByEndAtDesc(int id) {
		return new SuccessDataResult<List<ExperienceForCv>>(this.experienceForCVDao.getAllByJobseeker_idOrderByEndAtDesc(id));
	}

	@Override
	public DataResult<List<ExperienceForCv>> getAllByJobseekerId(int id) {
		return new SuccessDataResult<List<ExperienceForCv>>(this.experienceForCVDao.getAllByJobseeker_id(id));
	}

}
