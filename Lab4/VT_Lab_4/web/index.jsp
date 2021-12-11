
<%@ page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<html>
<head>
  <title>Авторизация</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script src="resources/js/jquery-3.2.1.js"></script>
</head>
<body style="background-color: azure"; >

  <jsp:include page="jsp/block/sitenavbar.jsp"/>


  <div >
    <div>
      <div style="margin-left: 40%; margin-right: 40%">
        <form name="loginForm" method="POST" action="hotelsminsk" >
          <input type="hidden" name="command" value="login"/>
          <h3 style="margin-right: 3%" >${locale_authorization_header}:      </h3>
          <div >
            <label>${locale_authorization_label_login}:</label><br>
            <input type="text" name="login" value="" size="32" />
          </div>

          <div style="margin-top: 5px">
            <label>${locale_authorization_label_password}:</label><br>
            <input type="password" name="password" value="" size="32" />
          </div>
          <b style="color: red;">${errorLoginOrPassword}</b>
          <br />
          <div align="center">
            <input type="submit" value="${locale_authorization_btn}" />
          </div>
        </form>
      </div>
    </div>
  </div>
</body>
<%session.removeAttribute("errorLoginOrPassword");%>
</html>
