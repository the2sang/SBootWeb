package com.kdn.sbootweb.dao;

import com.kdn.sbootweb.vo.MproMstVO;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.sql.*;

@Component
public class MproMstDAO {

    public MproMstDAO() {
    }

    public MproMstVO getAssingOrderMst(DataSource ds, String ebeln, String lifnr, String lifnrGr, String ebelp) {

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        MproMstVO mproMstVO = null;

        try {

            conn = ds.getConnection();

            pst = conn.prepareStatement("SELECT * FROM XMLEDI_MPRO_MST WHERE EBELN = ? AND LIFNR= ? AND LIFNR_GR = ? AND EBELP = ?");

            pst.setString(1, ebeln);
            pst.setString(2, lifnr);
            pst.setString(3, lifnrGr);
            pst.setString(4, ebelp);

            rs = pst.executeQuery();

            if(rs.next()) {
                mproMstVO = new MproMstVO();
                mproMstVO.setEbeln(rs.getString("EBELN"));
                mproMstVO.setLifnr(rs.getString("LIFNR"));
                mproMstVO.setLifnrGr(rs.getString("LIFNR_GR"));
                mproMstVO.setEbelp(rs.getString("EBELP"));
                mproMstVO.setEbdat(rs.getString("EBDAT")); //
                mproMstVO.setLifnrNm(rs.getString("LIFNR_NM")); //
                mproMstVO.setLifnrGrnm(rs.getString("LIFNR_GRNM")); //
                mproMstVO.setWerks(rs.getString("WERKS")); //
                mproMstVO.setName1(rs.getString("NAME1")); //
                mproMstVO.setMatnr(rs.getString("MATNR"));
                mproMstVO.setTxz01(rs.getString("TXZ01"));
                mproMstVO.setMenge(rs.getString("MENGE"));
                mproMstVO.setNetpr(rs.getString("NETPR"));
                mproMstVO.setNetwr(rs.getString("NETWR"));
                mproMstVO.setZbpmng(rs.getString("ZBPMNG"));
                mproMstVO.setMeins(rs.getString("MEINS"));
                mproMstVO.setWaers(rs.getString("WAERS"));
                mproMstVO.setPrueflog(rs.getString("FRUEFLOG")); //
                mproMstVO.setMatsnFr(rs.getString("MATSN_FR"));
                mproMstVO.setMatsnTo(rs.getString("MATSN_TO"));
                mproMstVO.setMatsnCnt(rs.getLong("MATSN_CNT")); //
                mproMstVO.setAtwrtTp(rs.getString("ATWRT_TP"));
                mproMstVO.setInputSt(rs.getString("INPUT_ST"));
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
        return mproMstVO;
    }

    public static boolean confirmMproDetData(DataSource ds, MproMstVO updateVO) {

        Connection conn = null;
        PreparedStatement ps = null;
        boolean checkUpdate = false;

        try {
            conn = ds.getConnection();

            String sql = "UPDATE XMLEDI_MPRO_MST SET INPUT_ST =  ?   WHERE EBELN = ? AND LIFNR = ? AND LIFNR_GR = ? AND EBELP = ?";

            ps = conn.prepareStatement(sql);

            ps.setString(1, updateVO.getInputSt());
            ps.setString(2, updateVO.getEbeln());
            ps.setString(3, updateVO.getLifnr());
            ps.setString(4, updateVO.getLifnrGr());
            ps.setString(5, updateVO.getEbelp());

            ps.executeUpdate();
            checkUpdate = true;

        } catch (SQLException se) {
            System.out.println("MproMst Confirm Update Error:" + se.getMessage());
            checkUpdate = false;
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
        return checkUpdate;
    }

}
