package web;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import entity.Emp;
import service.EmpService;

@Controller
@Scope("prototype")
public class SessionEmpAction implements SessionAware{
	
	@Resource
	private EmpService empService;
	// 实现 SessionAware 接口  获取 session域对象
	private Map<String, Object> session;
	
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
	
	// 查询所有用户信息
	/*
	 * 通过从服务端获取的对象列表，可以直接将它们放入域对象里面，可在jsp页面中直接通过EL表达式读取
	 */
	public String findAll(){
		session.put("emps", empService.findAll());
		return "list";
	}
	
	private Emp emp;
	
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	
	public Emp getEmp() {
		return emp;
	}
	
	// 添加一个用户
	/*
	 * 注意：1.要声明Emp对象，并设置get/set方法
	 * 	   2.在jsp页面中，input标签的name属性为emp.name 的格式 (这样才能获取域对象的属性值)
	 *        不需要使用 传统的 request.getParameter()读取参数了；
	 *        也不需要实现ModelDriven<T>接口了。
	 *     3.然后调用业务层方法执行添加操作。
	 *        
	 */
	public String add(){
		System.out.println(emp);
		if(null == emp){
			session.put("message", "不能传入空值！");
			return "error";
		}
		empService.save(emp);
		return "add";
	}
	
	//跳转编辑界面
	/*
	 * 修改用户时，根据id获取要修改的用户信息；
	 * 注意：1.接收请求中的id ，此id为本类中新建的id属性，并设置set方法；
	 * 	   2.获取相关id的用户信息后，放入session域对象中，方便通过页面进行读取；
	 *     3.页面中的input属性，要有value="${emps.name }" name="emp.id" 格式属性，
	 *       方便读取要修改的值，以及进行提交修改后的操作。
	 */
	public String edit(){
		session.put("emps", empService.findEmpById(id));
		return "edit";
	}
	
	// 修改用户信息
	/*
	 * 编辑读取值之后，修改值，直接提交修改后的数据，直接调用修改业务处理方法即可。
	 */
	public String update(){
		System.out.println(emp);
		if(null == emp){
			session.put("message", "不能传入空值！");
			return "error";
		}
		empService.update(emp);
		return "update";
	}
	
	private Integer id;
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	// 删除
	/*
	 * 读取要删除的对象id，直接删除，然后在struts2.xml中转发到获取列表请求。
	 */
	public String delete(){
		empService.delete(id);
		return "delete";
	}
	
}










