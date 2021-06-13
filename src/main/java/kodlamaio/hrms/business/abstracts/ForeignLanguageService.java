package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ForeignLanguage;

public interface ForeignLanguageService {

	Result add(ForeignLanguage foreignLanguage);
	Result update(ForeignLanguage foreignLanguage);
	Result delete(int id);
	DataResult<ForeignLanguage> getById(int id);	
	DataResult<List<ForeignLanguage>> getAll();
	DataResult<List<ForeignLanguage>> getAllByJobseekerId(int id);
}
