package kodlamaio.hrms.business.abstracts;
import kodlamaio.hrms.entities.concretes.City;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;

public interface CityService {
//	Result add(City city);
//	Result update(City city);
//	Result delete(int id);
//	DataResult<City> getById(int id);

	DataResult<List<City>> getAll();
}
