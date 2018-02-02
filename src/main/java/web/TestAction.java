package web;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import service.impl.TestService;

@Controller
@Scope("prototype") // Struts2是多例的
public class TestAction extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = 1L;

	@Resource
	private TestService service;
	
	private String message;
	
	public String getMessage() {
		return message;
	}
	
	public String execute(){
		message = service.Hello();
		session.put("msg", message);
		return "success";
	}

	private Map<String, Object> session;
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;		
	}
}










