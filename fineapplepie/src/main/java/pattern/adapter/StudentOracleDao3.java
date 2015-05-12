package pattern.adapter;

import java.util.Collection;

public class StudentOracleDao3 implements StudentDao {
	StudentOracleDao old;
	
	public StudentOracleDao3() {
		old = new StudentOracleDao();
	}
	
	@Override
	public void add() {
		old.insert();
	}

	@Override
	public Collection getStudentList() {
		return old.list();
	}

	@Override
	public void update() {
		// 변경 작업

	}

}
