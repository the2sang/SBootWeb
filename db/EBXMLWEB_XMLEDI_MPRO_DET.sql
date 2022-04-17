create table XMLEDI_MPRO_DET
(
    EBELN        VARCHAR2(10) not null,
    LIFNR        VARCHAR2(10) not null,
    LIFNR_GR     VARCHAR2(10) not null,
    EBELP        VARCHAR2(5)  not null,
    MATSN        VARCHAR2(16) not null,
    WERKS        VARCHAR2(4),
    EINDT        VARCHAR2(8),
    PRDFT        VARCHAR2(10),
    PRDSN        VARCHAR2(20),
    PRDDT        VARCHAR2(8),
    PRNAM        VARCHAR2(20),
    ATWRT_001_01 VARCHAR2(30),
    ATWRT_001_02 VARCHAR2(30),
    ATWRT_001_03 VARCHAR2(30),
    ATWRT_001_04 VARCHAR2(30),
    ATWRT_001_05 VARCHAR2(30),
    ATWRT_001_06 VARCHAR2(30),
    ATWRT_001_07 VARCHAR2(30),
    ATWRT_001_08 VARCHAR2(30),
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

comment on column XMLEDI_MPRO_DET.WERKS is '플랜트(본부) (ERP 자동기록)'
/

comment on column XMLEDI_MPRO_DET.EINDT is '납기일자 (ERP 자동기록)'
/

comment on column XMLEDI_MPRO_DET.PRDFT is '생산공장 (사업자번호) (업체 필수입력)'
/

comment on column XMLEDI_MPRO_DET.PRDSN is '제작번호 (업체 필수입력)'
/

comment on column XMLEDI_MPRO_DET.PRDDT is '제작일자 (업체 필수입력)'
/

comment on column XMLEDI_MPRO_DET.PRNAM is '제작담당자 이름 (업체 필수입력)'
/

comment on column XMLEDI_MPRO_DET.ATWRT_001_01 is '변압기 1차 부싱타입 (변압기이면 필수 입력)'
/

comment on column XMLEDI_MPRO_DET.ATWRT_001_02 is '변압기 2차 부싱타입 (변압기이면 필수 입력)'
/

comment on column XMLEDI_MPRO_DET.ATWRT_001_03 is '변압기 권선종류 (변압기이면 필수 입력)'
/

comment on column XMLEDI_MPRO_DET.ATWRT_001_04 is '변압기 절연유타입 (변압기이면 필수 입력)'
/

comment on column XMLEDI_MPRO_DET.ATWRT_001_05 is '변압기 절연지 내열온도(C) (변압기이면 필수 입력)'
/

comment on column XMLEDI_MPRO_DET.ATWRT_001_06 is '변압기 유량(L) (변압기이면 필수 입력)'
/

comment on column XMLEDI_MPRO_DET.ATWRT_001_07 is '변압기 무부하손(W) (변압기이면 필수 입력)'
/

comment on column XMLEDI_MPRO_DET.ATWRT_001_08 is '변압기 부하손(W) (변압기이면 필수 입력)'
/

comment on column XMLEDI_MPRO_DET.ATWRT_002_01 is '개폐기 정격전류(A) (개폐기이면 필수 입력)'
/

comment on column XMLEDI_MPRO_DET.ATWRT_002_02 is '개폐기 스위칭매체 (개폐기이면 필수 입력)'
/

comment on column XMLEDI_MPRO_DET.ATWRT_002_03 is '개폐기 절연매체 (개폐기이면 필수 입력)'
/

comment on column XMLEDI_MPRO_DET.ATWRT_002_04 is '개폐기 매커니즘 조작방식 (개폐기이면 필수 입력)'
/

comment on column XMLEDI_MPRO_DET.ATWRT_002_05 is '개폐기 1차 부싱타입 (개폐기이면 필수 입력)'
/

comment on column XMLEDI_MPRO_DET.ATWRT_002_06 is '개폐기 2차 부싱타입 (개폐기이면 필수 입력)'
/

comment on column XMLEDI_MPRO_DET.ATWRT_002_07 is '개폐기 정격가스압력(Mpa) (개폐기이면 필수 입력)'
/

comment on column XMLEDI_MPRO_DET.ATWRT_002_08 is '개폐기 최저보증가스압력(Mpa) (개폐기이면 필수 입력)'
/

comment on column XMLEDI_MPRO_DET.ATWRT_002_09 is '개폐기 가스량(Kg) (개폐기이면 필수 입력)'
/

comment on column XMLEDI_MPRO_DET.RECVST is '개별자재 생산내역서 내용 점검 결과(S : 성공, E : 실패) (ERP 자동기록)※ ERP 스마트 물류관리 시스템이 수신 시  내용 Check 후 행별로 결과 기록
'
/

comment on column XMLEDI_MPRO_DET.RECVMG is '개별자재 생산내역서 내용 점검 결과(ERP 자동기록)※ ERP 스마트 물류관리 시스템이 수신 시 내용 Check 후 오류 시 메세지 기록
'
/

INSERT INTO EBXMLWEB.XMLEDI_MPRO_DET (EBELN, LIFNR, LIFNR_GR, EBELP, MATSN, WERKS, EINDT, PRDFT, PRDSN, PRDDT, PRNAM, ATWRT_001_01, ATWRT_001_02, ATWRT_001_03, ATWRT_001_04, ATWRT_001_05, ATWRT_001_06, ATWRT_001_07, ATWRT_001_08, ATWRT_002_01, ATWRT_002_02, ATWRT_002_03, ATWRT_002_04, ATWRT_002_05, ATWRT_002_06, ATWRT_002_07, ATWRT_002_08, ATWRT_002_09, RECVST, RECVMG) VALUES ('4100100208', '1188200345', '1188200345', '12345', '2021020100000001', '1111', '20220425', '1112255555', '202008220023', '20220101', '홍길동', '자기제', '자기제', 'Cu', '광유', 'Kraft', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO EBXMLWEB.XMLEDI_MPRO_DET (EBELN, LIFNR, LIFNR_GR, EBELP, MATSN, WERKS, EINDT, PRDFT, PRDSN, PRDDT, PRNAM, ATWRT_001_01, ATWRT_001_02, ATWRT_001_03, ATWRT_001_04, ATWRT_001_05, ATWRT_001_06, ATWRT_001_07, ATWRT_001_08, ATWRT_002_01, ATWRT_002_02, ATWRT_002_03, ATWRT_002_04, ATWRT_002_05, ATWRT_002_06, ATWRT_002_07, ATWRT_002_08, ATWRT_002_09, RECVST, RECVMG) VALUES ('4100100208', '1188200345', '1188200345', '12345', '2021020100000002', 'null', 'null', 'null', '666', '777', 'null', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO EBXMLWEB.XMLEDI_MPRO_DET (EBELN, LIFNR, LIFNR_GR, EBELP, MATSN, WERKS, EINDT, PRDFT, PRDSN, PRDDT, PRNAM, ATWRT_001_01, ATWRT_001_02, ATWRT_001_03, ATWRT_001_04, ATWRT_001_05, ATWRT_001_06, ATWRT_001_07, ATWRT_001_08, ATWRT_002_01, ATWRT_002_02, ATWRT_002_03, ATWRT_002_04, ATWRT_002_05, ATWRT_002_06, ATWRT_002_07, ATWRT_002_08, ATWRT_002_09, RECVST, RECVMG) VALUES ('4100100208', '1188200345', '1188200345', '12345', '2021020100000003', 'null', 'null', 'null', '888', '999', 'null', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
