package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Employee;

public class EmployeeDAOImpl implements EmployeDAO{

	private EntityManager entityManager;
	
	public EmployeeDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Employee insertEmployee(int id, String name, String surname, int salary) {
		
		Employee employee = new Employee(id, name, surname, salary);
		entityManager.persist(employee);
		return employee;
	}

	
	@Override
	public Employee findEmployee(int id) {
		return entityManager.find(Employee.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAllEmployees() {
		Query query = entityManager.createNamedQuery("Select e from Empoyee e");
		
		return query.getResultList();
	}

	@Override
	public void removeEmployee(int id) {
		Employee employee = findEmployee(id);
		entityManager.remove(employee);
	}

	@Override
	public Employee raiseSalary(int id, int salary) {
		Employee employee = findEmployee(id);
		if(employee != null) {
			employee.setId(employee.getSalary() + salary);
		}
		return employee;
	}
	
	

	}


