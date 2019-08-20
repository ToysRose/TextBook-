package 기능테스트;



import java.util.ArrayList;
import java.util.List;

public class paper3 {
public static void main(String[] args) {
	 
	String s= "01012341234";
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
	 System.out.println(s);
}
}
