package dao;

import java.util.List;

import entity.Emp;

public interface EmpDao {
	
	//插入一个对象
	public void save(Emp emp);
	
	//查询
	public List<Emp> findAll();
	
	//根据id进行查询
	public Emp findEmpById(int id);
	
	//修改
	public void update(Emp emp);
	
	//删除
	public void delete(int id);
	
}
