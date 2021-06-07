package kodlamaio.hrms.mernisService;

public class FakeMernisService {

	public boolean ValidateByPersonalInfo(long nationalId, String firstName, String lastName, int timeOfBirth)
	{
		System.out.println(firstName + " " + lastName + " is valid person." );
		return true;
	}
}
