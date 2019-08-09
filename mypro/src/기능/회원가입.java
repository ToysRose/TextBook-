package 기능;

import Database.Userdata;
import Main.UI;
import 커넥터.BaseUI;
import 커넥터.Dao;

public class 회원가입  extends UI implements BaseUI{
private Dao dao;

	public 회원가입(Dao dao) {
		this.dao=dao;
	}
	private int a=0;
	private String s="";
	
	public void service() {
		Userdata u = new Userdata();
		
		u.setId(re("아이디"));
		s="";
		u.setPass(re("비밀번"));
		s="";
		u.setName(re("이름"));
		s="";
		u.setBrith(re("생일"));		
		dao.insertUser(u);
		
	}
	//정보를 공백 넣게되면 다시입력하라고나옴.
	 String re(String b) {
		while (a==0) {	
			System.out.print(b+":");
			s=sc.nextLine();
			if(s.equals("")) System.out.printf("%s는 필수 입력 정보입니다.%n",b); 
			else a=1;
		} a=0; 
		return s;
		}
}
