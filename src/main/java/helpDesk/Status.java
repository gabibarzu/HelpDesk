package helpDesk;

import java.util.Date;
import java.util.UUID;

import company.support.ITGuy;

public class Status {
	public UUID Id;
	public ITGuy AssignedTo;
	public Date AssignedAt;
	public StatusEnum Value;

	public Status() {
		this.Id = UUID.randomUUID();
		this.AssignedTo = null;
		this.AssignedAt = null;
		this.Value = StatusEnum.NEW;
	}
	
	public Status(StatusEnum value) {
		this.Id = UUID.randomUUID();
		this.AssignedTo = null;
		this.AssignedAt = null;
		this.Value = value;
	}
	
	public Status(StatusEnum value, ITGuy itGuy) {
		this.Id = UUID.randomUUID();
		this.AssignedTo = itGuy;
		this.AssignedAt = new Date();
		this.Value = value;
	}
}
