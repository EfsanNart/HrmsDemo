package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingDao;
import kodlamaio.hrms.entities.concretes.JobPosting;
import net.bytebuddy.asm.Advice.This;

@Service
public class JobPostingManager implements JobPostingService {

	private JobPostingDao jobPostingDao;

	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao) {
		super();
		this.jobPostingDao = jobPostingDao;
	}

	@Override
	public Result add(JobPosting jobPosting) {
		if (!CheckIfNullField(jobPosting)) {
			return new ErrorResult("You have entered missing information. Please fill in all fields.");
		}
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult("Job posting has been added.");
	}
	@Override
	public Result update(JobPosting jobPosting) {
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult("Job posting has been updated.");
		
	}

	@Override
	public Result delete(int id) {
		this.jobPostingDao.deleteById(id);
		return new SuccessResult("Job posting has been deleted.");
	}

	@Override
	public DataResult<JobPosting> getById(int id) {
		return new SuccessDataResult<JobPosting>(this.jobPostingDao.getOne(id));
	}

	@Override
	public DataResult<List<JobPosting>> getAll() {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll());
	}

	@Override
	public Result changeOpenToClose(int id) {
		if (getById(id) == null) {
			return new ErrorResult("There is no such job posting");

		}
		if (getById(id).getData().isOpen() == false) {
			return new ErrorResult("There job posting is already closed.");
		}

		JobPosting jobPosting = getById(id).getData();
		jobPosting.setOpen(false);
		update(jobPosting);
		return new SuccessResult("Job posting has been successfully closed.");
	}

	@Override
	public DataResult<List<JobPosting>> getAllOpenJobPostingList() {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getAllOpenJobAdvertList());
	}

	@Override
	public DataResult<List<JobPosting>> findAllByOrderByPublishedAt() {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAllByOrderByPublishedAtDesc());
	}

	@Override
	public DataResult<List<JobPosting>> getAllOpenJobPostingByEmployer(int id) {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getAllOpenJobPostingByEmployer(id));
	}

	private boolean CheckIfNullField(JobPosting jobPosting) {
		if (jobPosting.getJobPosition() != null && jobPosting.getDescription() != null && jobPosting.getCity() != null
				&& jobPosting.getOpenPositions() != 0) {
			return true;
		}
		return false;
	}

	

	
	
	
}
