package com.kdn.sbootweb.vo;

public class MproMstVO {

    private String ebeln;       //1주문번호
    private String lifnr;       //2계약업체 사업자번호
    private String lifnrGr;     //3납품업체 사업자번호
    private String ebelp;       //4품목번호
    private String matnr;       //5자재번호
    private String txz01;       //6자재명
    private String menge;       //7주문수량
    private String netpr;       //8단가
    private String netwr;       //9금액
    private String zbpmng;      //10납품수량
    private String meins;       //11단위
    private String waers;       //12통화
    private String matsnFr;     //13고유인식번호 시작
    private String matsnTo;     //14고유인식번호 종료
    private long matsnCnt;    //15고유인식번호 발급 개수
    private String atwrtTp;     //16자재 특성유형 (001:변압기, 002: 개폐기)
    private String senddt;      //17개별자재 생산내역서 송신일자
    private String sendtm;      //18개별자재 생산내역서 송신시간
    private String recvdt;      //19개별자재 생산내역서 수신일자
    private String recvtm;      //20개별자재 생산내역서 수신시간
    private String recvst;      //21개별자재 생산내역서 수신결과
    private String recvmg;      //22개별자재 생산내역서 수신오류 메세지
    private String inputSt;     //23EDI 입력 상태정보

    public MproMstVO() {
    }

    public MproMstVO(String ebeln, String lifnr, String lifnrGr, String ebelp, String matnr, String txz01,
                     String menge, String netpr, String netwr, String zbpmng, String meins, String waers,
                     String matsnFr, String matsnTo, long matsnCnt, String atwrtTp, String senddt, String sendtm,
                     String recvdt, String recvtm, String recvst, String recvmg, String inputSt) {
        this.ebeln = ebeln;
        this.lifnr = lifnr;
        this.lifnrGr = lifnrGr;
        this.ebelp = ebelp;
        this.matnr = matnr;
        this.txz01 = txz01;
        this.menge = menge;
        this.netpr = netpr;
        this.netwr = netwr;
        this.zbpmng = zbpmng;
        this.meins = meins;
        this.waers = waers;
        this.matsnFr = matsnFr;
        this.matsnTo = matsnTo;
        this.matsnCnt = matsnCnt;
        this.atwrtTp = atwrtTp;
        this.senddt = senddt;
        this.sendtm = sendtm;
        this.recvdt = recvdt;
        this.recvtm = recvtm;
        this.recvst = recvst;
        this.recvmg = recvmg;
        this.inputSt = inputSt;
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
                ", matnr='" + matnr + '\'' +
                ", txz01='" + txz01 + '\'' +
                ", menge='" + menge + '\'' +
                ", netpr='" + netpr + '\'' +
                ", netwr='" + netwr + '\'' +
                ", zbpmng='" + zbpmng + '\'' +
                ", meins='" + meins + '\'' +
                ", waers='" + waers + '\'' +
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
