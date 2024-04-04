package org.wipro.rest_crud.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.wipro.rest_crud.dao.StudentDao;
import org.wipro.rest_crud.dto.Student;
import org.wipro.rest_crud.exception.DataNotFoundException;
import org.wipro.rest_crud.helper.ResponseStructure;

@Component
public class StudentService {
	@Autowired
	StudentDao dao;
	
	@Autowired
	ResponseStructure structure;

//to save the student record
	public ResponseStructure saveStudent(Student student) {
		double percentage=(student.getEnglish()+student.getMaths()+student.getScience())/3.0;
		student.setPercentage(percentage);
		
		if(student.getEnglish()<35 ||student.getMaths()<35 ||student.getScience()<35)
		{
			student.setResult("Fail");
		}
		else
		{
			if(student.getPercentage()>=85)
			student.setResult("Distnction");
		else if(student.getPercentage()>=60)
			student.setResult("first class");
		else if(student.getPercentage()>=35)
			student.setResult("pass");
		else
			student.setResult("fail");
		}
			
		dao.save(student);
		structure.setMessage("Data saved success");
		structure.setStatus(HttpStatus.CREATED.value());//it will return the status value for the particular method, here CREATED IS ENUM.
		structure.setData(student);
		return structure;
	}
	
	//to save multiple records
public ResponseStructure saveAllStudents(List<Student> students) {
	for(Student student:students)
	{
		double percentage=(student.getEnglish()+student.getMaths()+student.getScience())/3.0;
		student.setPercentage(percentage);
		
		if(student.getEnglish()<35 ||student.getMaths()<35 ||student.getScience()<35)
		{
			student.setResult("Fail");
		}
		else
		{
			if(student.getPercentage()>=85)
			student.setResult("Distnction");
		else if(student.getPercentage()>=60)
			student.setResult("first class");
		else if(student.getPercentage()>=35)
			student.setResult("pass");
		else
			student.setResult("fail");
		}
	}
	List<Student> list=dao.saveAll(students);
		
		 structure.setMessage("all data saved");
		 structure.setStatus(HttpStatus.CREATED.value());
		 structure.setData(list);
		 return structure;
	}

//to find the student by id

	public ResponseStructure findStudentById(int id) 
	{
		java.util.Optional<Student> op=dao.findById(id);
		if(op.isEmpty())
		{
//			structure.setData(null);
//			structure.setMessage("data not found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
			throw new DataNotFoundException("data not found using this id"+id);
		}
		else
		{
			structure.setData(op.get());
			structure.setMessage("Data found");
			structure.setStatus(HttpStatus.FOUND.value());
		}
		return structure;
	}

	public ResponseStructure fetchAllStudents( ) {
		List<Student> list = dao.fetchAll();
		if (list.isEmpty()) {
			throw new DataNotFoundException("data not found cuz list is empty");
		} else {
//			ResponseStructure<List<Student>> structure = new ResponseStructure<>();
			structure.setData(list);
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Data Found Success");
			
		}
		return structure;

}

	public ResponseStructure findStudentByName( String name ) {
		List<Student> student= dao.findByName(name);
		if (student.isEmpty()) {
			throw new DataNotFoundException("data not found using this name"+name);
		} else {
//			ResponseStructure<List<Student>> structure = new ResponseStructure<>();// no use cuz we are created it glpobally
			structure.setData(student);
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Data Found Success");
			
		}
		
		return structure;
	}

	public ResponseStructure findStudentByMobile(long mobile) {
		List<Student> student= dao.findByMobile(mobile);
		if (student.isEmpty()) {
			throw new DataNotFoundException("data not found using this mobile"+mobile);
		} else {
			structure.setData(student);
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Data Found Success");
			
		}
		return structure;
		
		
	}
	//find by result

	public ResponseStructure findStudentByResult(String result) {
		List<Student> student= dao.findByResult(result);
		if (student.isEmpty()) {
			throw new DataNotFoundException("data not found using this result"+result);
		} else {
			structure.setData(student);
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Data Found Success");
			
		}
		return structure;
	}

	public ResponseStructure findStudentByMaths(int maths) {
		List<Student> student= dao.findByMaths(maths);
		
		if (student.isEmpty()) {
			throw new DataNotFoundException("data not found using this "+maths);
		} else {
			structure.setData(student);
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Data Found Success");
			
		}
		return structure;
	}

	public ResponseStructure findStudentByEnglish(int english) {
List<Student> student= dao.findByEnglish(english);
		
		if (student.isEmpty()) {
			throw new DataNotFoundException("data not found using this "+english);
		} else {
			structure.setData(student);
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Data Found Success");
			
		}
		return structure;
	}
/*
	public ResponseStructure findStudentByAllSub(int maths, int english, int science) {
        List<Student> student= dao.findByAllSub(maths,english,science);
		
		if (student.isEmpty()) {
			structure.setMessage("data not found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
		} else {
			structure.setData(student);
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Data Found Success");
			
		}
		return structure;
		
	}
	*/

	public ResponseStructure deleteById(int id) {
		java.util.Optional<Student> student= dao.findById(id);
		dao.deleteById(id);
		structure.setMessage("data deleted success");
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setData(student);
		return structure;
	
	}

	public ResponseStructure deleteAllRecords() {
List<Student> student= dao.fetchAll();
dao.deleteAllRecord();
		
		if (student.isEmpty()) {
			throw new DataNotFoundException("data not found ");
		} else {
			structure.setData(student);
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Data deleted Success");
			
		}
		return structure;
		
	}

//	public ResponseStructure findBySubjectMarksGreater(String subject, int marks) {
//		List<Student> list=null;
//		if(subject.equalsIgnoreCase("maths"))
//		{
//			list=dao.fetchByMathsGreater(marks);
//		}
//		else if(subject.equalsIgnoreCase("english"))
//		{
//			list=dao.fetchByenglishGreater(marks);
//		}
//		else if(subject.equalsIgnoreCase("science"))
//		{
//			list=dao.fetchByScienceGreater(marks);
//		}
//		else {
//			list=new ArrayList<Student>();
//		}
//		
//		if (list.isEmpty()) {
//			structure.setMessage("list is empty");
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
//			structure.setData(null);
//		} else {
//			structure.setData(list);
//			structure.setStatus(HttpStatus.FOUND.value());
//			structure.setMessage("Data deleted Success");
//			
//		}
//		return structure;
//		
//	}
}
