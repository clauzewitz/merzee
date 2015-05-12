package dao;

import java.util.Map;

import vo.MerzeeMember;

public interface MemberDao {
	void add(MerzeeMember s) throws Exception;
	//void change(Member s) throws Exception;
	//void remove(String email) throws Exception;
	//Collection<Member> getMemberList() throws Exception;
	boolean exist(Map<String, String> paramMap) throws Exception;//서비스에서 넘어온 paramMap을 이용하여 DB에서 추출
	MerzeeMember getMemberByEmail(String email) throws Exception;//서비스에서 넘어온 email을 이용하여 DB에서 추출
}
