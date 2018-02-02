package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.EmpDao;
import entity.Emp;
import service.EmpService;

@Service("empService")
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpDao empDao;
	
	public List<Emp> findAll() {		 
		return empDao.findAll();
	}

	public void save(Emp emp) {
		empDao.save(emp);
	}

	public void update(Emp emp) {
		empDao.update(emp);
	}

	public void delete(int id) {
		empDao.delete(id);
	}

	public Emp findEmpById(int id) {
		return empDao.findEmpById(id);
	}

}
