package kr.co.burger.userDao;

import kr.co.burger.domain.Userdate;

public interface userMapper {
 
	void insertUser(Userdate u);
	
	void deleteUser(String id);
	
	public void updateUser(Userdate u);
	
	public Userdate logIn(Userdate u);
}
