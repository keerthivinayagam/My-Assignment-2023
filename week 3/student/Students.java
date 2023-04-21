package org.student;

import org.department.department;

public class Students extends department {
	public void studentName() {
		System.out.println("The student Name is"+"Prasanna");
	}
	public void studentDept()
	{
		System.out.println("Thse Student Department is:"+"COMPUTER SCIENCE");
	}
	public void studentId()
	{
		System.out.println("The student ID is :"+"412518");
	}
	public static void main(String[] args) {
		
		Students obj = new Students();
		System.out.println("college details ");
		obj.collegeName();
		obj.collegeCode();
		obj.collegeRank();
		System.out.println("Department details");
		obj.deptName();
		System.out.println("Student details");
		obj.studentId();
		obj.studentName();
		obj.studentId();
	}

}
