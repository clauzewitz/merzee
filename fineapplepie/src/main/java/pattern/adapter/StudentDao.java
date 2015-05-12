package pattern.adapter;

import java.util.Collection;

public interface StudentDao {
	void add();
	Collection getStudentList();
	void update();
}
