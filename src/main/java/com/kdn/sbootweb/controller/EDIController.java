package com.kdn.sbootweb.controller;


import com.kdn.sbootweb.dao.MproDetDAO;
import com.kdn.sbootweb.dao.MproMstDAO;
import com.kdn.sbootweb.vo.MproDetVO;
import com.kdn.sbootweb.vo.MproMstVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class EDIController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/")
    public String home() {
        return "index";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/switch")
    public ModelAndView getSwitchList() {

        String ebeln = "4100100208";
        String lifnr = "1188200345";
        String lifnrGr = "1188200345";
        String ebelp = "22345";

        ModelAndView mv = new ModelAndView();
        MproMstDAO mproMstDAO = new MproMstDAO();
        MproDetDAO mproDetDAO = new MproDetDAO();
        MproMstVO mproMstVO;

        DataSource ds = jdbcTemplate.getDataSource();

        mproMstVO = mproMstDAO.getAssingOrderMst(ds, ebeln, lifnr, lifnrGr, ebelp);

        List<MproDetVO> mproDetVOList = mproDetDAO.getAssignOrderDetList(ds, ebeln, lifnr, lifnrGr, ebelp);

        mv.addObject("switchHeader", mproMstVO);
        mv.addObject("switchItem", mproDetVOList);
        mv.setViewName("input_switch");

        return mv;

    }




    @RequestMapping(method = RequestMethod.GET, value = "/trans")
    public ModelAndView getTransList() {

        ModelAndView mv = new ModelAndView();
        MproMstDAO mproMstDAO = new MproMstDAO();
        MproDetDAO mproDetDAO = new MproDetDAO();
        MproMstVO mproMstVO;

        String ebeln = "4100100208";
        String lifnr = "1188200345";
        String lifnrGr = "1188200345";
        String ebelp = "12345";

        DataSource ds = jdbcTemplate.getDataSource();

        mproMstVO = mproMstDAO.getAssingOrderMst(ds, ebeln, lifnr, lifnrGr, ebelp);

        List<MproDetVO> mproDetVOList = mproDetDAO.getAssignOrderDetList(ds, ebeln, lifnr, lifnrGr, ebelp);

        mv.addObject("transHeader", mproMstVO);
        mv.addObject("transItem", mproDetVOList);
        mv.setViewName("input_trans");

        return mv;
    }

    @RequestMapping(value ="/updateMproDetTransList", method = RequestMethod.POST )
    public ModelAndView updateMproDetTransList(HttpServletRequest req, HttpServletResponse res) {
        MproMstVO mproMstVO = (MproMstVO)req.getSession().getAttribute("transHeader");

        List<MproDetVO> saveList = new ArrayList<>();
        MproDetVO vo;

        DataSource ds = jdbcTemplate.getDataSource();

        String inputSt = req.getParameter("inputSt");  // ???????????? ????????? ?????? C ??? ???????????? ????????? ?????? I


        String[] ebelns = req.getParameterValues("ebeln");
        String[] lifnrs = req.getParameterValues("lifnr");
        String[] lifnrGrs = req.getParameterValues("lifnrGr");
        String[] ebelps = req.getParameterValues("ebelp");
        String[] matsns = req.getParameterValues("matsn");

        String[] prdfts = req.getParameterValues("prdft");
        String[] prdsns = req.getParameterValues("prdsn");
        String[] prddts = req.getParameterValues("prddt");
        String[] prnams = req.getParameterValues("prnam");
        String[] ebelnPos = req.getParameterValues("ebelnPo");
        String[] ebelpPos = req.getParameterValues("ebelpPo");

        String[] atwrt00101s = new String[ebelns.length];
        String[] atwrt00102s= new String[ebelns.length];
        String[] atwrt00103s= new String[ebelns.length];
        String[] atwrt00104s= new String[ebelns.length];
        String[] atwrt00105s= new String[ebelns.length];
        String[] atwrt00106s= new String[ebelns.length];
        String[] atwrt00107s= new String[ebelns.length];
        String[] atwrt00108s= new String[ebelns.length];
        String[] atwrt00109s= new String[ebelns.length];

        atwrt00101s = req.getParameterValues("atwrt00101");
        atwrt00102s = req.getParameterValues("atwrt00102");
        atwrt00103s = req.getParameterValues("atwrt00103");
        atwrt00104s = req.getParameterValues("atwrt00104");
        atwrt00105s = req.getParameterValues("atwrt00105");
        atwrt00106s = req.getParameterValues("atwrt00106");
        atwrt00107s = req.getParameterValues("atwrt00107");
        atwrt00108s = req.getParameterValues("atwrt00108");
        atwrt00109s = req.getParameterValues("atwrt00109");


        for (int i=0; i < ebelns.length; i++) { //????????? ?????? ?????? ??????
            vo = new MproDetVO();
            vo.setEbeln(ebelns[i]);
            vo.setLifnr(lifnrs[i]);
            vo.setLifnrGr(lifnrGrs[i]);
            vo.setEbelp(ebelps[i]);
            vo.setMatsn(matsns[i]);   //where

            if (prdfts[i] != null && !prdfts.equals("")) {
                vo.setPrdft(prdfts[i]);
            }

            if (!StringUtils.isEmpty(prdsns[i])) {
                vo.setPrdsn(prdsns[i]);
            }

            if (!StringUtils.isEmpty(prddts[i])) {
                vo.setPrddt(prddts[i]);
            }

            if (!StringUtils.isEmpty(prnams[i])) {
                vo.setPrnam(prnams[i]);
            }

            if (!StringUtils.isEmpty(ebelnPos[i])) {
                vo.setEbelnPo(ebelnPos[i]);
            }

            if (!StringUtils.isEmpty(ebelpPos[i])) {
                vo.setEbelpPo(ebelpPos[i]);
            }

            if (!StringUtils.isEmpty(atwrt00101s[i])) {
                vo.setAtwrt00101(atwrt00101s[i]);
            }
            if (!StringUtils.isEmpty(atwrt00102s[i])) {
                vo.setAtwrt00102(atwrt00102s[i]);
            }
            if (!StringUtils.isEmpty(atwrt00103s[i])) {
                vo.setAtwrt00103(atwrt00103s[i]);
            }
            if (!StringUtils.isEmpty(atwrt00104s[i])) {
                vo.setAtwrt00104(atwrt00104s[i]);
            }
            if (!StringUtils.isEmpty(atwrt00105s[i])) {
                vo.setAtwrt00105(atwrt00105s[i]);
            }
            if (!StringUtils.isEmpty(atwrt00106s[i])) {
                vo.setAtwrt00106(new Integer(atwrt00106s[i]).intValue());
            }
            if (!StringUtils.isEmpty(atwrt00107s[i])) {
                vo.setAtwrt00107(new Integer(atwrt00107s[i]).intValue());
            }
            if (!StringUtils.isEmpty(atwrt00108s[i])) {
                vo.setAtwrt00108(new Integer(atwrt00108s[i]).intValue());
            }
            if (!StringUtils.isEmpty(atwrt00109s[i])) {
                vo.setAtwrt00109(atwrt00109s[i]);
            }

            saveList.add(vo);
        }

        boolean updateResult = MproDetDAO.saveMproDetTransList(ds, saveList);

        //???????????? ?????????(C) ????????? ????????????
        if (updateResult == true && inputSt.equals("C")) {
            mproMstVO.setInputSt("C");
            updateResult = MproMstDAO.confirmMproDetData(ds, mproMstVO);
        }


        ModelAndView mv = new ModelAndView();
        mv.addObject("transHeader", mproMstVO);
        mv.addObject("transItem", saveList);
        mv.addObject("updateTransResult", updateResult);
        //????????? ???????????? ?????? ????????? ??????
        mv.setViewName("input_trans");

        req.getSession().setAttribute("updateTransResult", updateResult);

        return mv;
    }

    @RequestMapping(value ="/updateMproDetSwitchList", method = RequestMethod.POST )
    public ModelAndView updateMproDetSwitchList(HttpServletRequest req, HttpServletResponse res) {
        MproMstVO mproMstVO = (MproMstVO)req.getSession().getAttribute("switchHeader");

        List<MproDetVO> saveList = new ArrayList<>();
        MproDetVO vo;

        String inputSt = req.getParameter("inputSt");  // ???????????? ????????? ?????? C ??? ???????????? ????????? ?????? I

        DataSource ds = jdbcTemplate.getDataSource();

        String[] ebelns = req.getParameterValues("ebeln");
        String[] lifnrs = req.getParameterValues("lifnr");
        String[] lifnrGrs = req.getParameterValues("lifnrGr");
        String[] ebelps = req.getParameterValues("ebelp");
        String[] matsns = req.getParameterValues("matsn");

        String[] prdfts = req.getParameterValues("prdft");
        String[] prdsns = req.getParameterValues("prdsn");
        String[] prddts = req.getParameterValues("prddt");
        String[] prnams = req.getParameterValues("prnam");
        String[] ebelnPos = req.getParameterValues("ebelnPo");
        String[] ebelpPos = req.getParameterValues("ebelpPo");


        String[] atwrt00201s= new String[ebelns.length];
        String[] atwrt00202s= new String[ebelns.length];
        String[] atwrt00203s= new String[ebelns.length];
        String[] atwrt00204s= new String[ebelns.length];
        String[] atwrt00205s= new String[ebelns.length];
        String[] atwrt00206s= new String[ebelns.length];
        String[] atwrt00207s= new String[ebelns.length];
        String[] atwrt00208s= new String[ebelns.length];
        String[] atwrt00209s= new String[ebelns.length];
        atwrt00201s = req.getParameterValues("atwrt00201");
        atwrt00202s = req.getParameterValues("atwrt00202");
        atwrt00203s = req.getParameterValues("atwrt00203");
        atwrt00204s = req.getParameterValues("atwrt00204");
        atwrt00205s = req.getParameterValues("atwrt00205");
        atwrt00206s = req.getParameterValues("atwrt00206");
        atwrt00207s = req.getParameterValues("atwrt00207");
        atwrt00208s = req.getParameterValues("atwrt00208");
        atwrt00209s = req.getParameterValues("atwrt00209");


        for (int i=0; i < ebelns.length; i++) { //????????? ?????? ?????? ??????
            vo = new MproDetVO();
            vo.setEbeln(ebelns[i]);
            vo.setLifnr(lifnrs[i]);
            vo.setLifnrGr(lifnrGrs[i]);
            vo.setEbelp(ebelps[i]);
            vo.setMatsn(matsns[i]);   //where

            if (prdfts[i] != null && !prdfts.equals("")) {
                vo.setPrdft(prdfts[i]);
            }

            if (!StringUtils.isEmpty(prdsns[i])) {
                vo.setPrdsn(prdsns[i]);
            }

            if (!StringUtils.isEmpty(prddts[i])) {
                vo.setPrddt(prddts[i]);
            }

            if (!StringUtils.isEmpty(prnams[i])) {
                vo.setPrnam(prnams[i]);
            }

            if (!StringUtils.isEmpty(ebelnPos[i])) {
                vo.setEbelnPo(ebelnPos[i]);
            }

            if (!StringUtils.isEmpty(ebelpPos[i])) {
                vo.setEbelpPo(ebelpPos[i]);
            }

            if (!StringUtils.isEmpty(atwrt00201s[i])) {
                vo.setAtwrt00201(atwrt00201s[i]);
            }
            if (!StringUtils.isEmpty(atwrt00202s[i])) {
                vo.setAtwrt00202(atwrt00202s[i]);
            }
            if (!StringUtils.isEmpty(atwrt00203s[i])) {
                vo.setAtwrt00203(atwrt00203s[i]);
            }
            if (!StringUtils.isEmpty(atwrt00204s[i])) {
                vo.setAtwrt00204(atwrt00204s[i]);
            }
            if (!StringUtils.isEmpty(atwrt00205s[i])) {
                vo.setAtwrt00205(atwrt00205s[i]);
            }
            if (!StringUtils.isEmpty(atwrt00206s[i])) {
                vo.setAtwrt00206(atwrt00206s[i]);
            }
            if (!StringUtils.isEmpty(atwrt00207s[i])) {
                vo.setAtwrt00207(new Float(atwrt00207s[i]).floatValue());
            }
            if (!StringUtils.isEmpty(atwrt00208s[i])) {
                vo.setAtwrt00208(new Float(atwrt00208s[i]).floatValue());
            }
            if (!StringUtils.isEmpty(atwrt00209s[i])) {
                vo.setAtwrt00209(new Float(atwrt00209s[i]).floatValue());
            }

            saveList.add(vo);
        }

        boolean updateResult = MproDetDAO.saveMproDetSwitchList(ds, saveList);

        //???????????? ?????????(C) ????????? ????????????
        if (updateResult == true && inputSt.equals("C")) {
            mproMstVO.setInputSt("C");
            updateResult = MproMstDAO.confirmMproDetData(ds, mproMstVO);
        }

        ModelAndView mv = new ModelAndView();
        mv.addObject("switchHeader", mproMstVO);
        mv.addObject("switchItem", saveList);
        mv.addObject("updateSwitchResult", updateResult);

        //????????? ???????????? ?????? ????????? ??????
        mv.setViewName("input_switch");

        req.getSession().setAttribute("updateSwitchResult", updateResult);

        return mv;

    }


    @RequestMapping(method = RequestMethod.GET, value = "/confirmMproDetTransData")
    public RedirectView confirmMproDetTransData(HttpServletRequest req, HttpServletResponse res, Model model,
                                           @RequestParam(value = "confirmData") String confirmCheck) {

        System.out.println("confirmCHeck:" + confirmCheck);

        MproMstVO mproMstVO = (MproMstVO)req.getSession().getAttribute("transHeader");
        List<MproDetVO> mproDetVOList = (List<MproDetVO>)req.getSession().getAttribute("transItem");

        DataSource ds = jdbcTemplate.getDataSource();


        if (confirmCheck.equals("true")) {
            mproMstVO.setInputSt("C"); //????????????
            req.getSession().setAttribute("confirmCheckTrans", true);
        } else {
            mproMstVO.setInputSt("S"); //????????????
            req.getSession().setAttribute("confirmCheckTrans", false);
        }

        boolean checkUpdate = MproMstDAO.confirmMproDetData(ds, mproMstVO);


        ModelAndView mv = new ModelAndView();
        //mv.addObject("confirmCheck", "true");
        mv.addObject("transHeader" + mproMstVO);
        mv.addObject("transItem" + mproDetVOList);
        mv.setViewName("input_trans");

        //model.addAttribute("confirmCheck", checkUpdate);
        return new RedirectView("/trans");
    }


    @RequestMapping(method = RequestMethod.GET, value = "/confirmMproDetSwitchData")
    public RedirectView confirmMproDetSwitchData(HttpServletRequest req, HttpServletResponse res, Model model,
                                           @RequestParam(value = "confirmData") String confirmCheck) {

        System.out.println("confirmCHeck:" + confirmCheck);

        MproMstVO mproMstVO = (MproMstVO)req.getSession().getAttribute("switchHeader");
        List<MproDetVO> mproDetVOList = (List<MproDetVO>)req.getSession().getAttribute("switchItem");

        DataSource ds = jdbcTemplate.getDataSource();



        if (confirmCheck.equals("true")) {
            mproMstVO.setInputSt("C"); //????????????
            req.getSession().setAttribute("confirmCheckSwitch", true);
        } else {
            mproMstVO.setInputSt("S"); //????????????
            req.getSession().setAttribute("confirmCheckSwitch", false);
        }

        boolean checkUpdate = MproMstDAO.confirmMproDetData(ds, mproMstVO);


        ModelAndView mv = new ModelAndView();
        //mv.addObject("confirmCheck", "true");
        mv.addObject("switchHeader" + mproMstVO);
        mv.addObject("switchItem" + mproDetVOList);
        mv.setViewName("input_switch");

        //model.addAttribute("confirmCheck", checkUpdate);
        return new RedirectView("/switch");
    }


}
