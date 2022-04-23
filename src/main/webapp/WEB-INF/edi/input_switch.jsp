<%@ page import="com.kdn.sbootweb.vo.MproMstVO" %>
<%@ page import="com.kdn.sbootweb.vo.MproDetVO" %>
<%@ page import="java.util.List" %>
<%@ page import="org.apache.commons.lang3.StringUtils" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

  <title>자재 생산정보 내역서(개폐기)</title>

  <%

    MproMstVO header = (MproMstVO)request.getAttribute("switchHeader");
    List<MproDetVO> detailList = (List<MproDetVO>)request.getAttribute("switchItem");

  %>

  <script src="static/js/jquery-3.6.0.min.js" type="text/javascript" ></script>
  <link rel="stylesheet" type="text/css" href="static/css/switch.css">


  <script type="text/javascript">
    $(document).ready(function(){

      var confirmCheck = "<%= header.getInputSt()%>";

      if (confirmCheck === 'C') {
        $(".input-class").attr("disabled", true);
        $(".input-class-prdft").attr("disabled", true);
        $(".input-class-prddt").attr("disabled", true);
        $(".input-class-prnam").attr("disabled", true);
        $(".input-class-ebelnPo").attr("disabled", true);
        $(".input-class-ebelpPo").attr("disabled", true);
        $(".input-class-atwrt00207").attr("disabled", true);
        $(".input-class-atwrt00208").attr("disabled", true);
        $(".input-class-atwrt00209").attr("disabled", true);
        $(".allinBtn").attr("disabled", true);
        $('.allinBtn').css({'color':'white', 'background-color':'darkgrey'});

        $('#tempSaveBtn').attr("disabled", true);
        $('#tempSaveBtn').css({'color':'white', 'background-color':'darkgrey'});
      }

      // process..
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
            $(".input-class").attr("disabled", true);
            $(".input-class-prdft").attr("disabled", true);
            $(".input-class-prddt").attr("disabled", true);
            $(".input-class-prnam").attr("disabled", true);
            $(".input-class-ebelnPo").attr("disabled", true);
            $(".input-class-ebelpPo").attr("disabled", true);
            $(".input-class-atwrt00207").attr("disabled", true);
            $(".input-class-atwrt00208").attr("disabled", true);
            $(".input-class-atwrt00209").attr("disabled", true);
            $(".allinBtn").attr("disabled", true);
            $('.allinBtn').css({'color':'white', 'background-color':'darkgrey'});

            $('#tempSaveBtn').attr("disabled", true);
            $('#tempSaveBtn').css({'color':'white', 'background-color':'darkgrey'});
            //alert("확정되어 전송 상태로 전환되었습니다. 확정취소하시면 다시 등록할 수 있습니다.");

            //입력상태값 초기화
            $("#inputSt").val('');


          },
          error: function(data) {
            alert("저장실패");
          }
        });
      });

      $('#cancelBtn').on("click", function(e){
        e.preventDefault();

        var url = "/confirmMproDetSwitchData?confirmData=false";
        $.ajax({
          type: "GET",
          url: url,
          success: function(data) {
            $(".input-class").attr("disabled", false);
            $(".input-class-prdft").attr("disabled", false);
            $(".input-class-prddt").attr("disabled", false);
            $(".input-class-prnam").attr("disabled", false);
            $(".input-class-ebelnPo").attr("disabled", false);
            $(".input-class-ebelpPo").attr("disabled", false);
            $(".input-class-atwrt00207").attr("disabled", false);
            $(".input-class-atwrt00208").attr("disabled", false);
            $(".input-class-atwrt00209").attr("disabled", false);
            $(".allinBtn").attr("disabled", true);
            $('.allinBtn').css({'color':'white', 'background-color':'#3b5998'});

            $('#tempSaveBtn').attr("disabled", false);
            $('#tempSaveBtn').css({'color':'white', 'background-color':'#3b5998'});

            //alert("확정되어 전송 상태로 전환되었습니다. 확정취소하시면 다시 등록할 수 있습니다.");

          },
          error: function(data) {
            alert("저장실패");
          }
        });
      });

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

      $("#prdftAllIn").on("click", function (e) {
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

      $("#atwrt00207AllIn").on("click", function (e) {
        e.preventDefault();
        var inVal = $('input[name=atwrt00207]').val();
        //alert("inVal:" + inVal);
        $(".input-class-atwrt00207").val(inVal);
      });

      $("#atwrt00208AllIn").on("click", function (e) {
        e.preventDefault();
        var inVal = $('input[name=atwrt00208]').val();
        //alert("inVal:" + inVal);
        $(".input-class-atwrt00208").val(inVal);
      });

      $("#atwrt00209AllIn").on("click", function (e) {
        e.preventDefault();
        var inVal = $('input[name=atwrt00209]').val();
        //alert("inVal:" + inVal);
        $(".input-class-atwrt00209").val(inVal);
      });


    });


  </script>

</head>

<body>
<h2 style="margin: 20px">개별관리 자재 생산정보 내역서(개폐기)</h2>

<table class="header-table">
  <tr>
    <th style="width: 60px">주문번호</th>
    <td><%= header.getEbeln()%></td>
    <td style="width: 200px"></td>
    <th style="width: 60px">주문일자</th>
    <td colspan="2"><%= header.getBedat()%></td>
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
    <td colspan="2"><%=header.getEindt()%></td>
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


<form class="mproForm" id="saveForm"  action="/updateMproDetSwitchList" method="post" >

  <!-- 확정시 아이템을 저장하고 입력상태값을 업데이트 하기 위해 -->
  <input type="hidden" id="inputSt" name="inputSt" value="I" />
  <table class="detail-table">
    <tr>
      <th style="width: 120px">표준인식번호</th>
      <th style="width: 80px">제조사</th>
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
      <th style="width: 100px; background-color: #fff3cd">정격전류(A)</th>
      <th style="width: 120px; background-color: #fff3cd">스위칭 매체</th>
      <th style="width: 60px; background-color: #fff3cd">절연매체</th>
      <th style="width: 100px; background-color: #fff3cd">매커니즘<br> 조작방식</th>
      <th style="width: 120px; background-color: #fff3cd">부싱타입(1차)</th>
      <th style="width: 80px; background-color: #fff3cd">부싱타입(2차)</th>
      <th style="width: 80px; background-color: #fff3cd">
        정격가스압력(Mpa)<br>
        <button id="atwrt00207AllIn" class="allinBtn" >일괄</button>
      </th>
      <th style="width: 80px; background-color: #fff3cd">
        최저보증<br> 가스압력(Mpa)<br>
        <button id="atwrt00708AllIn" class="allinBtn" >일괄</button>
      </th>
      <th style="width: 80px; background-color: #fff3cd">
        가스량<br>
        <button id="atwrt00209AllIn" class="allinBtn" >일괄</button>
      </th>
    </tr>
    <%
      for (MproDetVO vo : detailList) {
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
        <input type="text" name="prddt" size="8" maxlength="8" class="input-class-prddt" value="<% if (!StringUtils.isEmpty(vo.getPrdsn())) { %><%=vo.getPrddt()%><% } %>" >
      </td>
      <td style="text-align: center">
        <input type="text" name="prdft" size="10" maxlength="10" class="input-class-prdft" value="<% if (!StringUtils.isEmpty(vo.getPrdft())) { %><%=vo.getPrdft()%><% } %>"  >
      </td>
      <td style="text-align: center">
        <input type="text" name="prnam" size="6" maxlength="5" class="input-class-prnam" value="<% if (!StringUtils.isEmpty(vo.getPrnam())) { %><%=vo.getPrnam()%><% } %>" >
      </td>
      <td style="text-align: center">
        <input type="text" name="ebelnPo" size="10" maxlength="10" class="input-class-ebelnPo" value="<% if (!StringUtils.isEmpty(vo.getEbelnPo())) { %><%=vo.getEbelnPo()%><% } %>" >
      </td>
      <td style="text-align: center">
        <input type="text" name="ebelpPo" size="5" maxlength="5" class="input-class-ebelpPo" value="<% if (!StringUtils.isEmpty(vo.getEbelpPo())) { %><%=vo.getEbelpPo()%><% } %>" >
      </td>
      <td style="text-align: center">
        <select name="atwrt00201" class="input-class">
          <option value="0" selected>-- 선택 --</option>
          <option value="1" <% if (vo.getAtwrt00201().equals("1")) { %> selected  <%  } %>   >400</option>
          <option value="2" <% if (vo.getAtwrt00201().equals("2")) { %>  selected  <% } %>   >600</option>
          <option value="3" <% if (vo.getAtwrt00201().equals("3")) { %>  selected  <% } %>   >630</option>
        </select>
      </td>
      <td style="text-align: center">
        <select name="atwrt00202" class="input-class">
          <option value="0" selected>-- 선택 --</option>
          <option value="1" <% if (vo.getAtwrt00202().equals("1")) { %> selected  <%  } %>   >SF6</option>
          <option value="2" <% if (vo.getAtwrt00202().equals("2")) { %>  selected  <% } %>   >Vacuum</option>
          <option value="3" <% if (vo.getAtwrt00202().equals("3")) { %>  selected  <% } %>   >Oil</option>
          <option value="4" <% if (vo.getAtwrt00202().equals("4")) { %>  selected  <% } %>   >기타</option>
        </select>
      </td>
      <td style="text-align: center">
        <select name="atwrt00203" class="input-class">
          <option value="0" selected>-- 선택 --</option>
          <option value="1" <% if (vo.getAtwrt00203().equals("1")) { %> selected  <%  } %>   >SF6</option>
          <option value="2" <% if (vo.getAtwrt00203().equals("2")) { %>  selected  <% } %>   >Vacuum</option>
          <option value="3" <% if (vo.getAtwrt00203().equals("3")) { %>  selected  <% } %>   >Oil</option>
          <option value="4" <% if (vo.getAtwrt00203().equals("4")) { %>  selected  <% } %>   >기타</option>
        </select>
      </td>
      <td style="text-align: center">
        <select name="atwrt00204" class="input-class">
          <option value="0" selected>-- 선택 --</option>
          <option value="1" <% if (vo.getAtwrt00204().equals("1")) { %> selected  <%  } %>   >Spring</option>
          <option value="2" <% if (vo.getAtwrt00204().equals("2")) { %>  selected  <% } %>   >Magnetic</option>
          <option value="3" <% if (vo.getAtwrt00204().equals("3")) { %>  selected  <% } %>   >기타</option>
        </select>
      </td>
      <td style="text-align: center">
        <select name="atwrt00205" class="input-class">
          <option value="0" selected>-- 선택 --</option>
          <option value="1" <% if (vo.getAtwrt00205().equals("1")) { %> selected  <%  } %>   >자기제</option>
          <option value="2" <% if (vo.getAtwrt00205().equals("2")) { %>  selected  <% } %>   >폴리머</option>
          <option value="3" <% if (vo.getAtwrt00205().equals("3")) { %>  selected  <% } %>   >에폭시</option>
        </select>
      </td>
      <td style="text-align: center">
        <select name="atwrt00206" class="input-class">
          <option value="0" selected>-- 선택 --</option>
          <option value="1" <% if (vo.getAtwrt00206().equals("1")) { %> selected  <%  } %>   >자기제</option>
          <option value="2" <% if (vo.getAtwrt00206().equals("2")) { %>  selected  <% } %>   >폴리머</option>
          <option value="3" <% if (vo.getAtwrt00206().equals("3")) { %>  selected  <% } %>   >에폭시</option>
        </select>
      </td>
      <td style="text-align: center">
        <input type="text" name="atwrt00207" size="6" maxlength="6" class="input-class-atwrt00207" value="<%= vo.getAtwrt00207()%>" >
      </td>
      <td style="text-align: center;" >
        <input type="text" name="atwrt00208" size="6" maxlength="6" class="input-class-atwrt00208" value="<%= vo.getAtwrt00208()%>" >
      </td>
      <td style="text-align: center;">
        <input type="text" name="atwrt00209" size="6" maxlength="6" class="input-class-atwrt00209" value="<%= vo.getAtwrt00209()%>" >
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
  session.setAttribute("switchHeader", header);
  session.setAttribute("switchItem", detailList);
%>

</body>
</html>
