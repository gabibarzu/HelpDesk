package project.helpDesk;

public enum StatusEnum {
	NEW("New"), 
	ANALYZE("Analyze"), 
	WAITINGAPPROVEL("Waiting approvel"), 
	APPROVED("Approved"), 
	REJECTED("Rejected"), 
	RESOLVING("Resolving request"),
	WAITINGACCEPTANCE("Waiting employee response"),
	ADDNEWINFO("Adding new informance"),
	RESOLVED("Resolved");
	
	
	String Value;

	StatusEnum(String value) {
		this.Value = value;
	}
	
	public String GetStatus() {
		return this.Value;
	}
	
}
