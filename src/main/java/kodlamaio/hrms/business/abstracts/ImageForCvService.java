package kodlamaio.hrms.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ImageForCv;

public interface ImageForCvService {

	Result add(ImageForCv imageForCv, MultipartFile imageFile) throws IOException;
	Result update(ImageForCv imageForCv);
	Result delete(int id);
	DataResult<ImageForCv> getById(int id);	
	DataResult<List<ImageForCv>> getAll();
	DataResult<ImageForCv> getByJobseekerId(int id);
}
