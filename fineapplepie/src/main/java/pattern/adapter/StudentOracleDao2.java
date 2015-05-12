package pattern.adapter;

import java.util.Collection;

public class StudentOracleDao2 extends StudentOracleDao implements StudentDao {

	@Override
	public void add() {
		insert();
	}

	@Override
	public Collection getStudentList() {
		return list();
	}

	@Override
	public void update() {
		// 변경작업

	}

}




