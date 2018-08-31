<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
    WAR로 묶어서 배포해야 JSP 렌더링이 됨.. IntelliJ에서 잘 안되는것 같다 (embed-tomcat-jasper가 잘 작동안하는듯)
    다른 톰캣 서비스 띄워놓고 어찌 하다보면 잘될때가 있는데 이유를 모르겠음..
--%>
<html>
<head>
    <title>Title</title>
    <c:set var="time"><%=System.currentTimeMillis()%></c:set>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="Content-Script-Type" content="text/javascript" />
    <meta http-equiv="X-UA-Compatible" content="IE=EDGE" />
    <meta http-equiv="Expires" content="-1">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="No-Cache">
</head>
<script   src="https://code.jquery.com/jquery-3.3.1.js"   integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="   crossorigin="anonymous"></script>
<script>
 $(document).ready(function() {

     $("#goH2Database").on("click", function(ev){
         ev.preventDefault();
         goH2Database();
     })

     $("#goFrontEnd").on("click", function(ev){
         ev.preventDefault();
         goFrontEnd();
     })

     $("#queryDslBtn").on("click", function(ev){
         ev.preventDefault();
         getListByQueryDSL();
     });

     $("#jpaBtn").on("click", function(ev){
         ev.preventDefault();
         getListByJPA();
     });


     $("#mybatisBtn").on("click", function(ev){
         ev.preventDefault();
         getListByMybatis();
     });

     $("#testJMSBtn").on("click", function(ev){
         ev.preventDefault();
         getListToTestJMS();
     })

     $("#sendMsgInbound").on("click", function(ev){
        ev.preventDefault();
        sendMsgInbound();
     });
 });

 function goH2Database () {
     window.open("/console/", "_blank");
 }

 function goFrontEnd () {
     window.open("http://localhost:3000", "_blank");
 }

 function getListByQueryDSL() {
     var param = {
         testParamA : '11111'
     };

     $.ajax({
         url : "/restdemo1"
         ,async : true
         ,type : "POST"
         ,data : JSON.stringify(param)
         ,contentType: "application/json; charset=utf-8"
         ,dataType : "json"
         ,success : function(jsonData, status){
             var data = jsonData
             if("undefined"!=data && null !=data){
                 alert(JSON.stringify(data));
             }else{
             }

         }
         ,error : function(xhr, status, errName){
         }
     });
 }

 function getListByJPA() {
     var param = {
         testParamA : '11111'
     };
     $.ajax({
         url : "/restdemo2"
         ,async : true
         ,type : "POST"
         ,data : JSON.stringify(param)
         ,contentType: "application/json; charset=utf-8"
         ,dataType : "json"
         ,success : function(jsonData, status){
             var data = jsonData
             if("undefined"!=data && null !=data){
                 alert(JSON.stringify(data));
             }else{
             }

         }
         ,error : function(xhr, status, errName){
         }
     });
 }

 function getListByMybatis() {
     var param = {
         testParamA : '11111'
     };
     $.ajax({
         url : "/restmybatis1"
         ,async : true
         ,type : "POST"
         ,data : JSON.stringify(param)
         ,contentType: "application/json; charset=utf-8"
         ,dataType : "json"
         ,success : function(jsonData, status){
             var data = jsonData
             if("undefined"!=data && null !=data){
                 alert(JSON.stringify(data));
             }else{
             }

         }
         ,error : function(xhr, status, errName){
         }
     });
 }

 function getListToTestJMS() {
     var param = {
         testParamA : '11111'
     };
     $.ajax({
         url : "/getListToTestJMS"
         ,async : true
         ,type : "POST"
         ,data : JSON.stringify(param)
         ,contentType: "application/json; charset=utf-8"
         ,dataType : "json"
         ,success : function(jsonData, status){
             var data = jsonData
             if("undefined"!=data && null !=data){
                 alert("JMS 전송상태는 서버 콘솔을 확인해보자~여기까지 찍혔으면 일단 관련 기능 호출자체는 성공");
                 alert(JSON.stringify(data));
             }else{
             }

         }
         ,error : function(xhr, status, errName){
         }
     });
 }

 function sendMsgInbound() {
     var param = {
         testParamA : '11111'
     };
     $.ajax({
         url : "/sendMsgInbound"
         ,async : true
         ,type : "POST"
         ,data : JSON.stringify(param)
         ,contentType: "application/json; charset=utf-8"
         ,dataType : "json"
         ,success : function(jsonData, status){
             var data = jsonData
             if("undefined"!=data && null !=data){
                 alert("인바운드 호출 완료");
                 alert(JSON.stringify(data));
             }else{
             }

         }
         ,error : function(xhr, status, errName){
         }
     });
 }
</script>
<%--<body style="background: url('<c:url value="/img/2037.png"/>') no-repeat fixed 70% 25%/25% 50%;"> --%>
<body>
<div style="float:left;width:100%;margin-top:15px;">
        <span style="vertical-align:middle;line-height:30px;padding:10px;">
            <img src="<c:url value="/img/2037.png" />" width="30px" height="30px" />
            <img src="<c:url value="/img/2037.jpg" />" width="30px" height="30px" /><br><br>
        </span>
</div>
<div style="float:left;width:100%;">
    <div style="float:left;width:90%;margin:0 4% 0 4%;outline:2px solid #ccc;padding:15px;">
        예제 환경 : Spring Boot 2.0.1.RELEASE(with Spring 5), JDK 1.8, JPA, QueryDSL, Mybatis 3, Embedded Tomcat, JSP, Gradle
        <br>
        <br>
        C태그 테스트 : [[[[[${testmsg}]]]]]   <--- 괄호 사이 메시지가 안나오면 인식 못한것임
        <br>
        <br>
        (H2SqlDbConfig클래스에 설정되있음)<br><br>
        H2 DB 콘솔이동 : <button id="goH2Database">이동</button>
        <br>
        <br>
        FrontEnd 서버 페이지로 이동(React) : <button id="goFrontEnd">이동</button>
        <br>
        <br>
        ===============================================================<br><br>
        QueryDSL 호출 테스트 : <button id="queryDslBtn">호출</button>
        <br>
        <br>
        JPA 호출 테스트 : <button id="jpaBtn">호출</button>
        <br>
        <br>
        Mybatis 호출 테스트 : <button id="mybatisBtn">호출</button>
        <br>
        <br>
        ==============================================================
        <br>
        <br>
        JMS 호출 테스트(Ountbound(Adaptor - Router - Connector) : <button id="testJMSBtn">호출</button>
        <br>
        <br>
        JMS 호출 테스트(Connector -> Inbound Router -> Inbound Adaptor) : <button id="sendMsgInbound">호출</button>
        <br>
        <br>
        ===============================================================
    </div>
</div>
</body>
</html>
