package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@Controller
public class StudentController {

	@Autowired  //obj created by framework itself and we can use that obj in any class 
	private StudentService studentService;
	
	//display list of employees
	@GetMapping("/") 	//mapping HTTP get  request 
	public String viewHomePage(Model model) {
		model.addAttribute("listStudents",studentService.getAllStudents());
		return "index";
	}
	
	@GetMapping("/showNewStudentForm")
	public String showNewStudentForm(Model model) {
		Student student=new Student();
		model.addAttribute("student", student);
		return "new_student";
	}
	
	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student")Student student) {
		//save student to database
		studentService.saveStudent(student);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value = "id")long id, Model model) {
		
		//get student from service 
		Student student=studentService.getStudentById(id);
		
		//set student as model attribute to pre-populate the form 
		model.addAttribute("student", student);
		return "update_student";
	}
	
	@GetMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable(value = "id")long id) {
		
		this.studentService.deleteStudentById(id);
		return "redirect:/";
	}
	
	
}
