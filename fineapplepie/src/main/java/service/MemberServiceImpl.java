package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vo.MerzeeMember;
import dao.MemberDao;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDao memberDao;

	public void add(MerzeeMember m) throws Exception {
		memberDao.add(m);
	}

	@Override
	public List<MerzeeMember> getMember(int keyword, Object value)
			throws Exception {
		ArrayList<MerzeeMember> list = new ArrayList<MerzeeMember>();
		if(keyword == EMAIL){
			list.add(memberDao.getMemberByEmail((String)value));
		}
		return list;
	}

	@Override
	public boolean exist(String email, String password) throws Exception {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("email", email);
		paramMap.put("password", password);
		return memberDao.exist(paramMap);
	}
	

/*	@Override
	public List<Student> getStudent(int keyword, Object value)
			throws Exception {
		ArrayList<Student> list = new ArrayList<Student>();
		if(keyword == NO) {
			list.add( studentDao.getStudent((Long)value) );
		} else if(keyword == EMAIL) {
			list.add( studentDao.getStudentByEmail((String)value) );
		}
		return list;
	}

	@Override
	public void change(Student s) throws Exception {
		studentDao.change(s);
	}

	@Override
	public void remove(long no) throws Exception {
		studentDao.remove(no);
	}

	@Override
	public Collection<Student> getStudentList() throws Exception {
		return studentDao.getStudentList();
	}

	@Override
	public boolean exist(String email, String password) throws Exception {
		HashMap<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("email", email);
		paramMap.put("passwd", password);
		
		return studentDao.exist(paramMap);
	}
*/
}









