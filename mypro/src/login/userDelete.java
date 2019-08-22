package login;

import Main.UI;
import userDao.userDao;

public class userDelete {

	public userDelete(String id) {
		new userDao().deleteUser(id);
		UI.LoginStatus=null;
	}
	
	
	


}
