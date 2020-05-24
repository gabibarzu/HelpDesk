package org.activiti.designer.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.io.FileInputStream;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.test.ActivitiRule;
import org.junit.Rule;
import org.junit.Test;

public class ProcessTestHelpDeskProcess {

	private String filename = "C:\\Users\\barzu\\eclipse-workspace\\HelpDesk\\src\\main\\resources\\diagrams\\ActivityProcess.bpmn";

	@Rule
	public ActivitiRule activitiRule = new ActivitiRule();

	@Test
	public void startProcess() throws Exception {
		RepositoryService repositoryService = activitiRule.getRepositoryService();
		repositoryService.createDeployment().addInputStream("helpDeskProcess.bpmn20.xml", new FileInputStream(filename))
				.deploy();
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		Map<String, Object> variableMap = new HashMap<String, Object>();
		variableMap.put("name", "Activiti");
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("helpDeskProcess", variableMap);
		assertNotNull(processInstance.getId());
		System.out.println("id " + processInstance.getId() + " " + processInstance.getProcessDefinitionId());
	}

	@Test
	public void CreateRequest() throws Exception {
		RepositoryService repositoryService = activitiRule.getRepositoryService();
		repositoryService.createDeployment().addInputStream("helpDeskProcess.bpmn20.xml", new FileInputStream(filename))
				.deploy();
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		Map<String, Object> variableMap = new HashMap<String, Object>();

		variableMap.put("FirstName", "Maria");
		variableMap.put("LastName", "Barat");
		variableMap.put("TextMessage", "It doesn't work anymore!");
		variableMap.put("email", "andra@barat.com");
		variableMap.put("isRezolved", "false");
		
		String processID = runtimeService.startProcessInstanceByKey("helpDeskProcess", variableMap).getId();
		System.out.println("Request a fost creeat cu id-ul " + processID);
		assertNotNull(processID);
	}
	
	@Test
	public void ApproveRequset() throws Exception {
		RepositoryService repositoryService = activitiRule.getRepositoryService();
		repositoryService.createDeployment().addInputStream("helpDeskProcess.bpmn20.xml", new FileInputStream(filename))
				.deploy();
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		Map<String, Object> variableMap = new HashMap<String, Object>();

		variableMap.put("isApproved", "true");
		String id = UUID.randomUUID().toString();
		variableMap.put("requestid", id);
		variableMap.put("ITAssigned", "Barzu Gabriel");

		String processID = runtimeService.startProcessInstanceByKey("helpDeskProcess", variableMap).getId();
		System.out.println("Request a fost aprobat cu numarul: " + id + " iar procesul are id-ul " + processID);
		assertNotNull(processID);
	}
	
	@Test
	public void RejectApproveRequset() throws Exception {
		RepositoryService repositoryService = activitiRule.getRepositoryService();
		repositoryService.createDeployment().addInputStream("helpDeskProcess.bpmn20.xml", new FileInputStream(filename))
				.deploy();
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		Map<String, Object> variableMap = new HashMap<String, Object>();

		variableMap.put("isApproved", "true");
		String id = UUID.randomUUID().toString();
		variableMap.put("requestid", id);
		variableMap.put("ITAssigned", "Barzu Gabriel");
		
		String processID = runtimeService.startProcessInstanceByKey("helpDeskProcess", variableMap).getId();
		System.out.println("Request a fost rejectat cu numarul: " + id + " iar procesul are id-ul " + processID);
		assertNotNull(processID);
	}
}