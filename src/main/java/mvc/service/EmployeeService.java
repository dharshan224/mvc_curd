package mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;



import mvc.dao.EmployeeDao;
import mvc.dto.Employee;

@Service
public class EmployeeService {
	   @Autowired
	   EmployeeDao dao;
	   
	   public String add(Employee employee, ModelMap map) {
		   dao.save(employee);
		   map.put("sucess", "Record added success");
		   return "home.jsp";
	   }
	   public String fetch(ModelMap map) {
		   List<Employee> list = dao.fetchAll();
		   if(list.isEmpty()) {
			   map.put("failure", "no record found");
			   return "home.jsp";
		   }else {
			   map.put("list", list);
			   return "fetch.jsp";
		   }
	   }
	   
	   public String delete(int id, ModelMap map) {
		   Employee employee=dao.find(id);
		   dao.delete(employee);
		   map.put("success", "record deleted success");
		   return "fetch";
	   }
	   
	   
	   
	   

}
