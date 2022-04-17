package com.kdn.sbootweb.vo;

public class MproDetVO {

    private String ebeln;       //1.주문번호
    private String lifnr;       //2.계약업체
    private String lifnrGr;     //3.납품업체
    private String ebelp;       //4.품목번호
    private String matsn;       //5.고유인식번호
    private String werks;       //6.플랜트(본부)
    private String eindt;       //7.납기일자
    private String prdft;       //8.생산공장
    private String prdsn;       //9.제작번호
    private String prddt;       //10.제작일자
    private String prnam;       //11.제작담당자 이름
    private String atwrt00101;  //12.변압기 1차 부싱타입
    private String atwrt00102;  //13.변압기 2차 부싱타입
    private String atwrt00103;  //14.변압기 권선종류
    private String atwrt00104;  //15.변압기 절연유타입
    private String atwrt00105;  //16.변압기 절연지 내열온도
    private String atwrt00106;  //17.변압기 유량
    private String atwrt00107;  //18.변압기 무부하손
    private String atwrt00108;  //19.변압기 부하손
    private String atwrt00201;  //20.개폐기 정격전류
    private String atwrt00202;  //21.개폐기 스위칭매체
    private String atwrt00203;  //22. 개폐기 절연매체
    private String atwrt00204;  //23.개폐기 매커니즘 조작방식
    private String atwrt00205;  //24.개폐기 1차 부싱타입
    private String atwrt00206;  //25.개폐기 2차 부싱타입
    private String atwrt00207;  //26.개폐기 정격가스압력
    private String atwrt00208;  //27.개폐기 최저보증가시압력
    private String atwrt00209;  //28.개폐기 가스량
    private String recvst;      //29.개별자재 생산내역서 내용 점검 결과 (S:성공, E:실패)
    private String recvmg;      //30.개별자재 생산내역서 내용 점검 결과 (오류 메세지 기록)

    public MproDetVO() {
    }

    public MproDetVO(String ebeln, String lifnr, String lifnrGr, String ebelp, String matsn, String werks,
                     String eindt, String prdft, String prdsn, String prddt, String prnam, String atwrt00101,
                     String atwrt00102, String atwrt00103, String atwrt00104, String atwrt00105, String atwrt00106,
                     String atwrt00107, String atwrt00108, String atwrt00201, String atwrt00202, String atwrt00203,
                     String atwrt00204, String atwrt00205, String atwrt00206, String atwrt00207, String atwrt00208,
                     String atwrt00209, String recvst, String recvmg) {
        this.ebeln = ebeln;
        this.lifnr = lifnr;
        this.lifnrGr = lifnrGr;
        this.ebelp = ebelp;
        this.matsn = matsn;
        this.werks = werks;
        this.eindt = eindt;
        this.prdft = prdft;
        this.prdsn = prdsn;
        this.prddt = prddt;
        this.prnam = prnam;
        this.atwrt00101 = atwrt00101;
        this.atwrt00102 = atwrt00102;
        this.atwrt00103 = atwrt00103;
        this.atwrt00104 = atwrt00104;
        this.atwrt00105 = atwrt00105;
        this.atwrt00106 = atwrt00106;
        this.atwrt00107 = atwrt00107;
        this.atwrt00108 = atwrt00108;
        this.atwrt00201 = atwrt00201;
        this.atwrt00202 = atwrt00202;
        this.atwrt00203 = atwrt00203;
        this.atwrt00204 = atwrt00204;
        this.atwrt00205 = atwrt00205;
        this.atwrt00206 = atwrt00206;
        this.atwrt00207 = atwrt00207;
        this.atwrt00208 = atwrt00208;
        this.atwrt00209 = atwrt00209;
        this.recvst = recvst;
        this.recvmg = recvmg;
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

    public String getMatsn() {
        return matsn;
    }

    public void setMatsn(String matsn) {
        this.matsn = matsn;
    }

    public String getWerks() {
        return werks;
    }

    public void setWerks(String werks) {
        this.werks = werks;
    }

    public String getEindt() {
        return eindt;
    }

    public void setEindt(String eindt) {
        this.eindt = eindt;
    }

    public String getPrdft() {
        return prdft;
    }

    public void setPrdft(String prdft) {
        this.prdft = prdft;
    }

    public String getPrdsn() {
        return prdsn;
    }

    public void setPrdsn(String prdsn) {
        this.prdsn = prdsn;
    }

    public String getPrddt() {
        return prddt;
    }

    public void setPrddt(String prddt) {
        this.prddt = prddt;
    }

    public String getPrnam() {
        return prnam;
    }

    public void setPrnam(String prnam) {
        this.prnam = prnam;
    }

    public String getAtwrt00101() {
        return atwrt00101;
    }

    public void setAtwrt00101(String atwrt00101) {
        this.atwrt00101 = atwrt00101;
    }

    public String getAtwrt00102() {
        return atwrt00102;
    }

    public void setAtwrt00102(String atwrt00102) {
        this.atwrt00102 = atwrt00102;
    }

    public String getAtwrt00103() {
        return atwrt00103;
    }

    public void setAtwrt00103(String atwrt00103) {
        this.atwrt00103 = atwrt00103;
    }

    public String getAtwrt00104() {
        return atwrt00104;
    }

    public void setAtwrt00104(String atwrt00104) {
        this.atwrt00104 = atwrt00104;
    }

    public String getAtwrt00105() {
        return atwrt00105;
    }

    public void setAtwrt00105(String atwrt00105) {
        this.atwrt00105 = atwrt00105;
    }

    public String getAtwrt00106() {
        return atwrt00106;
    }

    public void setAtwrt00106(String atwrt00106) {
        this.atwrt00106 = atwrt00106;
    }

    public String getAtwrt00107() {
        return atwrt00107;
    }

    public void setAtwrt00107(String atwrt00107) {
        this.atwrt00107 = atwrt00107;
    }

    public String getAtwrt00108() {
        return atwrt00108;
    }

    public void setAtwrt00108(String atwrt00108) {
        this.atwrt00108 = atwrt00108;
    }

    public String getAtwrt00201() {
        return atwrt00201;
    }

    public void setAtwrt00201(String atwrt00201) {
        this.atwrt00201 = atwrt00201;
    }

    public String getAtwrt00202() {
        return atwrt00202;
    }

    public void setAtwrt00202(String atwrt00202) {
        this.atwrt00202 = atwrt00202;
    }

    public String getAtwrt00203() {
        return atwrt00203;
    }

    public void setAtwrt00203(String atwrt00203) {
        this.atwrt00203 = atwrt00203;
    }

    public String getAtwrt00204() {
        return atwrt00204;
    }

    public void setAtwrt00204(String atwrt00204) {
        this.atwrt00204 = atwrt00204;
    }

    public String getAtwrt00205() {
        return atwrt00205;
    }

    public void setAtwrt00205(String atwrt00205) {
        this.atwrt00205 = atwrt00205;
    }

    public String getAtwrt00206() {
        return atwrt00206;
    }

    public void setAtwrt00206(String atwrt00206) {
        this.atwrt00206 = atwrt00206;
    }

    public String getAtwrt00207() {
        return atwrt00207;
    }

    public void setAtwrt00207(String atwrt00207) {
        this.atwrt00207 = atwrt00207;
    }

    public String getAtwrt00208() {
        return atwrt00208;
    }

    public void setAtwrt00208(String atwrt00208) {
        this.atwrt00208 = atwrt00208;
    }

    public String getAtwrt00209() {
        return atwrt00209;
    }

    public void setAtwrt00209(String atwrt00209) {
        this.atwrt00209 = atwrt00209;
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

    @Override
    public String toString() {
        return "MproDetVO{" +
                "ebeln='" + ebeln + '\'' +
                ", lifnr='" + lifnr + '\'' +
                ", lifnrGr='" + lifnrGr + '\'' +
                ", ebelp='" + ebelp + '\'' +
                ", matsn='" + matsn + '\'' +
                ", werks='" + werks + '\'' +
                ", eindt='" + eindt + '\'' +
                ", prdft='" + prdft + '\'' +
                ", prdsn='" + prdsn + '\'' +
                ", prddt='" + prddt + '\'' +
                ", prnam='" + prnam + '\'' +
                ", atwrt00101='" + atwrt00101 + '\'' +
                ", atwrt00102='" + atwrt00102 + '\'' +
                ", atwrt00103='" + atwrt00103 + '\'' +
                ", atwrt00104='" + atwrt00104 + '\'' +
                ", atwrt00105='" + atwrt00105 + '\'' +
                ", atwrt00106='" + atwrt00106 + '\'' +
                ", atwrt00107='" + atwrt00107 + '\'' +
                ", atwrt00108='" + atwrt00108 + '\'' +
                ", atwrt00201='" + atwrt00201 + '\'' +
                ", atwrt00202='" + atwrt00202 + '\'' +
                ", atwrt00203='" + atwrt00203 + '\'' +
                ", atwrt00204='" + atwrt00204 + '\'' +
                ", atwrt00205='" + atwrt00205 + '\'' +
                ", atwrt00206='" + atwrt00206 + '\'' +
                ", atwrt00207='" + atwrt00207 + '\'' +
                ", atwrt00208='" + atwrt00208 + '\'' +
                ", atwrt00209='" + atwrt00209 + '\'' +
                ", recvst='" + recvst + '\'' +
                ", recvmg='" + recvmg + '\'' +
                '}';
    }
}
