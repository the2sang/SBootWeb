<%@ page import="com.kdn.sbootweb.vo.MproMstVO" %>
<%@ page import="com.kdn.sbootweb.vo.MproDetVO" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

  <title>자재 생산정보 내역서(개폐기)</title>

  <style>

    body {
      padding-left: 15px;
    }

    .header-table {
      border: 1px solid black;
      border-collapse: collapse;
      margin: 3px;
      padding: 5px;
    }

    .header-table th, td {
      border:1px solid black;
      text-align: left;
      padding: 6px;
      margin-top: 5px;
      margin-bottom: 5px;
      font-size: 12px;
    }

    .header-table th {
      background-color: #b6d4fe ;
      text-align: center;
    }

    .header-table td {
      background-color: #f0f0f0;
    }

    .detail-table {
      border: 1px solid black;
      border-collapse: collapse;
      margin: 3px;
    }

    .detail-table th, td {
      border:1px solid black;
      text-align: left;
      padding: 6px;
      margin-top: 5px;
      margin-bottom: 5px;
      font-size: 12px;
    }

    .detail-table th {
      background-color: #b6d4fe ;
      text-align: center;
    }

    h2 {
      padding-bottom: 20px;
      text-align: center;
    }

    .input-class {
      font-size: 12px;
      text-align: center;
    }

    button {
      all:unset;
      background-color: steelblue;
      color: white;
      padding: 5px 20px;
      border-radius: 5px;
      cursor: pointer;
      font-size: 12px;
    }

    button:hover {
      background-color: #06357a;
      color: #f0f0f0;

    }

    .process {
      float: right;
      margin: 5px;
    }

    .confirm {
      float: right;
      margin: 5px;
    }

  </style>

  <script type="text/javascript">

    function confirmMproData(check) {
      location.href = "/confirmMproDetData?confirmData=" + check;
    }


  </script>

</head>

<body>
<h2 style="margin: 20px">개별관리 자재 생산정보 내역서(개폐기)</h2>

<%

  MproMstVO header = (MproMstVO)request.getAttribute("mproMstVO");
  List<MproDetVO> detailList = (List<MproDetVO>)request.getAttribute("mproDetVOList");

%>




<table class="header-table">
  <tr>
    <th style="width: 60px">주문번호</th>
    <td>4100100208</td>
    <td style="width: 200px">blank</td>
    <th style="width: 60px">주문일자</th>
    <td colspan="2">2021.02.01</td>
  </tr>
  <tr>
    <th>납품업체</th>
    <td>blank</td>
    <td>blank</td>
    <th>계약업체</th>
    <td>1188200345</td>
    <td style="width: 200px">한국전기공업협동조합</td>
  </tr>
  <tr>
    <th>입고사업소</th>
    <td>8***</td>
    <td>경인권 물류센터</td>
    <th>납기일자</th>
    <td colspan="2">2021.02.20</td>
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
  </tr>
  <tr>
    <td>${mproMstVO.matnr}</td>
    <td>${mproMstVO.txz01}</td>
    <td style="text-align: right">${mproMstVO.menge}</td>
    <td style="text-align: right">${mproMstVO.netpr}</td>
    <td style="text-align: right">${mproMstVO.netwr}</td>
    <td style="text-align: right">${mproMstVO.zbpmng}</td>
  </tr>
</table>


<form class="mproForm"  action="/updateMproDetList" method="post" >
<table class="detail-table">
  <tr>
    <th style="width: 120px">표준인식번호</th>
    <th style="width: 80px">검사 LOT번호</th>
    <th style="width: 90px; background-color: #fff3cd">제조번호</th>
    <th style="width: 70px; background-color: #fff3cd" class="detail-input-th">생산일자</th>
    <th style="width: 120px; background-color: #fff3cd">제조사</th>
    <th style="width: 120px; background-color: #fff3cd">생산공장</th>
    <th style="width: 100px; background-color: #fff3cd">정격전류(A)</th>
    <th style="width: 120px; background-color: #fff3cd">스위칭 매체</th>
    <th style="width: 60px; background-color: #fff3cd">절연매체</th>
    <th style="width: 100px; background-color: #fff3cd">매커니즘<br> 조작방식</th>
    <th style="width: 120px; background-color: #fff3cd">부싱타입(1차)</th>
    <th style="width: 80px; background-color: #fff3cd">부싱타입(2차)</th>
    <th style="width: 80px; background-color: #fff3cd">정격가스압력(Mpa)</th>
    <th style="width: 80px; background-color: #fff3cd">최저보증<br> 가스압력(Mpa)</th>
    <th style="width: 80px; background-color: #fff3cd">가스량</th>
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
    <input type="hidden" name="werks" value="<%= vo.getWerks()%>" >
    <input type="hidden" name="eindt" value="<%= vo.getEindt()%>" >
    <input type="hidden" name="prdft" value="<%= vo.getPrdft()%>" >
    <input type="hidden" name="prnam" value="<%= vo.getPrnam()%>" >

    <td style="text-align: center; background-color: #f0f0f0" ><%= vo.getMatsn() %></td>
    <td style="text-align: center; background-color: #f0f0f0">10000646998</td>
    <td style="text-align: center">
      <input type="text" name="" size="12" maxlength="12" class="input-class" value="202008220023" >
    </td>
    <td style="text-align: center">
      <input type="text" name="prdsn" size="12" class="input-class"  value="<%= vo.getPrdsn() %>" >
    </td>
    <td style="text-align: center">
      <input type="text" name="prddt" size="8" class="input-class" value="<%= vo.getPrddt() %>" >
    </td>
    <td style="text-align: center">
      <input type="text" name="" size="10" maxlength="10" class="input-class" value="부산공장" >
    </td>
    <td style="text-align: center">
      <input type="text" name="" size="8" maxlength="14" class="input-class" value="400" >
    </td>
    <td style="text-align: center">
      <input type="text" name="" size="10" maxlength="14" class="input-class" value="Vacuum" >
    </td>
    <td style="text-align: center">
      <input type="text" name="" size="10" maxlength="14" class="input-class" value="Epoxy" >
    </td>
    <td style="text-align: center">
      <input type="text" name="" size="10" maxlength="14" class="input-class" value="magnetic" >
    </td>
    <td style="text-align: center">
      <input type="text" name="" size="14" maxlength="14" class="input-class" value="Kraft" >
    </td>
    <td style="text-align: center">
      <input type="text" name="" size="14" maxlength="14" class="input-class" value="신영중전기" >
    </td>
    <td style="text-align: center">
      <input type="text" name="" size="14" maxlength="14" class="input-class" value="" >
    </td>
    <td style="text-align: center">
      <input type="text" name="" size="10" maxlength="14" class="input-class" value="" >
    </td>
    <td style="text-align: center">
      <input type="text" name="" size="10" maxlength="14" class="input-class" value="" >
    </td>
  </tr>
  <%
    }
  %>

</table>

  <div class="process">
    <button type="submit" name="btnTempSave" >임시저장</button>
  </div>

</form>

<button onclick="confirmMproData('confirm');"  >확정</button>
<button onclick="confirmMproData('cancel');"  >확정취소</button>

</div>

<%
  session.setAttribute("mproMstVO", header);
  session.setAttribute("mproDetVOList", detailList);
%>

</body>
</html>
