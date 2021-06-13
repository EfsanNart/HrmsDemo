package kodlamaio.hrms.business.concretes;

import java.io.IOException;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ImageForCvService;

import kodlamaio.hrms.core.utilities.imageUpload.ImageUploadService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ImageForCVDao;
import kodlamaio.hrms.entities.concretes.ImageForCv;


@Service
public class ImageForCvManager implements ImageForCvService{

	private ImageForCVDao imageForCVDao;
	private ImageUploadService imageUploadService;


	@Autowired
	public ImageForCvManager(ImageForCVDao imageForCVDao, ImageUploadService imageUploadService) {
		super();
		this.imageForCVDao = imageForCVDao;
		this.imageUploadService = imageUploadService;
	}
	
	
	
	
	
	@Override
	public Result add(ImageForCv imageForCv, MultipartFile imageFile) {
		
		Map<String,String> uploadImage = this.imageUploadService.uploadImageFile(imageFile).getData();
		imageForCv.setUrl(uploadImage.get("url"));
		this.imageForCVDao.save(imageForCv);
		return new SuccessResult("Image has been added.");
	}

	@Override
	public Result update(ImageForCv imageForCv) {
		
		this.imageForCVDao.save(imageForCv);
		return new SuccessResult("Image has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.imageForCVDao.deleteById(id);
		return new SuccessResult("Image has been deleted.");
	}

	@Override
	public DataResult<ImageForCv> getById(int id) {
		return new SuccessDataResult<ImageForCv>(this.imageForCVDao.getById(id));
	}

	@Override
	public DataResult<List<ImageForCv>> getAll() {
		return new SuccessDataResult<List<ImageForCv>>(this.imageForCVDao.findAll());
	}

	@Override
	public DataResult<ImageForCv> getByJobseekerId(int id) {
		return new SuccessDataResult<ImageForCv>(this.imageForCVDao.getByJobseeker_id(id));
	}

}
