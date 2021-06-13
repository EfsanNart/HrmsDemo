package kodlamaio.hrms.dataAccess.abstracts;
import kodlamaio.hrms.entities.concretes.ForeignLanguage;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
public interface ForeignLanguageDao extends JpaRepository<ForeignLanguage, Integer>{

	ForeignLanguage getById(int id);

	List<ForeignLanguage> getAllByJobseeker_id(int id);
	
}
