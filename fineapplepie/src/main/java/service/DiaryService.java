package service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import vo.MerzeeDiary;

public interface DiaryService {
	int ID = 1;
	int EMAIL = 2;
	void add(MerzeeDiary m) throws Exception;
	//void change(Member s) throws Exception;
	//void remove(String email) throws Exception;
	Collection<MerzeeDiary> getDiaryList(String email) throws Exception;
	boolean exist(Map<String, String> paramMap) throws Exception;//서비스에서 넘어온 paramMap을 이용하여 DB에서 추출
	List <MerzeeDiary> getDiary(int keyword, Object value) throws Exception;//서비스에서 넘어온 dry_id을 이용하여 DB에서 추출
}