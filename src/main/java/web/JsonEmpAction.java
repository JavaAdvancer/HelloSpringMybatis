package web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import entity.Emp;
import service.EmpService;
import util.JsonResult;

@Controller
@Scope("prototype")
public class JsonEmpAction {
	
	@Resource
	private EmpService empService;
	
	private List<Emp> emps;
	private JsonResult<List<Emp>> jsonResult;
	
	public void setJsonResult(JsonResult<List<Emp>> jsonResult) {
		this.jsonResult = jsonResult;
	}
	
	public JsonResult<List<Emp>> getJsonResult() {
		return jsonResult;
	}
	
	public String execute(){
		emps = empService.findAll();
		jsonResult = new JsonResult<List<Emp>>(emps);
		return "success";
	}

	
}
