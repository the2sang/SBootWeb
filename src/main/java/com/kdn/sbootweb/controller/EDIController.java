package com.kdn.sbootweb.controller;


import com.kdn.sbootweb.dao.MproDetDAO;
import com.kdn.sbootweb.dao.MproMstDAO;
import com.kdn.sbootweb.vo.MproDetVO;
import com.kdn.sbootweb.vo.MproMstVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
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


    @RequestMapping(method = RequestMethod.GET, value = "/trans")
    public ModelAndView getTransList() {

        ModelAndView mv = new ModelAndView();
        MproMstDAO mproMstDAO = new MproMstDAO();
        MproDetDAO mproDetDAO = new MproDetDAO();
        MproMstVO mproMstVO = new MproMstVO();

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

        String[] werkss = req.getParameterValues("werks");
        String[] eindts = req.getParameterValues("eindt");
        String[] prdfts = req.getParameterValues("prdft");
        String[] prdsns = req.getParameterValues("prdsn");
        String[] prddts = req.getParameterValues("prddt");
        String[] prnams = req.getParameterValues("prnam");

        for (int i=0; i < ebelns.length; i++) {
            vo = new MproDetVO();
            vo.setEbeln(ebelns[i]);
            vo.setLifnr(lifnrs[i]);
            vo.setLifnrGr(lifnrGrs[i]);
            vo.setEbelp(ebelps[i]);
            vo.setMatsn(matsns[i]);
            vo.setWerks(werkss[i]);
            vo.setEindt(eindts[i]);
            vo.setPrdft(prdfts[i]);
            vo.setPrdsn(prdsns[i]);
            vo.setPrddt(prddts[i]);
            vo.setPrnam(prnams[i]);

            saveList.add(vo);
        }

        MproDetDAO.saveMproDetList(ds, saveList);

//        System.out.println("Header:" + mproMstVO);
//        System.out.println("Details:" + saveList);


        ModelAndView mv = new ModelAndView();
        mv.addObject("mproMstVO", mproMstVO);
        mv.addObject("mproDetVOList", saveList);
        mv.setViewName("input_trans");

        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/confirmMproDetData")
    public RedirectView confirmMproDetData(HttpServletRequest req, HttpServletResponse res, @RequestParam(value = "confirmData") String confirmCheck) {

        System.out.println("confirmCHeck:" + confirmCheck);

        MproMstVO mproMstVO = (MproMstVO)req.getSession().getAttribute("mproMstVO");
        List<MproDetVO> mproDetVOList = (List<MproDetVO>)req.getSession().getAttribute("mproDetVOList");

        if (confirmCheck.equals("confirm")) {
            mproMstVO.setInputSt("C"); //확정상태
        } else {
            mproMstVO.setInputSt("S"); //저장상태
        }

        DataSource ds = jdbcTemplate.getDataSource();

        boolean checkUpdate = MproMstDAO.confirmMproDetData(ds, mproMstVO);
        ModelAndView mv = new ModelAndView();
        mv.addObject("updateCheck", checkUpdate);
        mv.addObject("mproMstVO" + mproMstVO);
        mv.addObject("mproDetVOList" + mproDetVOList);
        mv.setViewName("input_trans");
        return new RedirectView("/trans");
    }


}
