package com.jp.studentapp;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentAppApplication implements CommandLineRunner{
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(StudentAppApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		/*
		CREATE
		*/
        //case1				// simple case like no foriegn key
//        Student student = new Student();
//        student.setId(101);
//        student.setStudentName("abc");
//        student.setEmail("a@a.com");
//        student.setMobileNumber(9019L);
//		
//		Course course1 = new Course();
//		course1.setId(1);
//		course1.setName("Java");
//		course1.setFees(5000);
//		
//		Course course2 = new Course();
//		course2.setId(2);
//		course2.setName("Angular");
//		course2.setFees(4000);
//		
//		studentRepository.save(student);
//		courseRepository.saveAll(Arrays.asList(course1, course2));
		
		//case2						//is General Case
//        Student student = new Student();
//        student.setId(101);
//        student.setStudentName("abc");
//        student.setEmail("a@a.com");
//        student.setMobileNumber(9019L);
//		
//		Course course1 = new Course();
//		course1.setId(1);
//		course1.setName("Java");
//		course1.setFees(5000);
//		
//		Course course2 = new Course();
//		course2.setId(2);
//		course2.setName("Angular");
//		course2.setFees(4000);
//		
//		studentRepository.save(student);
//		course1.setStudent(student);
//		course2.setStudent(student);
//		courseRepository.saveAll(Arrays.asList(course1, course2));
		
		//case3					// exception , without parent saving no child
//        Student student = new Student();
//        student.setId(101);
//        student.setStudentName("abc");
//        student.setEmail("a@a.com");
//        student.setMobileNumber(9019L);
//		
//		Course course1 = new Course();
//		course1.setId(1);
//		course1.setName("Java");
//		course1.setFees(5000);
//		
//		Course course2 = new Course();
//		course2.setId(2);
//		course2.setName("Angular");
//		course2.setFees(4000);
//		
//		student.setCourses(Arrays.asList(course1, course2));
//		studentRepository.save(student);
		
		//case4			// no exception , before saving parent, save all childs
//		Student student = new Student();
//        student.setId(101);
//        student.setStudentName("abc");
//        student.setEmail("a@a.com");
//        student.setMobileNumber(9019L);
//		
//		Course course1 = new Course();
//		course1.setId(1);
//		course1.setName("Java");
//		course1.setFees(5000);
//		
//		Course course2 = new Course();
//		course2.setId(2);
//		course2.setName("Angular");
//		course2.setFees(4000);
//		
//		student.setCourses(Arrays.asList(course1, course2));
//		courseRepository.saveAll(Arrays.asList(course1, course2));
//		studentRepository.save(student);
		
		//case5				// cascade = ALL
//		Student student = new Student();
//        student.setId(101);
//        student.setStudentName("abc");
//        student.setEmail("a@a.com");
//        student.setMobileNumber(9019L);
//		
//		Course course1 = new Course();
//		course1.setId(1);
//		course1.setName("Java");
//		course1.setFees(5000);
//		
//		Course course2 = new Course();
//		course2.setId(2);
//		course2.setName("Angular");
//		course2.setFees(4000);
//		
//		student.setCourses(Arrays.asList(course1, course2));
//		studentRepository.save(student);
		
		/*
		 UPDATE
		 */
		//case1				// with out cascade=ALL  // exception
							// use lazy loading , fetch= type.eager	// only parent updating, not child
//		Student obj1 = studentRepository.findById(101).get();
//		obj1.setStudentName("Jagadish");
//		Course obj2 = obj1.getCourses().get(0);
//		obj2.setFees(6000);
//		studentRepository.save(obj1);
		
		//case2				// with cascade=ALL
				// use lazy loading , fetch= type.eager	// both parent & child updating
//		Student obj1 = studentRepository.findById(101).get();
//		obj1.setStudentName("Jagadish");
//		Course obj2 = obj1.getCourses().get(0);
//		obj2.setFees(6000);
//		studentRepository.save(obj1);
		
		/*
		READ
		*/
		//case1			//without eager , without cascade = ALL		//exception   =>  LazyInitializationException
//		Student obj1 = studentRepository.findById(101).get();
//		System.out.println(obj1.getStudentName());
//		Course obj2 = obj1.getCourses().get(0);
//		System.out.println(obj2.getName());
		
		//case2			//without eager , with cascade = ALL		//exception   =>  LazyInitializationException
//		Student obj1 = studentRepository.findById(101).get();
//		System.out.println(obj1.getStudentName());
//		Course obj2 = obj1.getCourses().get(0);
//		System.out.println(obj2.getName());
		
		//case3			//with eager , without cascade = ALL		//exception   =>  LazyInitializationException
//		Student obj1 = studentRepository.findById(101).get();
//		System.out.println(obj1.getStudentName());
//		Course obj2 = obj1.getCourses().get(0);
//		System.out.println(obj2.getName());
		
		/*
		DELETE
		*/
		//case1					//with eager , without cascade = ALL	//only parent table deleted
		//studentRepository.deleteById(101);
		
		//case2					//with eager , with cascade = ALL	// both tables parent and child deleted
		//studentRepository.deleteById(101);
		
		/*
		 Update 3 more cases 3,4,5 
		 */
		 //case3(cascase = ALL)		//while updating a parent , if any new child is inserted	//inserted
//		Student obj1 = studentRepository.findById(101).get();
//		obj1.setStudentName("Jagaish");
//		Course course3 = new Course();
//		course3.setId(5);
//		course3.setName("Python");
//		course3.setFees(3000);
//		course3.setStudent(obj1);
//		obj1.getCourses().add(course3);
//		studentRepository.save(obj1);
		
		//case4(cascase = ALL)		//Trying to remove 1 existing child , while updating parent		//not removed
//		Student obj1 = studentRepository.findById(101).get();
//		obj1.setStudentName("Jagaish");
//		obj1.getCourses().remove(0);
//		studentRepository.save(obj1);
		
		//To remove an existing child while updating a parent
        //orphanRemoval = true is required 
        //in parent class
		
		System.out.println("done");
	}

}
