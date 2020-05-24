package project.helpDesk;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import project.company.organization.*;

public class Request {
	public UUID Id;
	public Employee CreatedBy;
	public Manager Manager;
	public Date CreatedTime;
	public String TextMessage;
	public List<Status> Statuses;

	@SuppressWarnings("serial")
	public Request(Employee employee) {
		this.Id = UUID.randomUUID();
		this.CreatedBy = employee;
		this.Manager = employee.Manager;
		this.CreatedTime = new Date();
		this.TextMessage = "It's broken";
		this.Statuses = new ArrayList<Status>() {
			{
				new Status();
			}
		};
	}

	@SuppressWarnings("serial")
	public Request(Employee employee, String message) {
		this.Id = UUID.randomUUID();
		this.CreatedBy = employee;
		this.Manager = employee.Manager;
		this.CreatedTime = new Date();
		this.TextMessage = message;
		this.Statuses = new ArrayList<Status>() {
			{
				new Status();
			}
		};
	}

	public void AddStatus(Status status) {
		this.Statuses.add(status);
	}

	public Status CurrentStatus() {
		return this.Statuses.get(this.Statuses.size() - 1);
	}

	public boolean IsNeedApprove() {
		return this.Manager == null;
	}
}
