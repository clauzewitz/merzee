package pattern.adapter;

import java.util.Collection;

public class StudentMysqlDao implements StudentDao {

	@Override
	public void add() {}

	@Override
	public Collection getStudentList() {
		return null;
	}

	@Override
	public void update() {}

}
