package kr.co.burger.menuDao;

import kr.co.burger.domain.Userdate;
import kr.co.burger.domain.shopDate;

public interface menuRecomMapper {
	public int recom1(Userdate LoginInfo);
	public int recom2(int code);
	public int recom3(int code);
}
