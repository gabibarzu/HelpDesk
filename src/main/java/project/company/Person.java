package project.company;

import java.util.Date;
import java.util.UUID;

public class Person {
	public UUID Id;
	private String FirstName;
	private String LastName;
	private Date HiredDate;

	public Person(String firstName, String lastName) {
		this.Id = UUID.randomUUID();
		this.FirstName = firstName;
		this.LastName = lastName;
		this.HiredDate = new Date();
	}

	public Person(String firstName, String lastName, Date hiredDate) {
		this.Id = UUID.randomUUID();
		this.FirstName = firstName;
		this.LastName = lastName;
		this.HiredDate = hiredDate;
	}

	public String GetPersonFirstNameById(UUID id) {
		if (id == this.Id) {
			return this.FirstName;
		}
		return null;
	}

	public String GetPersonLastNameById(UUID id) {
		if (id == this.Id) {
			return this.LastName;
		}
		return null;
	}
	
	public String GetPersonHiredDateById(UUID id) {
		if (id == this.Id) {
			return this.HiredDate.toString();
		}
		return null;
	}
	
}
