package service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DiaryDao;

import vo.MerzeeDiary;

@Service
public class DiaryServiceImpl implements DiaryService {

	@Autowired
	DiaryDao diaryDao;
	
	@Override
	public void add(MerzeeDiary m) throws Exception {
		System.out.println("서비스 진입");
		diaryDao.add(m);
	}

	@Override
	public boolean exist(Map<String, String> paramMap) throws Exception {
		
		return false;
	}

	@Override
	public List<MerzeeDiary> getDiary(int keyword, Object value)
			throws Exception {
		
		return null;
	}

	@Override
	public Collection<MerzeeDiary> getDiaryList(String email) throws Exception {
		return diaryDao.getDiaryList(email);
	}

}
