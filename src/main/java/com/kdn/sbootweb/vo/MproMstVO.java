package com.kdn.sbootweb.vo;

public class MproMstVO {

    private String ebeln;       //1주문번호
    private String lifnr;       //2계약업체 사업자번호
    private String lifnrGr;     //3납품업체 사업자번호
    private String ebelp;       //4품목번호
    private String bedat;       //5 주문일자 - 추가
    private String eindt;       //6 납기일자 - 추가
    private String lifnrNm;    //7 계약업체명 -- 추가
    private String lifnrGrnm;  //8 납품업체명  -- 추가
    private String werks;       //9 입고사업소(4)  -- 추가
    private String name1;       //10 입고사업소명 --추가
    private String matnr;       //11자재번호
    private String txz01;       //12자재명
    private String menge;       //13주문수량
    private String netpr;       //14단가
    private String netwr;       //15금액
    private String zbpmng;      //16납품수량
    private String meins;       //17단위
    private String waers;       //18통화
    private String prueflog;    //19
    private String matsnFr;     //20고유인식번호 시작
    private String matsnTo;     //21고유인식번호 종료
    private long matsnCnt;    //22고유인식번호 발급 개수
    private String atwrtTp;     //23자재 특성유형 (001:변압기, 002: 개폐기)
    private String senddt;      //24개별자재 생산내역서 송신일자
    private String sendtm;      //25개별자재 생산내역서 송신시간
    private String recvdt;      //26개별자재 생산내역서 수신일자
    private String recvtm;      //27개별자재 생산내역서 수신시간
    private String recvst;      //28개별자재 생산내역서 수신결과
    private String recvmg;      //29개별자재 생산내역서 수신오류 메세지
    private String inputSt;     //30EDI 입력 상태정보

    public MproMstVO() {
    }

    public String getEbeln() {
        return ebeln;
    }

    public void setEbeln(String ebeln) {
        this.ebeln = ebeln;
    }

    public String getLifnr() {
        return lifnr;
    }

    public void setLifnr(String lifnr) {
        this.lifnr = lifnr;
    }

    public String getLifnrGr() {
        return lifnrGr;
    }

    public void setLifnrGr(String lifnrGr) {
        this.lifnrGr = lifnrGr;
    }

    public String getEbelp() {
        return ebelp;
    }

    public void setEbelp(String ebelp) {
        this.ebelp = ebelp;
    }

    public String getBedat() {
        return bedat;
    }

    public void setBedat(String bedat) {
        this.bedat = bedat;
    }

    public String getEindt() {
        return eindt;
    }

    public void setEindt(String eindt) {
        this.eindt = eindt;
    }

    public String getLifnrNm() {
        return lifnrNm;
    }

    public void setLifnrNm(String lifnrNm) {
        this.lifnrNm = lifnrNm;
    }

    public String getLifnrGrnm() {
        return lifnrGrnm;
    }

    public void setLifnrGrnm(String lifnrGrnm) {
        this.lifnrGrnm = lifnrGrnm;
    }

    public String getWerks() {
        return werks;
    }

    public void setWerks(String werks) {
        this.werks = werks;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getMatnr() {
        return matnr;
    }

    public void setMatnr(String matnr) {
        this.matnr = matnr;
    }

    public String getTxz01() {
        return txz01;
    }

    public void setTxz01(String txz01) {
        this.txz01 = txz01;
    }

    public String getMenge() {
        return menge;
    }

    public void setMenge(String menge) {
        this.menge = menge;
    }

    public String getNetpr() {
        return netpr;
    }

    public void setNetpr(String netpr) {
        this.netpr = netpr;
    }

    public String getNetwr() {
        return netwr;
    }

    public void setNetwr(String netwr) {
        this.netwr = netwr;
    }

    public String getZbpmng() {
        return zbpmng;
    }

    public void setZbpmng(String zbpmng) {
        this.zbpmng = zbpmng;
    }

    public String getMeins() {
        return meins;
    }

    public void setMeins(String meins) {
        this.meins = meins;
    }

    public String getWaers() {
        return waers;
    }

    public void setWaers(String waers) {
        this.waers = waers;
    }

    public String getPrueflog() {
        return prueflog;
    }

    public void setPrueflog(String prueflog) {
        this.prueflog = prueflog;
    }

    public String getMatsnFr() {
        return matsnFr;
    }

    public void setMatsnFr(String matsnFr) {
        this.matsnFr = matsnFr;
    }

    public String getMatsnTo() {
        return matsnTo;
    }

    public void setMatsnTo(String matsnTo) {
        this.matsnTo = matsnTo;
    }

    public long getMatsnCnt() {
        return matsnCnt;
    }

    public void setMatsnCnt(long matsnCnt) {
        this.matsnCnt = matsnCnt;
    }

    public String getAtwrtTp() {
        return atwrtTp;
    }

    public void setAtwrtTp(String atwrtTp) {
        this.atwrtTp = atwrtTp;
    }

    public String getSenddt() {
        return senddt;
    }

    public void setSenddt(String senddt) {
        this.senddt = senddt;
    }

    public String getSendtm() {
        return sendtm;
    }

    public void setSendtm(String sendtm) {
        this.sendtm = sendtm;
    }

    public String getRecvdt() {
        return recvdt;
    }

    public void setRecvdt(String recvdt) {
        this.recvdt = recvdt;
    }

    public String getRecvtm() {
        return recvtm;
    }

    public void setRecvtm(String recvtm) {
        this.recvtm = recvtm;
    }

    public String getRecvst() {
        return recvst;
    }

    public void setRecvst(String recvst) {
        this.recvst = recvst;
    }

    public String getRecvmg() {
        return recvmg;
    }

    public void setRecvmg(String recvmg) {
        this.recvmg = recvmg;
    }

    public String getInputSt() {
        return inputSt;
    }

    public void setInputSt(String inputSt) {
        this.inputSt = inputSt;
    }

    @Override
    public String toString() {
        return "MproMstVO{" +
                "ebeln='" + ebeln + '\'' +
                ", lifnr='" + lifnr + '\'' +
                ", lifnrGr='" + lifnrGr + '\'' +
                ", ebelp='" + ebelp + '\'' +
                ", bedat='" + bedat + '\'' +
                ", eindt='" + eindt + '\'' +
                ", lifnrNm='" + lifnrNm + '\'' +
                ", lifnrGrnm='" + lifnrGrnm + '\'' +
                ", werks='" + werks + '\'' +
                ", name1='" + name1 + '\'' +
                ", matnr='" + matnr + '\'' +
                ", txz01='" + txz01 + '\'' +
                ", menge='" + menge + '\'' +
                ", netpr='" + netpr + '\'' +
                ", netwr='" + netwr + '\'' +
                ", zbpmng='" + zbpmng + '\'' +
                ", meins='" + meins + '\'' +
                ", waers='" + waers + '\'' +
                ", prueflog='" + prueflog + '\'' +
                ", matsnFr='" + matsnFr + '\'' +
                ", matsnTo='" + matsnTo + '\'' +
                ", matsnCnt=" + matsnCnt +
                ", atwrtTp='" + atwrtTp + '\'' +
                ", senddt='" + senddt + '\'' +
                ", sendtm='" + sendtm + '\'' +
                ", recvdt='" + recvdt + '\'' +
                ", recvtm='" + recvtm + '\'' +
                ", recvst='" + recvst + '\'' +
                ", recvmg='" + recvmg + '\'' +
                ", inputSt='" + inputSt + '\'' +
                '}';
    }
}
