package com.example.demo.repository;

//public class EmployeeRepository {
//
//}

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
public class EmployeeRepository {

	@Autowired
	JdbcTemplate jdbc;

	public List<Employee> findAll() {
		return jdbc.query("SELECT * FROM EMPLOYEE", new BeanPropertyRowMapper(Employee.class));

	}

	// public List<Person> findAll(){
	// return jdbc.query("select * from person", new PersonRowMapper());
	// }

	public Employee fineOne(int id) {
		return (Employee) jdbc.queryForObject("select * from employee where id=?", new Object[] { id },
				new BeanPropertyRowMapper(Employee.class));
	}

	public int deleteOne(int id) {
		return jdbc.update("delete from employee where id=?", new Object[] { id });
	}

	public Object addOne(Employee employee) {
		return jdbc.update("insert into employee (id,first_name,last_name,empDeptNo,empHireDate,active)" + "values(?,?,?,?,?,?)",
				new Object[] { employee.getId(), employee.getFirst_name(), employee.getLast_name(),employee.getEmpDeptNo(), new Timestamp(employee.getEmpHireDate().getTime()), employee.isActive()});
	}

	public int UpdateOne(Employee employee) {
		return jdbc.update(
				"	update employee	" + "	set first_name =?, last_name = ? , empDeptNo =? , empHireDate =? , active =?	" + "	where id=?	",
				new Object[] { employee.getFirst_name(), employee.getLast_name(),employee.getEmpDeptNo(), new Timestamp(employee.getEmpHireDate().getTime()), employee.isActive(), employee.getId()

				});
	}
	


	class EmployeeRowMapper implements RowMapper<Employee> {

		@Override
		public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
			Employee employee = new Employee();
			employee.setId(rs.getInt("id"));
			employee.setFirst_name(rs.getString("first_name"));
			employee.setLast_name(rs.getString("last_name"));
			employee.setEmpDeptNo(rs.getInt("empDeptNo"));
			employee.setEmpHireDate(rs.getTimestamp("empHireDate"));
			employee.setActive(rs.getBoolean("active"));

			return employee;
		}

	}

}
