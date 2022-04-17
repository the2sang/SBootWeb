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
                mproDetVO.setWerks(rs.getString("WERKS"));
                mproDetVO.setEindt(rs.getString("EINDT"));
                mproDetVO.setPrdft(rs.getString("PRDFT"));
                mproDetVO.setPrdsn(rs.getString("PRDSN"));
                mproDetVO.setPrddt(rs.getString("PRDDT"));
                mproDetVO.setPrnam(rs.getString("PRNAM"));
                mproDetVO.setAtwrt00101(rs.getString("ATWRT_001_01"));
                mproDetVO.setAtwrt00102(rs.getString("ATWRT_001_02"));
                mproDetVO.setAtwrt00103(rs.getString("ATWRT_001_03"));
                mproDetVO.setAtwrt00104(rs.getString("ATWRT_001_04"));
                mproDetVO.setAtwrt00105(rs.getString("ATWRT_001_05"));
                mproDetVO.setAtwrt00106(rs.getString("ATWRT_001_06"));
                mproDetVO.setAtwrt00107(rs.getString("ATWRT_001_07"));
                mproDetVO.setAtwrt00108(rs.getString("ATWRT_001_08"));
                mproDetVO.setAtwrt00201(rs.getString("ATWRT_002_01"));
                mproDetVO.setAtwrt00202(rs.getString("ATWRT_002_02"));
                mproDetVO.setAtwrt00203(rs.getString("ATWRT_002_03"));
                mproDetVO.setAtwrt00204(rs.getString("ATWRT_002_04"));
                mproDetVO.setAtwrt00205(rs.getString("ATWRT_002_05"));
                mproDetVO.setAtwrt00206(rs.getString("ATWRT_002_06"));
                mproDetVO.setAtwrt00207(rs.getString("ATWRT_002_07"));
                mproDetVO.setAtwrt00208(rs.getString("ATWRT_002_08"));
                mproDetVO.setAtwrt00209(rs.getString("ATWRT_002_09"));
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

    public static void saveMproDetList(DataSource ds, List<MproDetVO> listMproDet) {

        Connection conn = null;
        PreparedStatement ps = null;

        try {

            conn = ds.getConnection();

            String sql = "UPDATE XMLEDI_MPRO_DET SET WERKS =  ?,  EINDT = ?, PRDFT = ?, PRDSN= ?, PRDDT = ?, PRNAM = ? " +
                    " WHERE EBELN = ? AND LIFNR = ? AND LIFNR_GR = ? AND EBELP = ? AND MATSN = ?";

            ps = conn.prepareStatement(sql);

            for (MproDetVO vo:listMproDet) {
                //update
                ps.setString(1, vo.getWerks());
                ps.setString(2,vo.getEindt());
                ps.setString(3, vo.getPrdft());
                ps.setString(4, vo.getPrdsn());
                ps.setString(5, vo.getPrddt());
                ps.setString(6, vo.getPrnam());

                //where
                ps.setString(7, vo.getEbeln());
                ps.setString(8, vo.getLifnr());
                ps.setString(9, vo.getLifnrGr());
                ps.setString(10, vo.getEbelp());
                ps.setString(11, vo.getMatsn());

                ps.executeUpdate();
            }

        } catch (Exception e) {
            System.out.println("Save Error:" + e.getMessage());
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

    }



}
