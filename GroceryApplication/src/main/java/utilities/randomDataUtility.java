package utilities;

import com.github.javafaker.Faker;

public class randomDataUtility {
	Faker fk=new Faker();
	public String generateRandomUserName() {
		return fk.name().username();
	}
	public String generateRandomPassword() {
		return fk.internet().password();
	}
	public String generateRandomFullName() {
		return fk.name().fullName();
	}
	public String generateRandomEmailid() {
		return fk.internet().emailAddress();
	}
	public String generateRandomPhoneNumber() {
		return fk.phoneNumber().cellPhone();
		
	}
	public String generateRandomAddress() {
		return fk.address().streetAddress();
	}	

}
