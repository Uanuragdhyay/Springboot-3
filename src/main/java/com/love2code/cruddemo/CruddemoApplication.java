package com.love2code.cruddemo;

import com.love2code.cruddemo.dao.StudentDAO;
import com.love2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner (StudentDAO studentDAO){
		return runner ->{
			//ceateStudent(studentDAO);
			creteMultipleStudent(studentDAO);
			//readStudent(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateTheStudent(studentDAO);
			//deleteTheStudent(studentDAO);
            //deleteAll(studentDAO);
		};
	}

	private void deleteAll(StudentDAO studentDAO) {
		System.out.println("deleting all students");
		int numRowsDeleted= studentDAO.deleteAll();
		System.out.println("deleted rows count: "+numRowsDeleted);
	}

	private void deleteTheStudent(StudentDAO studentDAO) {
	//retrieving the student based on primary key
		int studentid=3;
		System.out.println("deleting student of id "+studentid);
	//deleting the student with that id
	    studentDAO.delete(studentid);
	}

	private void updateTheStudent(StudentDAO studentDAO) {
		//retrieve the student based on id
		int studentID =1;
		System.out.println("getting student with id "+studentID );
		Student myStudent= studentDAO.findById(studentID);

		// change first name to scooby
		System.out.println("changing the first name to John");
		myStudent.setFirstName("John");

		// update the student
		studentDAO.update(myStudent);

		//display the updated student
		System.out.println("updated a student "+myStudent);

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents= studentDAO.findByLastName("duck");

		for(Student tempstudent:theStudents){
			System.out.println(tempstudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get a list of students

		List<Student> theStudents= studentDAO.findAll();


		//display list of students
		for(Student tempStudent:theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
//create a student object
		System.out.println("creating the new student object ...");
		Student tempstudent= new Student("daffy","duck","daffycool20204@gmail.com");

//save the student
		studentDAO.save(tempstudent);

//display id of the saved student
		int theID= tempstudent.getId();
		System.out.println("saved student. generated id is : "+ theID);

//retrieve the student based on id
		System.out.println("retrieving student with id: "+theID);
		Student myStudent=  studentDAO.findById(theID);

//retrieve student
		System.out.println("found the student: "+myStudent);

	}

	private void creteMultipleStudent(StudentDAO studentDAO) {
//create multiple studentS
		System.out.println("creating 3 new student object...");
		Student tempStudent1 = new Student("john","aoe","john@2024gmail.com");
		Student tempStudent2 = new Student("marry","boe","mar6y@2024gmail.com");
		Student tempStudent3= new Student("katy","coe","katy@2024gmail.com");

//save the student objects
		System.out.println("saving these student objects....");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void ceateStudent(StudentDAO studentDAO) {
//create the student object
		System.out.println("creating a new student object...");
		Student tempStudent= new Student("paul","Doe","paul@2024gmail.com");


//save the student object
		System.out.println("saving the student object...");
		studentDAO.save(tempStudent);

//display id of saved student
		System.out.println("saved student. Generated id : "+tempStudent.getId());
	}

}
