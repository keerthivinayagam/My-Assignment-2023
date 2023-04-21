package org.student;

public class Student  {
	
	public void StudentInfo(String name)
	{
		System.out.println("The Name is :"+name);
	}
	
	
	public void StudentInfo(int id)
	{
		System.out.println("The Student Id:"+id);
	}
	public void StudentInfo(String email,long phoneno)
	{
		System.out.println("Student email is "+email);
		System.out.println("Student Phone number is "+phoneno);
	}
	public static void main(String[] args) {
		Student obj=new Student();
		obj.StudentInfo("PRASSANA");
		obj.StudentInfo(518);
		obj.StudentInfo("prasanna@gmail.com",958785858);
		
		
	}

		
		
		
		
	
}
