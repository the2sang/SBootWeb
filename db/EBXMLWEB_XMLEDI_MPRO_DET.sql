create table XMLEDI_MPRO_DET
(
    EBELN        VARCHAR2(10) not null,
    LIFNR        VARCHAR2(10) not null,
    LIFNR_GR     VARCHAR2(10) not null,
    EBELP        VARCHAR2(5)  not null,
    MATSN        VARCHAR2(16) not null,
    PRDFT        VARCHAR2(10),
    PRDSN        VARCHAR2(20),
    PRDDT        VARCHAR2(8),
    PRNAM        VARCHAR2(20),
    EBELN_PO        VARCHAR2(10),  -- 0419 추가 인도지시번호
    EBELP_PO        VARCHAR2(5),  -- 0419 추가 인도지시품목번호
    -- WERKS        VARCHAR2(4),  -- 0419 제거
    -- EINDT        VARCHAR2(8),  -- 0419 제거
    ATWRT_001_01 VARCHAR2(30),
    ATWRT_001_02 VARCHAR2(30),
    ATWRT_001_03 VARCHAR2(30),
    ATWRT_001_04 VARCHAR2(30),
    ATWRT_001_05 VARCHAR2(30),
    ATWRT_001_06 VARCHAR2(30),
    ATWRT_001_07 VARCHAR2(30),
    ATWRT_001_08 VARCHAR2(30),
    ATWRT_001_09    VARCHAR2(1),    -- 0419 변압기 절연지 종류
    ATWRT_002_01 VARCHAR2(30),
    ATWRT_002_02 VARCHAR2(30),
    ATWRT_002_03 VARCHAR2(30),
    ATWRT_002_04 VARCHAR2(30),
    ATWRT_002_05 VARCHAR2(30),
    ATWRT_002_06 VARCHAR2(30),
    ATWRT_002_07 VARCHAR2(30),
    ATWRT_002_08 VARCHAR2(30),
    ATWRT_002_09 VARCHAR2(30),
    RECVST       VARCHAR2(1),
    RECVMG       VARCHAR2(250),
    constraint XMLEDI_MPRO_DET_PK
        primary key (EBELN, LIFNR, LIFNR_GR, EBELP, MATSN)
)
/

comment on column XMLEDI_MPRO_DET.EBELN is '주문번호 (ERP 자동기록)'
/

comment on column XMLEDI_MPRO_DET.LIFNR is '계약업체 (ERP 자동기록)'
/

comment on column XMLEDI_MPRO_DET.LIFNR_GR is '납품업체 (ERP 자동기록)'
/

comment on column XMLEDI_MPRO_DET.EBELP is '품목번호 (ERP 자동기록)'
/

comment on column XMLEDI_MPRO_DET.MATSN is '고유인식번호 (ERP 자동기록)'
/

comment on column XMLEDI_MPRO_DET.PRDFT is '생산공장 (사업자번호) (업체 필수입력)'
/

comment on column XMLEDI_MPRO_DET.PRDSN is '제작번호 (업체 필수입력)'
/

comment on column XMLEDI_MPRO_DET.PRDDT is '제작일자 (업체 필수입력)'
/

comment on column XMLEDI_MPRO_DET.PRNAM is '제작담당자 이름 (업체 필수입력)'
/

comment on column XMLEDI_MPRO_DET.EBELN_PO is '인도지시번호 (업체 필수입력)'
/

comment on column XMLEDI_MPRO_DET.EBELN_PO is '인도지시품목번호 (업체 필수입력)'
/

comment on column XMLEDI_MPRO_DET.ATWRT_001_01 is '변압기 1차 부싱타입 (변압기이면 필수 입력) 1-자기제, 2-폴리머, 3-에폭시'
/

comment on column XMLEDI_MPRO_DET.ATWRT_001_02 is '변압기 2차 부싱타입 (변압기이면 필수 입력) 1-자기제, 2-폴리머, 3-에폭시'
/

comment on column XMLEDI_MPRO_DET.ATWRT_001_03 is '변압기 권선종류 (변압기이면 필수 입력) 1-Cu 2-AL'
/

comment on column XMLEDI_MPRO_DET.ATWRT_001_04 is '변압기 절연유타입 (변압기이면 필수 입력) 1-광유 2-실리콘유  3-식물유 4-난연유'
/

comment on column XMLEDI_MPRO_DET.ATWRT_001_05 is '변압기 절연지 내열온도(C) (변압기이면 필수 입력 1-90 2-105 3-120 4-130 5-155 6-180 7-180 이상)'
/

comment on column XMLEDI_MPRO_DET.ATWRT_001_06 is '변압기 유량(L) (변압기이면 필수 입력  ) 1-정수 2~4자리(10~9999)'
/

comment on column XMLEDI_MPRO_DET.ATWRT_001_07 is '변압기 무부하손(W) (변압기이면 필수 입력 ) 1-정수 2~4자리(10~9999)'
/

comment on column XMLEDI_MPRO_DET.ATWRT_001_08 is '변압기 부하손(W) (변압기이면 필수 입력 ) 1-정수 2~4자리(10~9999)'
/

comment on column XMLEDI_MPRO_DET.ATWRT_002_01 is '개폐기 정격전류(A) (개폐기이면 필수 입력) 1-Kraft 2-Diamond Kraft 3-Diamond Kraft 4 H종 노맥스지 5-기타'
/

comment on column XMLEDI_MPRO_DET.ATWRT_002_02 is '개폐기 스위칭매체 (개폐기이면 필수 입력) 1-400 2-600 3-630'
/

comment on column XMLEDI_MPRO_DET.ATWRT_002_03 is '개폐기 절연매체 (개폐기이면 필수 입력) 1-SF6 2-Vacuum 3-Oil 4-기타'
/

comment on column XMLEDI_MPRO_DET.ATWRT_002_04 is '개폐기 매커니즘 조작방식 (개폐기이면 필수 입력) 1-Spring 2-Magnetic 3-기타'
/

comment on column XMLEDI_MPRO_DET.ATWRT_002_05 is '개폐기 1차 부싱타입 (개폐기이면 필수 입력) 1-자기제 2-폴리머 3-에폭시'
/

comment on column XMLEDI_MPRO_DET.ATWRT_002_06 is '개폐기 2차 부싱타입 (개폐기이면 필수 입력) 1-자기제 2-폴리머 3-에폭시'
/

comment on column XMLEDI_MPRO_DET.ATWRT_002_07 is '개폐기 정격가스압력(Mpa) (개폐기이면 필수 입력) 소숫점 2자리까지'
/

comment on column XMLEDI_MPRO_DET.ATWRT_002_08 is '개폐기 최저보증가스압력(Mpa) (개폐기이면 필수 입력) 소숫점 2자리까지'
/

comment on column XMLEDI_MPRO_DET.ATWRT_002_09 is '개폐기 가스량(Kg) (개폐기이면 필수 입력) 소숫점 2자리까지'
/

comment on column XMLEDI_MPRO_DET.RECVST is '개별자재 생산내역서 내용 점검 결과(S : 성공, E : 실패) (ERP 자동기록)※ ERP 스마트 물류관리 시스템이 수신 시  내용 Check 후 행별로 결과 기록
'
/

comment on column XMLEDI_MPRO_DET.RECVMG is '개별자재 생산내역서 내용 점검 결과(ERP 자동기록)※ ERP 스마트 물류관리 시스템이 수신 시 내용 Check 후 오류 시 메세지 기록
'
/