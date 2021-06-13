package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ImageForCv;

public interface ImageForCVDao extends JpaRepository<ImageForCv, Integer>{

	ImageForCv getById(int id);
	ImageForCv getByJobseeker_id(int id);
}
