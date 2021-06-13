package kodlamaio.hrms.entities.dtos;

import java.util.List;

import kodlamaio.hrms.entities.concretes.ExperienceForCv;
import kodlamaio.hrms.entities.concretes.ForeignLanguage;
import kodlamaio.hrms.entities.concretes.ImageForCv;
import kodlamaio.hrms.entities.concretes.Jobseeker;
import kodlamaio.hrms.entities.concretes.Link;
import kodlamaio.hrms.entities.concretes.ProgrammingSkill;
import kodlamaio.hrms.entities.concretes.School;

public class JobSeekerCVDto {

	public Jobseeker jobseeker;
	public List<School> schools;
	public List<ProgrammingSkill> programingSkills;
	public List<Link> links;
	public List<ForeignLanguage> languages;
	public List<ExperienceForCv> experiences;
	public ImageForCv image;
}
