package org.wipro.rest_crud.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.wipro.rest_crud.dto.Student;
import org.wipro.rest_crud.repository.studentRepository;


@Component
public class StudentDao {

@Autowired
studentRepository repository;

	public void save(Student student) {
		repository.save(student);//save is inbuilt method of jpa repository and it internally consisit of persist of entitymanagerfactory
		
	}
	public List<Student> saveAll(List<Student> students) {
		
		return repository.saveAll(students);
	}
	


//optional will have one particular data

	public Optional<Student> findById(int id) {
		return repository.findById(id);
	}

	public List<Student> fetchAll() {
//		List<Student>stu=new ArrayList<Student>();
		
		return repository.findAll();
		//.forEach(stu1 ->stu.add(stu1));
	}

	

	public List<Student> findByName(String name) {
		return repository.findByName(name);
	}

	public List<Student> findByMobile(long mobile) {
		return repository.findByMobile(mobile);
	}

	public List<Student> findByResult(String result) {
		return repository.findByResult(result);
	}
	public List<Student> findByMaths(int maths) {
		return repository.findByMathsGreaterThan(maths);
	}
	public List<Student> findByEnglish(int english) {
		return repository.findByEnglishGreaterThan(english);
	}
	/*
	public List<Student> findByAllSub(int maths, int english, int science) {
		return repository.findByAllGreaterThan(maths,english,science);
	}
	*/
	public void deleteById(int id) {
		repository.deleteById(id);
		
	}
	public void deleteAllRecord() {
		 repository.deleteAll();
	}
//	public List<Student> fetchByMathsGreater(int marks) {
//	return 	repository.findByMathsGreaterThanOrEqualTo(marks);
//	}
//	public List<Student> fetchByenglishGreater(int marks) {
//		return 	repository.findByEnglishGreaterThanOrEqualTo(marks);
//	}
//	public List<Student> fetchByScienceGreater(int marks) {
//		return 	repository.findByScienceGreaterThanOrEqualTo(marks);
//	}


	


	

	
	

}
