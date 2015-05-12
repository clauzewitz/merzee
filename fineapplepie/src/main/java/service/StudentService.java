package service;

import java.util.Collection;
import java.util.List;

import vo.Student;

public interface StudentService {
	/*public static final*/ int NO = 0;
	/*public static final*/ int EMAIL = 1;
	/*public static final*/ int NAME = 1;
	void add(Student s) throws Exception;
	List<Student> getStudent(int keyword, Object value) throws Exception;
	void change(Student s) throws Exception;
	void remove(long no) throws Exception;
	Collection<Student> getStudentList() throws Exception;
	boolean exist(String email, String password ) throws Exception;
}












