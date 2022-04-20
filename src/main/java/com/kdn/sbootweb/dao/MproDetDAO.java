package com.kdn.sbootweb.dao;

import com.kdn.sbootweb.vo.MproDetVO;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class MproDetDAO {

    public MproDetDAO() {}

    public List<MproDetVO> getAssignOrderDetList(DataSource ds, String ebeln, String lifnr, String lifnrGr, String ebelp) {

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<MproDetVO> list = new ArrayList<>();

        try {

            conn = ds.getConnection();

            pst = conn.prepareStatement("SELECT * FROM XMLEDI_MPRO_DET WHERE EBELN = ? AND LIFNR = ? AND LIFNR_GR = ? AND EBELP = ?");

            pst.setString(1, ebeln);
            pst.setString(2, lifnr);
            pst.setString(3, lifnrGr);
            pst.setString(4, ebelp);

            rs = pst.executeQuery();

            while (rs.next()) {
                MproDetVO mproDetVO = new MproDetVO();

                mproDetVO.setEbeln(rs.getString("EBELN"));
                mproDetVO.setLifnr(rs.getString("LIFNR"));
                mproDetVO.setLifnrGr(rs.getString("LIFNR_GR"));
                mproDetVO.setEbelp(rs.getString("EBELP"));
                mproDetVO.setMatsn(rs.getString("MATSN"));
                mproDetVO.setPrdft(rs.getString("PRDFT"));
                mproDetVO.setPrdsn(rs.getString("PRDSN"));
                mproDetVO.setPrddt(rs.getString("PRDFT")); //생산공장
                mproDetVO.setPrdsn(rs.getString("PRDSN")); //제작번호
                mproDetVO.setPrddt(rs.getString("PRDDT"));  //제작일자
                mproDetVO.setPrnam(rs.getString("PRNAM")); // 제작 담당자 이름
                mproDetVO.setEbelnPo(rs.getString("EBELN_PO")); //인도지시서번호 (0419)
                mproDetVO.setEbelpPo(rs.getString("EBELP_PO"));
                mproDetVO.setAtwrt00101(rs.getString("ATWRT_001_01"));
                mproDetVO.setAtwrt00102(rs.getString("ATWRT_001_02"));
                mproDetVO.setAtwrt00103(rs.getString("ATWRT_001_03"));
                mproDetVO.setAtwrt00104(rs.getString("ATWRT_001_04"));
                mproDetVO.setAtwrt00105(rs.getString("ATWRT_001_05"));
                mproDetVO.setAtwrt00106(rs.getString("ATWRT_001_06"));
                mproDetVO.setAtwrt00107(rs.getString("ATWRT_001_07"));
                mproDetVO.setAtwrt00108(rs.getString("ATWRT_001_08"));
                mproDetVO.setAtwrt00109(rs.getString("ATWRT_001_09"));
                mproDetVO.setAtwrt00201(rs.getString("ATWRT_002_01"));
                mproDetVO.setAtwrt00202(rs.getString("ATWRT_002_02"));
                mproDetVO.setAtwrt00203(rs.getString("ATWRT_002_03"));
                mproDetVO.setAtwrt00204(rs.getString("ATWRT_002_04"));
                mproDetVO.setAtwrt00205(rs.getString("ATWRT_002_05"));
                mproDetVO.setAtwrt00206(rs.getString("ATWRT_002_06"));
                mproDetVO.setAtwrt00207(rs.getFloat("ATWRT_002_07"));
                mproDetVO.setAtwrt00208(rs.getFloat("ATWRT_002_08"));
                mproDetVO.setAtwrt00209(rs.getFloat("ATWRT_002_09"));
                mproDetVO.setRecvst(rs.getString("RECVST"));
                mproDetVO.setRecvmg(rs.getString("RECVMG"));

                list.add(mproDetVO);
            }


        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pst != null)
                    pst.close();
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                e.getStackTrace();
            }
        }

        return list;

    }

    public static boolean saveMproDetList(DataSource ds, List<MproDetVO> listMproDet, String type) {

        Connection conn = null;
        PreparedStatement ps = null;

        try {

            conn = ds.getConnection();

            String sql001 = "UPDATE XMLEDI_MPRO_DET SET PRDFT = ?, PRDSN= ?, PRDDT = ?, PRNAM = ? " + //1,2,3,4
                    " EBELN_PO = ? EBELP_PO = ? ATWRT_001_01 = ?  ATWRT_001_02 = ?  ATWRT_001_03 = ? " + //5,6,7,8,9
                    "  ATWRT_001_04 = ?  ATWRT_001_05 = ?  ATWRT_001_06 = ?  ATWRT_001_07 = ? " + //10,11,12,13
                    "  ATWRT_001_08 = ?  ATWRT_001_09 = ?  " + //22,23,24
                    " WHERE EBELN = ? AND LIFNR = ? AND LIFNR_GR = ? AND EBELP = ? AND MATSN = ?"; //25,26,27, 28, 29

            String sql002 = "UPDATE XMLEDI_MPRO_DET SET PRDFT = ?, PRDSN= ?, PRDDT = ?, PRNAM = ? " + //1,2,3,4
                    " EBELN_PO = ? EBELP_PO = ?  ATWRT_002_01 = ?  ATWRT_002_02 = ? " + //14,15,16,17
                    "  ATWRT_002_03 = ?  ATWRT_002_04 = ?  ATWRT_002_05 = ?  ATWRT_002_06 = ? " + //18,19,20,21
                    "  ATWRT_002_07 = ?  ATWRT_002_08 = ?  ATWRT_002_09 = ? " + //22,23,24
                    " WHERE EBELN = ? AND LIFNR = ? AND LIFNR_GR = ? AND EBELP = ? AND MATSN = ?"; //25,26,27, 28, 29
            if (type != null && type.equals("001")) {
                ps = conn.prepareStatement(sql001);
            } else if (type != null && type.equals("002")) {
                ps = conn.prepareStatement(sql002);
            } else {
                return false;
            }


            for (MproDetVO vo:listMproDet) {
                //update
                ps.setString(1, vo.getPrdft());
                ps.setString(2, vo.getPrdsn());
                ps.setString(3, vo.getPrddt());
                ps.setString(4, vo.getPrnam());
                ps.setString(5, vo.getEbelnPo());
                ps.setString(6, vo.getEbelpPo());

                if (type.equals("001")) { //변압기
                    ps.setString(7, vo.getAtwrt00101());
                    ps.setString(8, vo.getAtwrt00102());
                    ps.setString(9, vo.getAtwrt00103());
                    ps.setString(10, vo.getAtwrt00104());
                    ps.setString(11, vo.getAtwrt00105());
                    ps.setString(12, vo.getAtwrt00106());
                    ps.setString(13, vo.getAtwrt00107());
                    ps.setString(14, vo.getAtwrt00108());
                    ps.setString(15, vo.getAtwrt00109());
                }

                if (type.equals("002")) {  //개폐기
                    ps.setString(7, vo.getAtwrt00101());
                    ps.setString(8, vo.getAtwrt00202());
                    ps.setString(9, vo.getAtwrt00203());
                    ps.setString(10, vo.getAtwrt00204());
                    ps.setString(11, vo.getAtwrt00205());
                    ps.setString(12, vo.getAtwrt00206());
                    ps.setFloat(13, vo.getAtwrt00207());
                    ps.setFloat(14, vo.getAtwrt00208());
                    ps.setFloat(15, vo.getAtwrt00209());
                }

                ps.setString(16, vo.getEbeln());  //where
                ps.setString(17, vo.getLifnr());
                ps.setString(18, vo.getLifnrGr());
                ps.setString(19, vo.getEbelp());
                ps.setString(20, vo.getMatsn());

                ps.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println("Save Error:" + e.getMessage());
            return false;
        } finally {
            try {
                if (ps != null)
                    ps.close();
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
        return true;

    }

    private String getMproDetSaveSql(String type) {

        return null;
    }




}
