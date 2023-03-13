package com.spring;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.spring.entity.Course;
import com.spring.service.CourseService;
import com.spring.service.CourseServiceImpl;

@SpringBootApplication
public class CourseCrudApplication {

	@Autowired
	private static CourseService courseService;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int ch = 0;
		do {
			System.out.println("1. Add Course");
			System.out.println("2. View All Courses");
			System.out.println("3. View Course By Id");
			System.out.println("4. Update Course");
			System.out.println("5. Delete Course");
			System.out.println("0. Exit");

			System.out.print("Enter your choice: ");
			ch = scanner.nextInt();
			scanner.nextLine(); //consume the newline character

			switch (ch) {
			case 1:
				addCourse(scanner);
				break;
			case 2:
				viewAllCourses();
				break;
			case 3:
				viewCourseById(scanner);
				break;
			case 4:
				updateCourse(scanner);
				break;
			case 5:
				deleteCourse(scanner);
				break;
			case 0:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice!");
				break;
			}
		} while (ch != 0);
		scanner.close();
	}

	private static void addCourse(Scanner scanner) {
		System.out.print("Enter student name: ");
		String name = scanner.nextLine();

		System.out.print("Enter student email: ");
		String email = scanner.nextLine();

		Course course = new Course();
		course.setName(name);
//		course.setEmail(email);

		courseService.saveOrUpdateCourse(course);
		System.out.println("Student added successfully!");
	}

	private static void viewAllCourses() {
		List<Course> courses = courseService.getAllCourses();
		if (courses.isEmpty()) {
			System.out.println("No courses found!");
		} else {
			System.out.println("List of courses:");
			for (Course course : courses) {
				System.out.println(course.getId() + " - " + course.getName() + " (" + course.getEmail() + ")");
			}
		}
	}

	private static void viewCourseById(Scanner scanner) {
		System.out.print("Enter course id: ");
		Long id = scanner.nextLong();

		Course course = courseService.getCourseById(id);
		if (course == null) {
			System.out.println("course not found!");
		} else {
			System.out.println("course details:");
			System.out.println(course.getId() + " - " + course.getName() + " (" + course.getEmail() + ")");
		}
	}

	private static void updateCourse(Scanner scanner) {
		System.out.print("Enter course id: ");
		Long id = scanner.nextLong();

		Course course = courseService.getCourseById(id);
		if (course == null) {
			System.out.println("course not found!");
		} else {
			System.out.print("Enter course name (press enter to keep current value '" + course.getName() + "'): ");
			String name = scanner.nextLine();
			if (!name.isBlank()) {
				course.setName(name);
			}

			System.out.print("Enter course email (press enter to keep current value '" + course.getEmail() + "'): ");
			String email = scanner.nextLine();
			if (!email.isBlank()) {
				course.setEmail(email);
			}

			courseService.saveOrUpdateCourse(course);
			System.out.println("Student updated successfully!");
		}
	}
	
	private static void deleteCourse(Scanner scanner) {
	    System.out.print("Enter course id: ");
	    Long id = scanner.nextLong();

	    Course course = courseService.getCourseById(id);
	    if (course == null) {
	        System.out.println("course not found!");
	    } else {
	    	courseService.deleteCourse(course);
	        System.out.println("course deleted successfully!");
	    }
	}


	

}
