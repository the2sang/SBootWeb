package com.kdn.sbootweb.controller;


import com.kdn.sbootweb.dao.MproDetDAO;
import com.kdn.sbootweb.dao.MproMstDAO;
import com.kdn.sbootweb.vo.MproDetVO;
import com.kdn.sbootweb.vo.MproMstVO;
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

        mv.addObject("mproMstVO", mproMstVO);
        mv.addObject("mproDetVOList", mproDetVOList);
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

        mv.addObject("mproMstVO", mproMstVO);
        mv.addObject("mproDetVOList", mproDetVOList);
        mv.setViewName("input_trans");

        return mv;
    }

    @RequestMapping(value ="/updateMproDetList", method = RequestMethod.POST )
    public ModelAndView updateMproDetList(HttpServletRequest req, HttpServletResponse res) {


        MproMstVO mproMstVO = (MproMstVO)req.getSession().getAttribute("mproMstVO");


        List<MproDetVO> saveList = new ArrayList<>();
        MproDetVO vo;

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
        String[] atwrt00101s = req.getParameterValues("atwrt00101");
        String[] atwrt00102s = req.getParameterValues("atwrt00102");
        String[] atwrt00103s = req.getParameterValues("atwrt00103");
        String[] atwrt00104s = req.getParameterValues("atwrt00104");
        String[] atwrt00105s = req.getParameterValues("atwrt00105");
        String[] atwrt00106s = req.getParameterValues("atwrt00106");
        String[] atwrt00107s = req.getParameterValues("atwrt00107");
        String[] atwrt00108s = req.getParameterValues("atwrt00108");
        String[] atwrt00109s = req.getParameterValues("atwrt00109");

        String[] atwrt00201s = req.getParameterValues("atwrt00201");
        String[] atwrt00202s = req.getParameterValues("atwrt00202");
        String[] atwrt00203s = req.getParameterValues("atwrt00203");
        String[] atwrt00204s = req.getParameterValues("atwrt00204");
        String[] atwrt00205s = req.getParameterValues("atwrt00205");
        String[] atwrt00206s = req.getParameterValues("atwrt00206");
        String[] atwrt00207s = req.getParameterValues("atwrt00207");
        String[] atwrt00208s = req.getParameterValues("atwrt00208");
        String[] atwrt00209s = req.getParameterValues("atwrt00209");

        for (int i=0; i < ebelns.length; i++) {
            vo = new MproDetVO();
            vo.setEbeln(ebelns[i]);
            vo.setLifnr(lifnrs[i]);
            vo.setLifnrGr(lifnrGrs[i]);
            vo.setEbelp(ebelps[i]); //where

            vo.setPrdft(prdfts[i]);
            vo.setPrdsn(prdsns[i]);
            vo.setPrddt(prddts[i]);
            vo.setPrnam(prnams[i]);
            vo.setEbelnPo(ebelnPos[i]);
            vo.setEbelpPo(ebelpPos[i]);

            vo.setAtwrt00101(atwrt00101s[i]);
            vo.setAtwrt00102(atwrt00102s[i]);
            vo.setAtwrt00103(atwrt00103s[i]);
            vo.setAtwrt00104(atwrt00104s[i]);
            vo.setAtwrt00105(atwrt00105s[i]);
            vo.setAtwrt00106(atwrt00106s[i]);
            vo.setAtwrt00107(atwrt00107s[i]);
            vo.setAtwrt00108(atwrt00108s[i]);
            vo.setAtwrt00109(atwrt00109s[i]);

            vo.setAtwrt00201(atwrt00201s[i]);
            vo.setAtwrt00202(atwrt00202s[i]);
            vo.setAtwrt00203(atwrt00203s[i]);
            vo.setAtwrt00204(atwrt00204s[i]);
            vo.setAtwrt00205(atwrt00205s[i]);
            vo.setAtwrt00206(atwrt00206s[i]);
            vo.setAtwrt00207(atwrt00207s[i]);
            vo.setAtwrt00208(atwrt00208s[i]);
            vo.setAtwrt00209(atwrt00209s[i]);


            saveList.add(vo);
        }

        boolean updateResult = MproDetDAO.saveMproDetList(ds, saveList);


        ModelAndView mv = new ModelAndView();
        mv.addObject("mproMstVO", mproMstVO);
        mv.addObject("mproDetVOList", saveList);
        mv.addObject("updateResult", updateResult);
        mv.setViewName("input_trans");

        req.getSession().setAttribute("updateResult", updateResult);

        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/confirmMproDetData")
    public RedirectView confirmMproDetData(HttpServletRequest req, HttpServletResponse res, Model model,
                                           @RequestParam(value = "confirmData") String confirmCheck) {

        System.out.println("confirmCHeck:" + confirmCheck);

        MproMstVO mproMstVO = (MproMstVO)req.getSession().getAttribute("mproMstVO");
        List<MproDetVO> mproDetVOList = (List<MproDetVO>)req.getSession().getAttribute("mproDetVOList");

        DataSource ds = jdbcTemplate.getDataSource();

        boolean checkUpdate = MproMstDAO.confirmMproDetData(ds, mproMstVO);

        if (confirmCheck.equals("confirm")) {
            mproMstVO.setInputSt("C"); //확정상태
            req.getSession().setAttribute("confirmCheck", true);
        } else {
            mproMstVO.setInputSt("S"); //저장상태
            req.getSession().setAttribute("confirmCheck", false);
        }


        ModelAndView mv = new ModelAndView();
        //mv.addObject("confirmCheck", "true");
        mv.addObject("mproMstVO" + mproMstVO);
        mv.addObject("mproDetVOList" + mproDetVOList);
        mv.setViewName("input_trans");

        //model.addAttribute("confirmCheck", checkUpdate);
        return new RedirectView("/trans");
    }


}
