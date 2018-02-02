package test;

import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.EmpDao;
import entity.Emp;
import service.EmpService;

public class TestCase {
	
	private EmpDao dao;
	private ApplicationContext ac;
	
	@Before
	public void init(){
		//启动spring容器
		ac = new ClassPathXmlApplicationContext("spring-mybatis.xml", "spring-service.xml");
		//通过容器获得dao对象
		//默认的id是首字母小写之后的接口名
		dao = ac.getBean("empDao", EmpDao.class);
	}
	
	//测试数据库知否连通
	@Test
	public void test1(){
		Object data = ac.getBean("ds", BasicDataSource.class);
		System.out.println(data);	
	}
	
	@Test
	public void test2(){
		Emp emp = new Emp("wyy1", 22);
		dao.save(emp);
		System.out.println("插入成功！");
	}
	
	@Test
	public void test3(){
		List<Emp> emp = dao.findAll();
		for(Emp e:emp){			
			System.out.println(e);
		}
	}
	
	@Test
	public void test4(){
		System.out.println(dao.findEmpById(1003));
	}
	
	@Test
	public void test5(){
		Emp emp = dao.findEmpById(1003); 
		emp.setName("wjm");
		emp.setAge(23);
		dao.update(emp);
		System.out.println("修改成功");
	}
	
	@Test
	public void test6(){
		Emp emp = dao.findEmpById(1003);
		System.out.println(emp);
		dao.delete(1003);
		System.out.println("删除成功！");
		test3();
	}
	
	@Test
	public void test7(){
		EmpService service = ac.getBean("empService", EmpService.class);
		List<Emp> emps = service.findAll();
		for(Emp emp:emps){
			System.out.println(emp);
		}
	}
	
}


