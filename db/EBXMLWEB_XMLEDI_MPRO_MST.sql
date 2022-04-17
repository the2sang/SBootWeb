create table XMLEDI_MPRO_MST
(
    EBELN     VARCHAR2(10) not null,
    LIFNR     VARCHAR2(10) not null,
    LIFNR_GR  VARCHAR2(10) not null,
    EBELP     VARCHAR2(5)  not null,
    MATNR     VARCHAR2(16),
    TXZ01     VARCHAR2(40),
    MENGE     VARCHAR2(18),
    NETPR     VARCHAR2(18),
    NETWR     VARCHAR2(18),
    ZBPMNG    VARCHAR2(18),
    MEINS     VARCHAR2(3),
    WAERS     VARCHAR2(5),
    MATSN_FR  VARCHAR2(16),
    MATSN_TO  VARCHAR2(16),
    MATSN_CNT NUMBER(8),
    ATWRT_TP  VARCHAR2(3),
    SENDDT    VARCHAR2(8),
    SENDTM    VARCHAR2(6),
    RECVDT    VARCHAR2(8),
    RECVTM    VARCHAR2(6),
    RECVST    VARCHAR2(1),
    RECVMG    VARCHAR2(250),
    INPUT_ST  VARCHAR2(1),
    constraint XMLEDI_MPRO_MST_PK
        primary key (EBELN, LIFNR, LIFNR_GR, EBELP)
)
/

comment on column XMLEDI_MPRO_MST.EBELN is '주문번호 (ERP 자동기록)
'
/

comment on column XMLEDI_MPRO_MST.LIFNR is '계약업체 (ERP 자동기록)
'
/

comment on column XMLEDI_MPRO_MST.LIFNR_GR is '납품업체 (ERP 자동기록)
'
/

comment on column XMLEDI_MPRO_MST.EBELP is '품목번호 (ERP 자동기록)
'
/

comment on column XMLEDI_MPRO_MST.MATNR is '자재번호 (ERP 자동기록)'
/

comment on column XMLEDI_MPRO_MST.TXZ01 is '자재명 (ERP 자동기록)'
/

comment on column XMLEDI_MPRO_MST.MENGE is '주문수량 (ERP 자동기록)'
/

comment on column XMLEDI_MPRO_MST.NETPR is '단가 (ERP 자동기록)'
/

comment on column XMLEDI_MPRO_MST.NETWR is '금액 (ERP 자동기록)'
/

comment on column XMLEDI_MPRO_MST.ZBPMNG is '납품수량 (ERP 자동기록)'
/

comment on column XMLEDI_MPRO_MST.MEINS is '단위 (ERP 자동기록)'
/

comment on column XMLEDI_MPRO_MST.WAERS is '통화 (ERP 자동기록)'
/

comment on column XMLEDI_MPRO_MST.MATSN_FR is '고유인식번호 시작 (ERP 자동기록)
'
/

comment on column XMLEDI_MPRO_MST.MATSN_TO is '고유인식번호 종료 (ERP 자동기록)
'
/

comment on column XMLEDI_MPRO_MST.MATSN_CNT is '고유인식번호 발급 개수 (ERP 자동기록)
'
/

comment on column XMLEDI_MPRO_MST.ATWRT_TP is '자재 특성유형 (ERP 자동기록)(001 : 변압기, 002 : 개폐기)
'
/

comment on column XMLEDI_MPRO_MST.SENDDT is '개별자재 생산내역서 송신일자(ERP to EDI)(ERP 자동기록)
'
/

comment on column XMLEDI_MPRO_MST.SENDTM is '개별자재 생산내역서 송신시간(ERP to EDI)(ERP 자동기록)
'
/

comment on column XMLEDI_MPRO_MST.RECVDT is '개별자재 생산내역서 수신일자(EDI to ERP)(ERP 자동기록)
'
/

comment on column XMLEDI_MPRO_MST.RECVTM is '개별자재 생산내역서 수신시간(EDI to ERP)(ERP 자동기록)
'
/

comment on column XMLEDI_MPRO_MST.RECVST is '개별자재 생산내역서 수신결과(S : 성공, E : 실패) (ERP 자동기록)※ ERP 스마트 물류관리 시스템이 수신 시  내용 Check 후 결과 기록
'
/

comment on column XMLEDI_MPRO_MST.RECVMG is '개별자재 생산내역서 수신오류 메세지(ERP 자동기록)※ ERP 스마트 물류관리 시스템이 수신 시 오류 메세지 기록
'
/

comment on column XMLEDI_MPRO_MST.INPUT_ST is 'EDI 입력 상태정보(I-초기Default(ERP 기록), S-Save 저장, C-확정)
'
/

INSERT INTO EBXMLWEB.XMLEDI_MPRO_MST (EBELN, LIFNR, LIFNR_GR, EBELP, MATNR, TXZ01, MENGE, NETPR, NETWR, ZBPMNG, MEINS, WAERS, MATSN_FR, MATSN_TO, MATSN_CNT, ATWRT_TP, SENDDT, SENDTM, RECVDT, RECVTM, RECVST, RECVMG, INPUT_ST) VALUES ('4100100208', '1188200345', '1188200345', '12345', '126474', '고효율주상변압기,100KVA', '10', '1931510', '7726080', '10', '111', '55555', '2021020100000001', '2021020100000010', 10, '001', '20220416', '101010', '20220416', '151515', 'S', '메세지', 'S');
