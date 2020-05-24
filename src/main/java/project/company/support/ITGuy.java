package project.company.support;

import java.util.Date;

import project.company.Person;
import project.helpDesk.Request;
import project.helpDesk.Status;
import project.helpDesk.StatusEnum;

public class ITGuy extends Person {

	public ITGuy(String firstName, String lastName) {
		super(firstName, lastName);
	}

	public ITGuy(String firstName, String lastName, Date hiredDate) {
		super(firstName, lastName, hiredDate);
	}

	public void ResolveRequest(Request request) {
		if ((request.CurrentStatus().Value == StatusEnum.ANALYZE && !request.IsNeedApprove())
				|| request.CurrentStatus().Value == StatusEnum.APPROVED) {
			request.AddStatus(new Status(StatusEnum.WAITINGACCEPTANCE));
		}
	}
}
