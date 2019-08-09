-- 테이블 순서는 관계를 고려하여 한 번에 실행해도 에러가 발생하지 않게 정렬되었습니다.

	-- tb_user Table Create SQL
	CREATE TABLE tb_user
	(
	    user_id      VARCHAR2(20)     NOT not null, 
	    password     VARCHAR2(20)     not null, 
	    user_ad      VARCHAR2(100)    not null, 
	    user_ph      NUMBER           not null, 
	    user_name    VARCHAR2(20)     not null, 
	    CONSTRAINT TB_USER_PK PRIMARY KEY (user_id)
	)
	

	COMMENT ON TABLE tb_user IS '유저'
	

	COMMENT ON COLUMN tb_user.user_id IS '아이디'
	

	COMMENT ON COLUMN tb_user.password IS '비밀번호'
	

	COMMENT ON COLUMN tb_user.user_ad IS '주소'
	

	COMMENT ON COLUMN tb_user.user_ph IS '핸드폰번호'
	

	COMMENT ON COLUMN tb_user.user_name IS '이름'
	


	-- tb_user Table Create SQL
	CREATE TABLE tb_ingredient
	(
	    in_no      VARCHAR2(10)    NOT not null, 
	    in_type    VARCHAR2(20)    not null, 
	    country    VARCHAR2(20)    not null, 
	    CONSTRAINT TB_INGREDIENT_PK PRIMARY KEY (in_no)
	)
	

	COMMENT ON TABLE tb_ingredient IS '재료'
	

	COMMENT ON COLUMN tb_ingredient.in_no IS '코드'
	

	COMMENT ON COLUMN tb_ingredient.in_type IS '재료이름'
	

	COMMENT ON COLUMN tb_ingredient.country IS '원산지'
	


	-- tb_user Table Create SQL
	CREATE TABLE tb_notice
	(
	    no_no       NUMBER          NOT not null, 
	    title       VARCHAR2(20)    not null, 
	    content     VARCHAR2(20)    not null, 
	    writer      VARCHAR2(20)    not null, 
	    reg_date    DATE            DEFAULT sysdate not null, 
	    hits        NUMBER          not null, 
	    CONSTRAINT TB_NOTICE_PK PRIMARY KEY (no_no)
	)
	

	CREATE SEQUENCE tb_notice_SEQ
	START WITH 1
	INCREMENT BY 1;
	

	CREATE OR REPLACE TRIGGER tb_notice_AI_TRG
	BEFORE INSERT ON tb_notice 
	REFERENCING NEW AS NEW FOR EACH ROW 
	BEGIN 
	    SELECT tb_notice_SEQ.NEXTVAL
	    INTO: NEW.no_no
	    FROM DUAL;
	END;
	

	--DROP TRIGGER tb_notice_AI_TRG;
	

	--DROP SEQUENCE tb_notice_SEQ;
	

	CREATE OR REPLACE TRIGGER tb_notice_AI_TRG
	BEFORE INSERT ON tb_notice 
	REFERENCING NEW AS NEW FOR EACH ROW 
	BEGIN 
	    SELECT tb_notice_SEQ.NEXTVAL
	    INTO: NEW.hits
	    FROM DUAL;
	END;
	

	--DROP TRIGGER tb_notice_AI_TRG;
	

	--DROP SEQUENCE tb_notice_SEQ;
	

	COMMENT ON TABLE tb_notice IS '공지사항'
	

	COMMENT ON COLUMN tb_notice.no_no IS '글번호'
	

	COMMENT ON COLUMN tb_notice.title IS '제목'
	

	COMMENT ON COLUMN tb_notice.content IS '내용'
	

	COMMENT ON COLUMN tb_notice.writer IS '작성자'
	

	COMMENT ON COLUMN tb_notice.reg_date IS '작성일자'
	

	COMMENT ON COLUMN tb_notice.hits IS '조회수'
	


	-- tb_user Table Create SQL
	CREATE TABLE tb_shoplook
	(
	    spot_no       VARCHAR2(10)    NOT not null, 
	    spot_name     VARCHAR2(20)    not null, 
	    spot_ad       VARCHAR2(20)    not null, 
	    spot_ph       NUMBER          not null, 
	    spot_recom    NUMBER          not null, 
	    CONSTRAINT TB_SHOPLOOK_PK PRIMARY KEY (spot_no)
	)
	

	CREATE SEQUENCE tb_shoplook_SEQ
	START WITH 1
	INCREMENT BY 1;
	

	CREATE OR REPLACE TRIGGER tb_shoplook_AI_TRG
	BEFORE INSERT ON tb_shoplook 
	REFERENCING NEW AS NEW FOR EACH ROW 
	BEGIN 
	    SELECT tb_shoplook_SEQ.NEXTVAL
	    INTO: NEW.spot_recom
	    FROM DUAL;
	END;
	

	--DROP TRIGGER tb_shoplook_AI_TRG;
	

	--DROP SEQUENCE tb_shoplook_SEQ;
	

	COMMENT ON TABLE tb_shoplook IS '근처 매장찾기'
	

	COMMENT ON COLUMN tb_shoplook.spot_no IS '지점코드'
	

	COMMENT ON COLUMN tb_shoplook.spot_name IS '지점명'
	

	COMMENT ON COLUMN tb_shoplook.spot_ad IS '지점 주소'
	

	COMMENT ON COLUMN tb_shoplook.spot_ph IS '전화번호'
	

	COMMENT ON COLUMN tb_shoplook.spot_recom IS '추천 수'
	


	-- tb_user Table Create SQL
	CREATE TABLE tb_menu
	(
	    menu_code    VARCHAR2(10)    NOT not null, 
	    menu         VARCHAR2(30)    not null, 
	    price        NUMBER          not null, 
	    kcal         NUMBER          not null, 
	    CONSTRAINT TB_MENU_PK PRIMARY KEY (menu_code)
	)
	

	COMMENT ON TABLE tb_menu IS '메뉴'
	

	COMMENT ON COLUMN tb_menu.menu_code IS '메뉴코드'
	

	COMMENT ON COLUMN tb_menu.menu IS '메뉴'
	

	COMMENT ON COLUMN tb_menu.price IS '가격'
	

	COMMENT ON COLUMN tb_menu.kcal IS '칼로리'
	


	-- tb_user Table Create SQL
	CREATE TABLE tb_recom_table_m
	(
	    recom_m_no          NUMBER            NOT not null, 
	    recom_m_content     VARCHAR2(4000)    not null, 
	    recom_m_writer      VARCHAR2(20)      not null, 
	    recom_m_reg_date    DATE              DEFAULT sysdate not null, 
	    recom_m_recom       NUMBER            not null, 
	    CONSTRAINT TB_RECOM_TABLE_M_PK PRIMARY KEY (recom_m_no)
	)
	

	CREATE SEQUENCE tb_recom_table_m_SEQ
	START WITH 1
	INCREMENT BY 1;
	

	CREATE OR REPLACE TRIGGER tb_recom_table_m_AI_TRG
	BEFORE INSERT ON tb_recom_table_m 
	REFERENCING NEW AS NEW FOR EACH ROW 
	BEGIN 
	    SELECT tb_recom_table_m_SEQ.NEXTVAL
	    INTO: NEW.recom_m_no
	    FROM DUAL;
	END;
	

	--DROP TRIGGER tb_recom_table_m_AI_TRG;
	

	--DROP SEQUENCE tb_recom_table_m_SEQ;
	

	CREATE OR REPLACE TRIGGER tb_recom_table_m_AI_TRG
	BEFORE INSERT ON tb_recom_table_m 
	REFERENCING NEW AS NEW FOR EACH ROW 
	BEGIN 
	    SELECT tb_recom_table_m_SEQ.NEXTVAL
	    INTO: NEW.recom_m_recom
	    FROM DUAL;
	END;
	

	--DROP TRIGGER tb_recom_table_m_AI_TRG;
	

	--DROP SEQUENCE tb_recom_table_m_SEQ;
	

	COMMENT ON TABLE tb_recom_table_m IS 'a댓글테이블'
	

	COMMENT ON COLUMN tb_recom_table_m.recom_m_no IS '글번호'
	

	COMMENT ON COLUMN tb_recom_table_m.recom_m_content IS '내용'
	

	COMMENT ON COLUMN tb_recom_table_m.recom_m_writer IS '글쓴이'
	

	COMMENT ON COLUMN tb_recom_table_m.recom_m_reg_date IS '작성일자'
	

	COMMENT ON COLUMN tb_recom_table_m.recom_m_recom IS '추천 수'
	


	-- tb_user Table Create SQL
	CREATE TABLE tb_recom_table_s
	(
	    recom_s_no          NUMBER          NOT not null, 
	    recom_s_content     VARCHAR2(20)    not null, 
	    recom_s_writer      VARCHAR2(20)    not null, 
	    recom_s_reg_date    DATE            DEFAULT sysdate not null, 
	    recom_s_recom       NUMBER          not null, 
	    CONSTRAINT TB_RECOM_TABLE_S_PK PRIMARY KEY (recom_s_no)
	)
	

	CREATE SEQUENCE tb_recom_table_s_SEQ
	START WITH 1
	INCREMENT BY 1;
	

	CREATE OR REPLACE TRIGGER tb_recom_table_s_AI_TRG
	BEFORE INSERT ON tb_recom_table_s 
	REFERENCING NEW AS NEW FOR EACH ROW 
	BEGIN 
	    SELECT tb_recom_table_s_SEQ.NEXTVAL
	    INTO: NEW.recom_s_no
	    FROM DUAL;
	END;
	

	--DROP TRIGGER tb_recom_table_s_AI_TRG;
	

	--DROP SEQUENCE tb_recom_table_s_SEQ;
	

	CREATE OR REPLACE TRIGGER tb_recom_table_s_AI_TRG
	BEFORE INSERT ON tb_recom_table_s 
	REFERENCING NEW AS NEW FOR EACH ROW 
	BEGIN 
	    SELECT tb_recom_table_s_SEQ.NEXTVAL
	    INTO: NEW.recom_s_recom
	    FROM DUAL;
	END;
	

	--DROP TRIGGER tb_recom_table_s_AI_TRG;
	

	--DROP SEQUENCE tb_recom_table_s_SEQ;
	

	COMMENT ON TABLE tb_recom_table_s IS 'c댓글테이블'
	

	COMMENT ON COLUMN tb_recom_table_s.recom_s_no IS '글번호'
	

	COMMENT ON COLUMN tb_recom_table_s.recom_s_content IS '내용'
	

	COMMENT ON COLUMN tb_recom_table_s.recom_s_writer IS '글쓴이'
	

	COMMENT ON COLUMN tb_recom_table_s.recom_s_reg_date IS '작성일자'
	

	COMMENT ON COLUMN tb_recom_table_s.recom_s_recom IS '추천 수'
	


	-- tb_user Table Create SQL
	CREATE TABLE tb_rev_table_m
	(
	    rev_m_code        VARCHAR2(10)    NOT not null, 
	    rev_m_no          NUMBER          not null, 
	    rev_m_reg_date    DATE            DEFAULT sysdate not null, 
	    rev_m_recom       NUMBER          not null, 
	    rev_m_hits        NUMBER          not null, 
	    CONSTRAINT TB_REV_TABLE_M_PK PRIMARY KEY (rev_m_code)
	)
	

	CREATE SEQUENCE tb_rev_table_m_SEQ
	START WITH 1
	INCREMENT BY 1;
	

	CREATE OR REPLACE TRIGGER tb_rev_table_m_AI_TRG
	BEFORE INSERT ON tb_rev_table_m 
	REFERENCING NEW AS NEW FOR EACH ROW 
	BEGIN 
	    SELECT tb_rev_table_m_SEQ.NEXTVAL
	    INTO: NEW.rev_m_no
	    FROM DUAL;
	END;
	

	--DROP TRIGGER tb_rev_table_m_AI_TRG;
	

	--DROP SEQUENCE tb_rev_table_m_SEQ;
	

	CREATE OR REPLACE TRIGGER tb_rev_table_m_AI_TRG
	BEFORE INSERT ON tb_rev_table_m 
	REFERENCING NEW AS NEW FOR EACH ROW 
	BEGIN 
	    SELECT tb_rev_table_m_SEQ.NEXTVAL
	    INTO: NEW.rev_m_recom
	    FROM DUAL;
	END;
	

	--DROP TRIGGER tb_rev_table_m_AI_TRG;
	

	--DROP SEQUENCE tb_rev_table_m_SEQ;
	

	CREATE OR REPLACE TRIGGER tb_rev_table_m_AI_TRG
	BEFORE INSERT ON tb_rev_table_m 
	REFERENCING NEW AS NEW FOR EACH ROW 
	BEGIN 
	    SELECT tb_rev_table_m_SEQ.NEXTVAL
	    INTO: NEW.rev_m_hits
	    FROM DUAL;
	END;
	

	--DROP TRIGGER tb_rev_table_m_AI_TRG;
	

	--DROP SEQUENCE tb_rev_table_m_SEQ;
	

	COMMENT ON TABLE tb_rev_table_m IS 'a 리뷰테이블'
	

	COMMENT ON COLUMN tb_rev_table_m.rev_m_code IS '메뉴코드'
	

	COMMENT ON COLUMN tb_rev_table_m.rev_m_no IS '글번호'
	

	COMMENT ON COLUMN tb_rev_table_m.rev_m_reg_date IS '작성일자'
	

	COMMENT ON COLUMN tb_rev_table_m.rev_m_recom IS '추천 수'
	

	COMMENT ON COLUMN tb_rev_table_m.rev_m_hits IS '조회 수'
	


	-- tb_user Table Create SQL
	CREATE TABLE tb_rev_table_s
	(
	    rev_s_code        VARCHAR2(10)    NOT not null, 
	    rev_s_no          NUMBER          not null, 
	    rev_s_reg_date    VARCHAR2(20)    not null, 
	    rev_s_recom       NUMBER          not null, 
	    rev_s_hits        NUMBER          not null, 
	    CONSTRAINT TB_REV_TABLE_S_PK PRIMARY KEY (rev_s_code)
	)
	

	CREATE SEQUENCE tb_rev_table_s_SEQ
	START WITH 1
	INCREMENT BY 1;
	

	CREATE OR REPLACE TRIGGER tb_rev_table_s_AI_TRG
	BEFORE INSERT ON tb_rev_table_s 
	REFERENCING NEW AS NEW FOR EACH ROW 
	BEGIN 
	    SELECT tb_rev_table_s_SEQ.NEXTVAL
	    INTO: NEW.rev_s_no
	    FROM DUAL;
	END;
	

	--DROP TRIGGER tb_rev_table_s_AI_TRG;
	

	--DROP SEQUENCE tb_rev_table_s_SEQ;
	

	CREATE OR REPLACE TRIGGER tb_rev_table_s_AI_TRG
	BEFORE INSERT ON tb_rev_table_s 
	REFERENCING NEW AS NEW FOR EACH ROW 
	BEGIN 
	    SELECT tb_rev_table_s_SEQ.NEXTVAL
	    INTO: NEW.rev_s_recom
	    FROM DUAL;
	END;
	

	--DROP TRIGGER tb_rev_table_s_AI_TRG;
	

	--DROP SEQUENCE tb_rev_table_s_SEQ;
	

	CREATE OR REPLACE TRIGGER tb_rev_table_s_AI_TRG
	BEFORE INSERT ON tb_rev_table_s 
	REFERENCING NEW AS NEW FOR EACH ROW 
	BEGIN 
	    SELECT tb_rev_table_s_SEQ.NEXTVAL
	    INTO: NEW.rev_s_hits
	    FROM DUAL;
	END;
	

	--DROP TRIGGER tb_rev_table_s_AI_TRG;
	

	--DROP SEQUENCE tb_rev_table_s_SEQ;
	

	COMMENT ON TABLE tb_rev_table_s IS 'c 리뷰테이블'
	

	COMMENT ON COLUMN tb_rev_table_s.rev_s_code IS '메뉴코드'
	

	COMMENT ON COLUMN tb_rev_table_s.rev_s_no IS '글번호'
	

	COMMENT ON COLUMN tb_rev_table_s.rev_s_reg_date IS '작성일자'
	

	COMMENT ON COLUMN tb_rev_table_s.rev_s_recom IS '추천 수'
	

	COMMENT ON COLUMN tb_rev_table_s.rev_s_hits IS '조회 수'
	
