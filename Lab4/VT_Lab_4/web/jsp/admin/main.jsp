
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin page</title>
    <script src="../../resources/js/jquery-3.2.1.js"></script>
</head>
<body style="background-color: azure">

    <jsp:include page="../block/sitenavbar.jsp"/>

    <div style="margin-left: 42%">
        <h2>${locale_admin_table_header} </h2>
    </div>
    <div >
        <div >
            <div style="margin-left: 37%">
                <table >
                    <thead>
                    <tr style="background-color: bisque">
                        <th style="width: 130px; height: 40px">${locale_admin_table_hotelname}</th>
                        <th style="width: 130px; height: 40px">${locale_admin_table_hotelcount}</th>
                        <th style="width: 130px; height: 40px">${locale_admin_table_deleteform}</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${hotelList}" var="item">
                            <tr>
                                <td>${item.name}</td>
                                <td align="center">${item.placesCount}</td>
                                <td align="center">
                                    <form action="/hotelsminsk">
                                        <input type="text" name="hotelid" value="${item.id}" hidden="hidden"/>
                                        <input type="text" name="command" value="deletehotel" hidden="hidden"/>
                                        <button type="submit" style="margin-top: 15px">${locale_admin_table_btndelete}  </button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <br/>
    <hr/>
    <div align="center">
            <h3  style="text-decoration: underline;">${locale_admin_registration_header}</h3>
    </div>
    <div >
        <div >
            <div style="margin-left: 44%">
                <form action="/hotelsminsk">
                    <div >
                        <label>${locale_admin_registration_label_hotelname}:</label><br>
                        <input type="text" name="hotelname" />
                    </div>
                    <div >
                        <label>${locale_admin_registration_label_hotelcount}:</label><br>
                        <input type="text" name="placescount" />
                    </div>
                    <input type="text" name="command" value="addhotel" hidden="hidden"/>
                    <button style="margin-top: 5px" type="submit" >${locale_admin_registration_btnadd}  </button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
