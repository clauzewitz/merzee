//DB직관적(DAO)이 아닌 업무직관적(SERVICE)으로 만든거 


package service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vo.Student;
import dao.StudentDao;



@Service
public class StudentServiceImpl implements StudentService {//StudentService를 구현한 구현체
	@Autowired
	StudentDao studentDao;
	
	/*
	 * Class c = ClassforName("java.lang.Exception");
	 * 			= Exception.class*/
	
	
	@Transactional(rollbackFor=Exception.class)//exception에러가 발생하면 롤백해라.
	public void add(Student s) throws Exception {
		studentDao.add(s);
	}

	public List<Student> getStudent(int keyword, Object value)
			throws Exception {
		ArrayList<Student> list = new ArrayList<Student>();
		if(keyword == NO){
			list.add(studentDao.getStudent(((Long)value).longValue()));
		}else if(keyword == EMAIL){
			list.add(studentDao.getStudentByEmail((String)value));
		}
		return list;
	}

	
	public void change(Student s) throws Exception {
		studentDao.change(s);

	}

	
	public void remove(long no) throws Exception {
		studentDao.remove(no);
	}

	
	public Collection<Student> getStudentList() throws Exception {
		return studentDao.getStudentList();
	}

	
	public boolean exist(String email, String passwd) throws Exception {
		HashMap<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("email", email);
		paramMap.put("passwd", passwd);
		
		return studentDao.exist(paramMap);
	}

}
