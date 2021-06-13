package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ExperienceForCv;

public interface ExperienceForCVDao extends JpaRepository<ExperienceForCv, Integer>{

	ExperienceForCv getById(int id);
	List<ExperienceForCv> getAllByJobseeker_idOrderByEndAtDesc(int id);
	List<ExperienceForCv> getAllByJobseeker_id(int id);
}
