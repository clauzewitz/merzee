package dao;

import java.util.Collection;
import java.util.Map;

import vo.MerzeeDiary;

public interface DiaryDao {
	void add(MerzeeDiary s) throws Exception;
	//void change(Member s) throws Exception;
	//void remove(String email) throws Exception;
	Collection<MerzeeDiary> getDiaryList(String email) throws Exception;
	boolean exist(Map<String, String> paramMap) throws Exception;//서비스에서 넘어온 paramMap을 이용하여 DB에서 추출
	MerzeeDiary getDiaryById(String dry_id) throws Exception;//서비스에서 넘어온 dry_id을 이용하여 DB에서 추출
}
