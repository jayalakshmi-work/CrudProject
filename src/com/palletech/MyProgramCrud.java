package com.palletech;

import java.util.ArrayList;

public class MyProgramCrud {

	public static void main(String[] args) {

		Student s = new Student();
		
		//s.creating();
		
		//s.inserting("ashok", "maths", "ashok@gmail.com");
		//s.inserting("lakshmi", "social", "lakshmi@gmail.com");
		//s.inserting("rahul", "kannada", "rahul@gmail.com");
		
		//s.updating(1, "english", "ashok2@gmail.com");
		
		//s.deleting(3);
		//s.read();
		
		ArrayList<StudentOne> as = s.reading();
		
		for(StudentOne i : as )
		{
			System.out.println(i.getNo());
			System.out.println(i.getName());
			System.out.println(i.getSubject());
			System.out.println(i.getEmail());
		}
	}

}
