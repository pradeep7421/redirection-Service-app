package com.ps.redirection.lambda_practice;

import java.util.Arrays;
import java.util.List;

public class Employee {
private int empId;
private String empName;
private String empDeptName;
private long empSalary;

public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public String getEmpDeptName() {
	return empDeptName;
}
public void setEmpDeptName(String empDeptName) {
	this.empDeptName = empDeptName;
}
public long getEmpSalary() {
	return empSalary;
}
public void setEmpSalary(long empSalary) {
	this.empSalary = empSalary;
}
@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Employee [empId=");
	builder.append(empId);
	builder.append(", empName=");
	builder.append(empName);
	builder.append(", empDeptName=");
	builder.append(empDeptName);
	builder.append(", empSalary=");
	builder.append(empSalary);
	builder.append("]");
	return builder.toString();
}

public Employee(int empId, String empName, String empDeptName, long empSalary) {
	super();
	this.empId = empId;
	this.empName = empName;
	this.empDeptName = empDeptName;
	this.empSalary = empSalary;
}
public Employee() {
	
}
public List<Employee> getEmployeeList(){
	Employee employee1 = new Employee(1,"Ravi","HR",8000);
	Employee employee2 = new Employee(2,"Sachin Jaiswal","ADMIN",80000);
	Employee employee3 = new Employee(3,"Jayali","FINANCE",40000);
	Employee employee4 = new Employee(4,"Kishan","HR",30000);
	Employee employee5 = new Employee(5,"Akanksha","HR",90000);
	Employee employee6 = new Employee(6,"Nilesh yadav","ADMIN",51000);
	Employee employee7 = new Employee(7,"Pradeep Singh","HR",45000);
	Employee employee8 = new Employee(8,"Riya","FINANCE",60000);
	Employee employee9 = new Employee(9,"Aakash","HR",98000);
	Employee employee10 = new Employee(10,"Pradeep kumar","ADMIN",20000);
	Employee employee11 = new Employee(11,"Sachin Singh","HR",45000);
	Employee employee12 = new Employee(12,"Harsh","FINANCE",35000);
	Employee employee13 = new Employee(13,"Rehan kakkar","HR",10000);
	Employee employee14 = new Employee(14,"Sonu kumar","ADMIN",20000);
//	Employee employee15 = new Employee(15,"Aakash","HR",99999);
//	Employee employee16 = new Employee(15,"Aakash","HR",91111);
	List<Employee> employees = Arrays.asList(employee1, employee2, employee3, employee4, employee5, employee6,
			employee7, employee8, employee9, employee10, employee11, employee12,employee13,employee14
	/* ,employee15,employee16 */);
	return employees;
}
public Employee increaseSalaryBy3333(){
	this.empSalary+=3333;
	return this;
}

}
