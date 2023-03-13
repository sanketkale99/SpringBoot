package com.spring;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.spring.entity.Course;
import com.spring.service.CourseService;

@SpringBootApplication
public class CourseCrudApplication {


	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(CourseCrudApplication.class, args);

		CourseService courseService=context.getBean(CourseService.class);
		
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
			scanner.nextLine(); // consume the newline character

			switch (ch) {
			case 1:
				addCourse(scanner, courseService);
				break;
			case 2:
				viewAllCourses( courseService);
				break;
			case 3:
				viewCourseById(scanner, courseService);
				break;
			case 4:
				updateCourse(scanner, courseService);
				break;
			case 5:
				deleteCourse(scanner, courseService);
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

//	 name;description;duration;fee;

	private static void addCourse(Scanner scanner, CourseService courseService) {
		System.out.print("Enter course name: ");
		String name = scanner.nextLine();
		System.out.print("Enter course description: ");
		String description = scanner.nextLine();
		System.out.print("Enter course duration: ");
		String duration = scanner.nextLine();
		System.out.print("Enter course fee: ");
		int fee = scanner.nextInt();

		Course course = new Course();
		course.setName(name);
		course.setDescription(description);
		course.setDuration(duration);
		course.setFee(fee);

		courseService.saveOrUpdateCourse(course);
		System.out.println("Course added successfully!");
	}

	private static void viewAllCourses(CourseService courseService) {
		List<Course> courses = courseService.getAllCourses();
		if (courses.isEmpty()) {
			System.out.println("No courses found!");
		} else {
			System.out.println("List of all courses:");
			for (Course course : courses) {
				System.out.println("Course Id :"+course.getId() + " Course Name : " + course.getName() + "Course Description :" + course.getDescription() + "Course Duration : "
						+ course.getDuration() +"Course Fee : " +course.getFee()+"\n");
			}
		}
	}

	private static void viewCourseById(Scanner scanner, CourseService courseService) {

		System.out.print("Enter course id: ");
		int id = scanner.nextInt();

		Course course = courseService.getCourseById(id);
		if (course == null) {
			System.out.println("Course not found!");
		} else {
			System.out.println("Course details:");
			System.out.println("Course Id :"+course.getId() + " Course Name : " + course.getName() + "Course Description :" + course.getDescription() + "Course Duration : "
					+ course.getDuration() +"Course Fee : " +course.getFee()+"\n");
		}
	}

	private static void updateCourse(Scanner scanner, CourseService courseService) {
		System.out.print("Enter course id: ");
		int id = scanner.nextInt();

		Course course = courseService.getCourseById(id);
		if (course == null) {
			System.out.println("Course not found!");
		} else {
			System.out.print("Enter course name (press enter to keep current value '" + course.getName() + "'): ");
			String name = scanner.nextLine();
			if (!name.isBlank()) {
				course.setName(name);
			}

			System.out.print(
					"Enter course description (press enter to keep current value '" + course.getDescription() + "'): ");
			String description = scanner.nextLine();
			if (!description.isBlank()) {
				course.setDescription(description);
			}

			System.out.print(
					"Enter course duration (press enter to keep current value '" + course.getDuration() + "'): ");
			String duration = scanner.nextLine();
			if (!duration.isBlank()) {
				course.setDuration(duration);
			}

			System.out.print("Enter course fee (press enter to keep current value '" + course.getFee() + "'): ");
			String feeString = scanner.nextLine();
			if (!feeString.isBlank()) {
				int fee = Integer.parseInt(feeString);
				course.setFee(fee);
			}

			courseService.saveOrUpdateCourse(course);
			System.out.println("Course updated successfully!");
		}
	}

	private static void deleteCourse(Scanner scanner, CourseService courseService) {
		System.out.print("Enter course id: ");
		int id = scanner.nextInt();

		Course course = courseService.getCourseById(id);
		if (course == null) {
			System.out.println("Course not found!");
		} else {
			courseService.deleteCourse(course);
			System.out.println("Course deleted successfully!");
		}
	}

}
