package org.wipro.rest_crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.wipro.rest_crud.dto.Student;
import org.wipro.rest_crud.helper.ResponseStructure;
import org.wipro.rest_crud.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;


@RestController //will also convert the java into json
//it is combination of response body and controller. so in api we should use the response for every method soo rather than that we go for this.
public class StudentController {
	
	
private static final int ResponseEntity = 0;
private static final int ResponseStructure = 0;
private static final int L = 0;
//	@Autowired
//	ResponseStructure structure;
	//end point.. will write logical part in service soo
//	@PostMapping("/students")//we are the data so postmapping.
//	public ResponseStructure saveStudent(@RequestBody Student student)//@RequestBody willl convert the json object into java object.
//	{
//		structure.setMessage("Data is saved");
//		//structure.setStatus(201); rather than this will go for
//		structure.setStatus(HttpStatus.CREATED.value());
//		structure.setData(student);
//		return structure;
//	}
	//to use the studentservice class things in this class we give autowired.
	@Autowired
	StudentService service ;
	@Operation(summary = "saving one student record")
	@PostMapping("/students")
	public ResponseStructure saveStudent(@RequestBody Student student)
	{
		return service.saveStudent(student);
	}
	
	//to save multiple records
	@PostMapping("/students/many")
	public ResponseStructure saveAllStudents(@RequestBody List<Student> students)
{
		return service.saveAllStudents(students);
	}
	
	@GetMapping("/students/{id}")//this is called path variable
	//("students?id=1) this way also we can write the url, this is associated with the @REQPARAM
	public ResponseStructure findStudentById(@PathVariable int id)
	{
		return service.findStudentById(id);
	}
	
	@GetMapping("/studentss")
	public ResponseStructure fetchAllStudents()
	{
		return service.fetchAllStudents();
	}
	
	@GetMapping("/students/name/{name}")
	public ResponseStructure findStudentByName(@PathVariable String name)
	{
		return service.findStudentByName(name);
	}
	@GetMapping("/students/mobile/{mobile}")
	public ResponseStructure findStudentByMobile(@PathVariable long mobile)
	{
		return service.findStudentByMobile(mobile);
	}
	
	@GetMapping("students/result/{result}")
	public ResponseStructure findStudentByResult(@PathVariable String result)
	{
		return service.findStudentByResult(result);
	}
	//to fetch students who scored >60 in maths
	@GetMapping("students/maths/greater/{maths}")
	public ResponseStructure findStudentByMaths(@PathVariable int maths)
	{
		return service.findStudentByMaths(maths);
	}
	
	@GetMapping("students/english/greater/{english}")
	public ResponseStructure findStudentByEnglish(@PathVariable int english)
	{
		return service.findStudentByEnglish(english);
	}

	@GetMapping("/students/deletebyid/{id}")
	public ResponseStructure deleteById(@PathVariable int id)
	{
		return service.deleteById(id);
	}
	@GetMapping("/students/delete/all")
	public ResponseStructure deleteAllRecords()
	{
		return service.deleteAllRecords();
	}
//	@GetMapping("students/findallbysub")
//	public ResponseStructure findBySubjectMarksGreater(String subject, int marks)
//	
//	{
//		return service.findBySubjectMarksGreater(subject,marks);
//	}
	

	
}
