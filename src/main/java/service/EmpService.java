package service;

import java.util.List;

import entity.Emp;

public interface EmpService{
	
	// 查看所有员工信息
	public List<Emp> findAll();
	
	// 添加一个员工
	public void save(Emp emp);
	
	// 修改员工信息
	public void update(Emp emp);
	
	// 删除一个员工
	public void delete(int id);
	
	//根据id进行查询信息
	public Emp findEmpById(int id);
	
}
