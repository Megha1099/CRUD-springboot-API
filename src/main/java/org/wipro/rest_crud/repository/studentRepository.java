package org.wipro.rest_crud.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wipro.rest_crud.dto.Student;

public interface studentRepository extends JpaRepository<Student, Integer >//entity class name and primary key's data type wee need to write in generics.
// it is an interface we are extending it cuz, it will internally it has some inbuilt methods.
{

	
	 List<Student> findByName(String name);

	List<Student> findByMobile(long mobile);

	List<Student> findByResult(String result);//findByName is created by developer but spring will internally create a query and sends the particular data  

	//List<Student> findByMaths(int maths);-- itg ives the marks exactly 60
	
//	List<Student> findByMathsGreaterThanAndEnglishGreaterThan(int maths, int english);---> to fetch multiple sub at atime

	List<Student> findByEnglishGreaterThan(int english);
	List<Student> findByMathsGreaterThan(int maths);

//	List<Student> findByMathsGreaterThanOrEqualTo(int marks);
//
//	List<Student> findByEnglishGreaterThanOrEqualTo(int marks);
//
//	List<Student> findByScienceGreaterThanOrEqualTo(int marks);

	
	
	
}
