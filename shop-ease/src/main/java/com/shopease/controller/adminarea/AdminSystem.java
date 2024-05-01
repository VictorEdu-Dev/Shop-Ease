package com.shopease.controller.adminarea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.shopease.controller.adminarea.enums.Action;
import com.shopease.controller.adminarea.enums.Path;
import com.shopease.persistence.model.admin.Employee;
import com.shopease.persistence.model.usercommon.Client;
import com.shopease.persistence.repository.CrudRepository;

@Controller
public class AdminSystem {
	
	private CrudRepository<Client, String, Object> clientRegister;
	private CrudRepository<Employee, String, Object> employeeService;
	
	@Autowired
	public void setClientService(@Qualifier("jpaClientDAO") CrudRepository<Client, String, Object> clientRegister) {
		this.clientRegister = clientRegister;
	}
	
	@Autowired
	public void setEmployeeService(@Qualifier("jpaEmployeeDAO") CrudRepository<Employee, String, Object> employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping(Action.REQ_ADMIN_GENERAL_SYSTEM)
	public String adminGeneralSystem() {
		return Path.ADMIN_GENERAL_SYSTEM.getContent();
	}
	
	@GetMapping(Action.REQ_CLIENT_REGISTER_AREA)
	public String clientRegisterArea() {
		return Path.REGISTER_CLIENT_AREA.getContent();
	}
	
	@PostMapping(Action.REQ_SUBMIT_CLIENT)
	public String submitClient(Client client) {
		clientRegister.save(client);
		return "";
	}
	
	@GetMapping(Action.REQ_LOAD_LIST_CLIENT)
	public String loadClientList(Model model) {
		model.addAttribute("clients", clientRegister.findListObject());
		return Path.VIEW_CLIENT_LIST.getContentForward();
	}
	
	@GetMapping(Action.REQ_EMPLOYEE_SERVICE_AREA)
	public String employeeServiceArea() {
		return Path.EMPLOYEE_AREA_SERVICE.getContent();
	}
	
	@PostMapping(Action.REQ_SUMBIT_EMPLOYEE)
	public String submitEmployee(Employee e) {
		employeeService.save(e);
		return Path.EMPLOYEE_AREA_SERVICE.getContent();
	}
	
	@GetMapping(Action.REQ_LOAD_EMPLOYEE_LIST)
	public String loadEmployeelist(Model model) {
		model.addAttribute("employees", employeeService.findListObject());
		return Path.VIEW_EMPLOYEE_LIST.getContent();
	}
	
	@GetMapping(Action.REQ_PRODUCT_REGISTER_AREA)
	public String productRegisterArea() {
		return Path.REGISTER_PRODUCT_AREA.getContent();
	}
	
	@GetMapping(Action.REQ_CHAT_TEAM_AREA)
	public String chatTeamArea() {
		return Path.CHAT_TEAM_AREA.getContent();
	}
	
	
}
