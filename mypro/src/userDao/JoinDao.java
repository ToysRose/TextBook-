package userDao;
import java.util.ArrayList;
import java.util.List;
import Main.UI;

public class JoinDao {

	private boolean a=true;
	private boolean b=true;
	public String s="";
	
	//정보에 공백을 걸러주는 메소드
	 public String noBlank(String c) {
		while (a==true) {	
			System.out.print(c+":");
			s=UI.sc.nextLine();
			if(s.contains(" ") || s.equals("")) System.out.printf("%s는 공백입력이 되지않습니다.%n",c); 
			else a=false;
		} a=true; 
		return s;
		}
	 public String noempty(String c) {
		 while (a==true) {	
			 System.out.print(c+":");
			 s=UI.sc.nextLine();
			 if(s.equals("")) System.out.printf("%s는 필수로 입력해야합니다.%n",c); 
			 else a=false;
		 } a=true; 
		 return s;
	 }
//	 11자리 아니거나 숫자가 아닌것을 걸러주는 메소드
	 public String onlyNumber(String c) {
	while(b==true) {
		noBlank(c);
		b = false;
		if(s.length()!=11) {
			b=true;
			System.out.println("핸드폰번호 형식이 아닙니다.\n11자리를 입력하세요");
			continue;
		}
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)>'9' || s.charAt(i)<'0')
				b = true;
			}
		if(b == true) System.out.println("숫자 만 입력하세요.");
		
		phnoTool();
		
	}return s; 
	 }
	 
//	 폰번호 11자리받아서 '-'를 추가해주는 메소드
	 public String phnoTool() {

		 List<Object> list=new ArrayList<>();
		 for(int i =0;i<s.length();i++) {
			 list.add(s.charAt(i));
		 }
		 list.add(3, "-");
		 list.add(8, "-");
		 s="";
		for(int i =0;i<list.size();i++) {
			s+=list.get(i);
		}
		 return s;
		 
	 }
	
}
