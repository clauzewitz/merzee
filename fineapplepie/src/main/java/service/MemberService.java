package service;

import java.util.List;
import java.util.Map;

import vo.MerzeeMember;

public interface MemberService {
	/*public static final*/ int EMAIL = 1;
	/*public static final*/ int NAME = 1;
	void add(MerzeeMember m) throws Exception;
	List<MerzeeMember> getMember(int keyword, Object value) throws Exception;// DB에서 해당 멤버 추출용
	//void change(Student s) throws Exception;
	//void remove(long no) throws Exception;
	//Collection<Student> getStudentList() throws Exception;
	boolean exist(String email, String password) throws Exception;// 입력된 이메일, 패스 체크용
}








