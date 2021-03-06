<%@ page import="com.kdn.sbootweb.vo.MproMstVO" %>
<%@ page import="com.kdn.sbootweb.vo.MproDetVO" %>
<%@ page import="java.util.List" %>
<%@ page import="org.apache.commons.lang3.StringUtils" %>
<%@ page import="java.util.Iterator" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

  <%

    MproMstVO header = (MproMstVO)request.getAttribute("transHeader");
    List<MproDetVO> detailList = (List<MproDetVO>)request.getAttribute("transItem");

  %>

  <title>자재 생산정보 내역서(변압기)</title>

  <script src="static/js/jquery-3.6.0.min.js" type="text/javascript" ></script>

  <link rel="stylesheet" type="text/css" href="static/css/trans.css">

  <script type="text/javascript">
    $(document).ready(function(){
      //화면 로딩시 처리
      var confirmCheck = "<%= header.getInputSt()%>";

      if (confirmCheck === 'C') {
        $(".input-class").attr("disabled", true);
        $(".input-class-prdft").attr("disabled", true);
        $(".input-class-prddt").attr("disabled", true);
        $(".input-class-prnam").attr("disabled", true);
        $(".input-class-ebelnPo").attr("disabled", true);
        $(".input-class-ebelpPo").attr("disabled", true);
        $(".input-class-atwrt00106").attr("disabled", true);
        $(".input-class-atwrt00107").attr("disabled", true);
        $(".input-class-atwrt00108").attr("disabled", true);
        $(".allinBtn").attr("disabled", true);
        $('.allinBtn').css({'color':'white', 'background-color':'darkgrey'});

        $('#tempSaveBtn').attr("disabled", true);
        $('#tempSaveBtn').css({'color':'white', 'background-color':'darkgrey'});
        $('#confirmBtn').attr("disabled", true);
        $('#confirmBtn').css({'color':'white', 'background-color':'darkgrey'});
      }

      // 확정 버튼 처리
      $('#confirmBtn').on("click", function(e){
        e.preventDefault();

        $("#inputSt").val('C');

        var form = $("#saveForm");
        var url = form.attr('action');
        $.ajax({
          type: "POST",
          url: url,
          data: form.serialize(),
          success: function(data) {
            //alert("확정 취소되어 다시 등록할 수 있습니다.");
            $(".input-class").attr("disabled", true);
            $(".input-class").attr("disabled", true);
            $(".input-class-prdft").attr("disabled", true);
            $(".input-class-prddt").attr("disabled", true);
            $(".input-class-prnam").attr("disabled", true);
            $(".input-class-ebelnPo").attr("disabled", true);
            $(".input-class-ebelpPo").attr("disabled", true);
            $(".input-class-atwrt00106").attr("disabled", true);
            $(".input-class-atwrt00107").attr("disabled", true);
            $(".input-class-atwrt00108").attr("disabled", true);
            $(".allinBtn").attr("disabled", true);
            $('.allinBtn').css({'color':'white', 'background-color':'darkgrey'});

            $('#tempSaveBtn').attr("disabled", true);
            $('#tempSaveBtn').css({'color':'white', 'background-color':'darkgrey'});
            $('#confirmBtn').attr("disabled", true);
            $('#confirmBtn').css({'color':'white', 'background-color':'darkgrey'});

            //입력상태값 초기화
            $("#inputSt").val('');

          },
          error: function(data) {
            alert("저장실패");
          }
        });
      });

      //확정 취조 버튼 처리
      $('#cancelBtn').on("click", function(e){
        e.preventDefault();

        var url = "/confirmMproDetTransData?confirmData=false";
        $.ajax({
          type: "GET",
          url: url,
          success: function(data) {
            //alert("확정되어 전송 상태로 전환되었습니다. 확정취소하시면 다시 등록할 수 있습니다.");
            $(".input-class").attr("disabled", false);
            $(".input-class-prdft").attr("disabled", false);
            $(".input-class-prddt").attr("disabled", false);
            $(".input-class-prnam").attr("disabled", false);
            $(".input-class-ebelnPo").attr("disabled", false);
            $(".input-class-ebelpPo").attr("disabled", false);
            $(".input-class-atwrt00106").attr("disabled", false);
            $(".input-class-atwrt00107").attr("disabled", false);
            $(".input-class-atwrt00108").attr("disabled", false);
            $(".allinBtn").attr("disabled", false);
            $('.allinBtn').css({'color':'white', 'background-color':'#3b5998'});

            $('#tempSaveBtn').attr("disabled", false);
            $('#tempSaveBtn').css({'color':'white', 'background-color':'#3b5998'});
            $('#confirmBtn').attr("disabled", false);
            $('#confirmBtn').css({'color':'white', 'background-color':'#3b5998'});

          },
          error: function(data) {
            alert("저장실패");
          }
        });
      });

      //임시저장 버튼 처리
      $("#tempSaveBtn").click(function(ev) {
        ev.preventDefault();
        var form = $("#saveForm");
        var url = form.attr('action');
        $.ajax({
          type: "POST",
          url: url,
          data: form.serialize(),
          success: function(data) {
            alert("저장완료");
          },
          error: function(data) {
            alert("저장실패");
          }
        });
      });


      //일괄등록 버튼 처리 - 8개 버튼
      $("#rdftAllIn").on("click", function (e) {
        e.preventDefault();
        var inVal = $('input[name=prdft]').val();
        //alert("inVal:" + inVal);
        $(".input-class-prdft").val(inVal);

      });

      $("#prddtAllIn").on("click", function (e) {
        e.preventDefault();
        var inVal = $('input[name=prddt]').val();
        //alert("inVal:" + inVal);
        $(".input-class-prddt").val(inVal);

      });

      $("#prnamAllIn").on("click", function (e) {
        e.preventDefault();
        var inVal = $('input[name=prnam]').val();
        //alert("inVal:" + inVal);
        $(".input-class-prnam").val(inVal);

      });

      $("#ebelnPoAllIn").on("click", function (e) {
        e.preventDefault();
        var inVal = $('input[name=ebelnPo]').val();
        //alert("inVal:" + inVal);
        $(".input-class-ebelnPo").val(inVal);
      });

      $("#ebelpPoAllIn").on("click", function (e) {
        e.preventDefault();
        var inVal = $('input[name=ebelpPo]').val();
        //alert("inVal:" + inVal);
        $(".input-class-ebelpPo").val(inVal);
      });

      $("#atwrt00106AllIn").on("click", function (e) {
        e.preventDefault();
        var inVal = $('input[name=atwrt00106]').val();
        //alert("inVal:" + inVal);
        $(".input-class-atwrt00106").val(inVal);
      });

      $("#atwrt00107AllIn").on("click", function (e) {
        e.preventDefault();
        var inVal = $('input[name=atwrt00107]').val();
        //alert("inVal:" + inVal);
        $(".input-class-atwrt00107").val(inVal);
      });

      $("#atwrt00108AllIn").on("click", function (e) {
        e.preventDefault();
        var inVal = $('input[name=atwrt00108]').val();
        //alert("inVal:" + inVal);
        $(".input-class-atwrt00108").val(inVal);
      });


    });


  </script>
</head>

<body>
<h2 style="margin: 20px">개별관리 자재 생산정보 내역서(변압기)</h2>



<table class="header-table">
  <tr>
    <th style="width: 60px">주문번호</th>
    <td><%= header.getEbeln()%></td>
    <td style="width: 200px"></td>
    <th style="width: 60px">주문일자</th>
    <td colspan="2"><% if (!StringUtils.isEmpty(header.getBedat())) { %><%=header.getBedat()%> <% } %></td>
  </tr>
  <tr>
    <th>납품업체</th>
    <td><%= header.getLifnrGr()%></td>
    <td><%= header.getLifnrGrnm()%></td>
    <th>계약업체</th>
    <td><%=header.getLifnr()%></td>
    <td style="width: 200px"><%=header.getLifnrNm() %></td>
  </tr>
  <tr>
    <th>입고사업소</th>
    <td><%=header.getLifnr()%></td>
    <td><%=header.getName1()%></td>
    <th>납기일자</th>
    <td colspan="2"><% if (!StringUtils.isEmpty(header.getEindt())) { %><%=header.getEindt()%> <% } %></td>
  </tr>
</table>

<div style="margin: 15px"></div>

<div class="container">

  <table class="header-table">
      <tr>
        <th style="width: 60px">자재번호</th>
        <th style="width: 278px">자재명</th>
        <th style="width: 60px">주문수량</th>
        <th style="width: 86px">단가</th>
        <th style="width: 86px">금액</th>
        <th style="width: 82px">납품수량</th>
        <th style="width: 82px">LOT번호</th>
      </tr>
      <tr>
        <td><%=header.getMatnr()%></td>
        <td><%=header.getTxz01()%></td>
        <td style="text-align: right"><%=header.getMenge()%></td>
        <td style="text-align: right"><%=header.getNetpr()%></td>
        <td style="text-align: right"><%=header.getNetwr()%></td>
        <td style="text-align: right"><%=header.getZbpmng()%></td>
        <td style="text-align: right"><%=header.getPrueflog()%></td>
      </tr>
  </table>
  <form class="mproForm" id="saveForm"  action="/updateMproDetTransList" method="post" >

    <!-- 확정시 아이템을 저장하고 입력상태값을 업데이트 하기 위해 -->
    <input type="hidden" id="inputSt" name="inputSt" value="I" />
    <table class="detail-table">
      <tr>
        <th style="width: 120px">표준인식번호</th>
        <th style="width: 120px">제조사</th>
        <th style="width: 90px; background-color: #fff3cd">제조번호</th>
        <th style="width: 70px; background-color: #fff3cd" class="detail-input-th">
          생산일자<br>
          <button id="prddtAllIn" class="allinBtn" >일괄입력</button>
        </th>
        <th style="width: 120px; background-color: #fff3cd">
          생산공장<br>
          <button id="prdftAllIn" class="allinBtn" >일괄입력</button>
        </th>
        <th style="width: 120px; background-color: #fff3cd">
          제작자(성명)<br>
          <button id="prnamAllIn" class="allinBtn" >일괄입력</button>
        </th>
        <th style="width: 120px; background-color: #fff3cd">
          인도지시서번호<br>
          <button id="ebelnPoAllIn" class="allinBtn" >일괄입력</button>
        </th>
        <th style="width: 120px; background-color: #fff3cd">
          인도지시서품목<br>
          <button id="ebelpPoAllIn" class="allinBtn" >일괄입력</button>
        </th>
        <th style="width: 120px; background-color: #fff3cd">1차 부싱타입</th>
        <th style="width: 120px; background-color: #fff3cd">2차 부싱타입</th>
        <th style="width: 60px; background-color: #fff3cd">권선종류</th>
        <th style="width: 100px; background-color: #fff3cd">절연유 타입</th>
        <th style="width: 120px; background-color: #fff3cd">절연지<br> 내열온도(℃)</th>
        <th style="width: 80px; background-color: #fff3cd">
          유량(L)<br>
          <button id="atwrt00106AllIn" class="allinBtn" >일괄</button>
        </th>
        <th style="width: 80px; background-color: #fff3cd">
          무부하손(W)<br>
          <button id="atwrt00107AllIn" class="allinBtn" >일괄</button>
        </th>
        <th style="width: 80px; background-color: #fff3cd">
          부하손(W)<br>
          <button id="atwrt00108AllIn" class="allinBtn" >일괄</button>
        </th>
        <th style="width: 80px; background-color: #fff3cd">변압기 절연지 종류</th>
      </tr>
      <%
//        for (MproDetVO vo : detailList) {
        for (Iterator iter = detailList.iterator(); iter.hasNext();) {
          MproDetVO vo = (MproDetVO) iter.next();

      %>
      <tr>
        <input type="hidden" name="ebeln" value="<%= vo.getEbeln()%>" >
        <input type="hidden" name="lifnr" value="<%= vo.getLifnr()%>" >
        <input type="hidden" name="lifnrGr" value="<%= vo.getLifnrGr()%>" >
        <input type="hidden" name="ebelp" value="<%= vo.getEbelp()%>" >
        <input type="hidden" name="matsn" value="<%= vo.getMatsn()%>" >

        <td style="text-align: center; background-color: #f0f0f0" ><%= vo.getMatsn() %></td>
        <td style="text-align: center; background-color: #f0f0f0" ><%= vo.getLifnrGr() %></td>
        <td style="text-align: center">
          <input type="text" name="prdsn" size="20" maxlength="20" class="input-class"  value="<% if (!StringUtils.isEmpty(vo.getPrdsn())) { %><%=vo.getPrdsn()%><% } %>" >
        </td>
        <td style="text-align: center">
          <input type="text" name="prddt" size="8" maxlength="8" class="input-class-prddt" value="<% if (!StringUtils.isEmpty(vo.getPrddt())) { %><%=vo.getPrddt()%><% } %>" >
        </td>
        <td style="text-align: center">
          <input type="text" name="prdft" size="10" maxlength="10" class="input-class-prdft" value="<% if (!StringUtils.isEmpty(vo.getPrdft())) { %><%=vo.getPrdft()%><% } %>"  >
        </td>
        <td style="text-align: center">
          <input type="text" name="prnam" size="8" maxlength="5" class="input-class-prnam" value="<% if (!StringUtils.isEmpty(vo.getPrnam())) { %><%=vo.getPrnam()%><% } %>" >
        </td>
        <td style="text-align: center">
          <input type="text" name="ebelnPo" size="10" maxlength="10" class="input-class-ebelnPo" value="<% if (!StringUtils.isEmpty(vo.getEbelnPo())) { %><%=vo.getEbelnPo()%><% } %>" >
        </td>
        <td style="text-align: center">
          <input type="text" name="ebelpPo" size="10" maxlength="5" class="input-class-ebelpPo" value="<% if (!StringUtils.isEmpty(vo.getEbelpPo())) { %><%=vo.getEbelpPo()%><% } %>" >
        </td>
        <td style="text-align: center">
          <select name="atwrt00101" class="input-class">
            <option value="0"  selected >-- 선택 --</option>
            <option value="1" <% if (vo.getAtwrt00101().equals("1")) { %> selected  <%  } %>   >자기제</option>
            <option value="2" <% if (vo.getAtwrt00101().equals("2")) { %>  selected  <% } %>   >폴리머</option>
            <option value="3" <% if (vo.getAtwrt00101().equals("3")) { %>  selected  <% } %>   >에폭시</option>
          </select>
        </td>
        <td style="text-align: center" >
          <select name="atwrt00102" class="input-class">
            <option value="0" selected>-- 선택 --</option>
            <option value="1" <% if (vo.getAtwrt00102().equals("1")) { %> selected  <%  } %>   >자기제</option>
            <option value="2" <% if (vo.getAtwrt00102().equals("2")) { %>  selected  <% } %>   >폴리머</option>
            <option value="3" <% if (vo.getAtwrt00102().equals("3")) { %>  selected  <% } %>   >에폭시</option>
          </select>
        </td>
        <td style="text-align: center">
          <select name="atwrt00103" class="input-class">
            <option value="0" selected >-- 선택 --</option>
            <option value="1" <% if (vo.getAtwrt00103().equals("1")) { %> selected  <%  } %>   >Cu</option>
            <option value="2" <% if (vo.getAtwrt00103().equals("2")) { %>  selected  <% } %>   >AL</option>
          </select>
        </td>
        <td style="text-align: center">
          <select name="atwrt00104" class="input-class">
            <option value="0" selected >-- 선택 --</option>
            <option value="1" <% if (vo.getAtwrt00104().equals("1")) { %> selected  <%  } %>   >광유</option>
            <option value="2" <% if (vo.getAtwrt00104().equals("2")) { %>  selected  <% } %>   >실리콘유</option>
            <option value="3" <% if (vo.getAtwrt00104().equals("3")) { %>  selected  <% } %>   >식물유</option>
            <option value="4" <% if (vo.getAtwrt00104().equals("4")) { %>  selected  <% } %>   >난연유</option>
          </select>
        </td>
        <td style="text-align: center">
          <select name="atwrt00105" class="input-class">
            <option value="0" selected>-- 선택 --</option>
            <option value="1" <% if (vo.getAtwrt00105().equals("1")) { %> selected  <%  } %>   >90</option>
            <option value="2" <% if (vo.getAtwrt00105().equals("2")) { %>  selected  <% } %>   >105</option>
            <option value="3" <% if (vo.getAtwrt00105().equals("3")) { %>  selected  <% } %>   >120</option>
            <option value="4" <% if (vo.getAtwrt00105().equals("4")) { %>  selected  <% } %>   >130</option>
            <option value="5" <% if (vo.getAtwrt00105().equals("5")) { %>  selected  <% } %>   >155</option>
            <option value="6" <% if (vo.getAtwrt00105().equals("6")) { %>  selected  <% } %>   >180</option>
            <option value="7" <% if (vo.getAtwrt00105().equals("7")) { %>  selected  <% } %>   >180 이상</option>
          </select>
        </td>
        <td style="text-align: center">
          <input type="text" name="atwrt00106" size="3" maxlength="4" class="input-class-atwrt00106" value="<%= vo.getAtwrt00106()%>" >
        </td>
        <td style="text-align: center">
          <input type="text" name="atwrt00107" size="8" maxlength="4" class="input-class-atwrt00107" value="<%= vo.getAtwrt00107()%>" >
        </td>
        <td style="text-align: center">
          <input type="text" name="atwrt00108" size="6" maxlength="4" class="input-class-atwrt00108" value="<%= vo.getAtwrt00108()%>" >
        </td>
        <td style="text-align: center">
          <select name="atwrt00109" class="input-class">
            <option value="0" selected>-- 선택 --</option>
            <option value="1" <% if (vo.getAtwrt00109().equals("1")) { %> selected  <%  } %>   >Kraft</option>
            <option value="2" <% if (vo.getAtwrt00109().equals("2")) { %>  selected  <% } %>   >Diamond Kraft</option>
            <option value="3" <% if (vo.getAtwrt00109().equals("3")) { %>  selected  <% } %>   >D.K (Thermally upg..)</option>
            <option value="4" <% if (vo.getAtwrt00109().equals("4")) { %>  selected  <% } %>   >H종 노맥스지</option>
            <option value="5" <% if (vo.getAtwrt00109().equals("5")) { %>  selected  <% } %>   >기타</option>
          </select>
        </td>
      </tr>
<%
  }
%>
    </table>

    <div class="process">
      <button id="tempSaveBtn" type="submit" name="btnTempSave" >임시저장</button>
    </div>

  </form>

    <div class="confirmBtnArea">
      <button  id="confirmBtn"  >확정</button>
      <button  id="cancelBtn" >확정취소</button>
    </div>


</div>

<%
  session.setAttribute("transHeader", header);
  session.setAttribute("transItem", detailList);
%>

</body>
</html>
