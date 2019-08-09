package 커넥터;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Database.Userdata;

public class Dao {
 
	List list= new  ArrayList();
	
	public void insertUser(Userdata u) {
		
		list.add(u);// 오브젝트 배열로 들어감
	}
	public List select() {
		return list;
	}

}
