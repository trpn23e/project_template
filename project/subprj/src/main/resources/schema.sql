/*
  -- 테스트 페이지 호출을 위한 DB 스크립트 (데이터에 아무 의미없음..)
   resources 디렉토리에 schema.sql, data.sql을 넣어두면 default이름으로 database가 h2로 설정되있을때
   자동으로 스크립트를 읽어들인다.
*/

DROP TABLE IF EXISTS DEMO_TBL;


CREATE TABLE IF NOT EXISTS DEMO_TBL (
	CTR_SEQ IDENTITY PRIMARY KEY,
	CTR_NO varchar(100) NULL,
	CTR_ADR varchar(100) NULL,
	TX_ID varchar(100) NULL,
	CTR_STAT char(2) NULL,
	TRN_STAT char(1) NULL,
	OWN_ADR varchar(100) NULL,
	SND_ADR varchar(100) NULL,
	RCV_ADR varchar(100) NULL,
	BRK_SND_ADR varchar(100) NULL,
	BRK_RCV_ADR varchar(100) NULL,
	OWN_NM varchar(200) NULL,
	SND_NM varchar(200) NULL,
	RCV_NM varchar(200) NULL,
	BRK_SND_NM varchar(200) NULL,
	BRK_RCV_NM varchar(200) NULL,
	CTR_FILE_NM varchar(2000) NULL,
	CTR_FILE_HASH varchar(1000) NULL,
	CTR_FILE_LINK varchar(2000) NULL,
	CTR_FIN_FILE_HASH varchar(1000) NULL,
	CTR_FIN_FILE_LINK varchar(2000) NULL,
	ETC_FILE_GRP_ID varchar(100) NULL,
	META_ID varchar(100) NULL,
	CDATE datetime NULL,
	UDATE datetime NULL,
	SDATE datetime NULL,
	RDATE datetime NULL,
	CUSR_ID varchar(200) NULL,
	UUSR_ID varchar(200) NULL
);
