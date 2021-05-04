package com.ex;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;

public class MainLogic {


	public static void main(String[] args) {
		
		Configuration cf = new Configuration();
		cf.configure("configuration.xml");
		SessionFactory sf = cf.buildSessionFactory();
	
		Session se = sf.openSession();
		
		Scanner sc = new Scanner(System.in);
		int studentId;
		String studentName;
		int studentMarks;
		
		
		System.out.println("Enter: 1 to Insert Student; 2 to Update Student; 3. to Delete Student; 4. to Display Student; 5. to Exit");
		int option = sc.nextInt();
		while(option!=5) {
			
		switch(option) {
		case 1:
		
		do {
			System.out.println("Enter the student id that you would like to insert");
			studentId = sc.nextInt();
			System.out.println("Enter the student name for the id" + studentId);
			studentName = sc.next();
			System.out.println("Enter the student marks for the id" + studentId);
			studentMarks = sc.nextInt();
			
			
			Student stu = new Student();
			stu.setSid(studentId);
			stu.setSname(studentName);
			stu.setSmarks(studentMarks);
			
			se.save(stu); // insert 2. update() -> update 3. delete() -> delete 4. load()/get() -> select
			
			Transaction tx=se.beginTransaction();
			tx.commit();
			
			System.out.println("Enter Yes to continue inserting records");
			
		} while(sc.next().equalsIgnoreCase("Yes"));
		break;
		
	case 2:
		
		do {
			System.out.println("Enter the student id that you would like to update");
			studentId = sc.nextInt();
			System.out.println("Enter the new student marks for the id" + studentId);
			studentMarks = sc.nextInt();
					
			Student stu = (Student) se.load(Student.class, studentId);
			stu.setSmarks(studentMarks);
			se.update(stu); // insert 2. update() -> update 3. delete() -> delete 4. load()/get() -> select
			
			Transaction tx=se.beginTransaction();
			tx.commit();
			
			System.out.println("Enter Yes to continue updating records");
			
		} while(sc.next().equalsIgnoreCase("Yes"));
		break;	
	case 3:
	
		do {
			System.out.println("Enter the student id that you would like to delete");
			studentId = sc.nextInt();
					
			Student stu = (Student) se.load(Student.class, studentId);
			se.delete(stu); // insert 2. update() -> update 3. delete() -> delete 4. load()/get() -> select
			
			Transaction tx=se.beginTransaction();
			tx.commit();
			
			System.out.println("Enter Yes to continue updating records");
			
		} while(sc.next().equalsIgnoreCase("Yes"));
		break;		
	case 4:
		
		do {
			System.out.println("Enter the student id that you would like to view");
			studentId = sc.nextInt();
					
			Student stu = (Student) se.load(Student.class, studentId);
			System.out.println(stu.getSid()+"  "+stu.getSname()+"  "+stu.getSmarks());
			
			System.out.println("Enter Yes to continue updating records");
			
		} while(sc.next().equalsIgnoreCase("Yes"));
		break;
		
		}
		System.out.println("Enter: 1 to Insert Student; 2 to Update Student; 3. to Delete Student; 4. to Display Student; 5. to Exit");
		option = sc.nextInt();
		} 		
		se.close();
	}			
	}


