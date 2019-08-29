package kr.co.burger.noticeUI;

import org.apache.ibatis.session.SqlSession;
import kr.co.burger.common.db.MyAppSqlConfig;
import kr.co.burger.noticeDAO.noticeMapper;

public class MapperNotice {

	protected noticeMapper mapper;
	
	public MapperNotice() {
		// 마이바티스가 실행시 만드는 구현 객체를 얻어오기
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(noticeMapper.class);
	}
	
}
