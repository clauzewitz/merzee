package dao;

import java.util.Collection;
import java.util.Map;

import vo.Student;

public interface StudentDao {
	void add(Student s) throws Exception;
	Student getStudent(long no) throws Exception;
	void change(Student s) throws Exception;
	void remove(long no) throws Exception;
	Collection<Student> getStudentList() throws Exception;
	boolean exist(Map<String,String> param) throws Exception;
	Student getStudentByEmail(String email) throws Exception;
}
