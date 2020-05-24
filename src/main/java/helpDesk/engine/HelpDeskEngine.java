package helpDesk.engine;

import helpDesk.Request;
import helpDesk.Status;
import helpDesk.StatusEnum;

public class HelpDeskEngine {
	public void AnalyzeRequest(Request request) {
		if (request.CurrentStatus().Value == StatusEnum.NEW) {
			if (request.IsNeedApprove()) {
				request.AddStatus(new Status(StatusEnum.WAITINGAPPROVEL));
			} else {
				request.AddStatus(new Status(StatusEnum.ANALYZE));
			}
		}
	}
}
