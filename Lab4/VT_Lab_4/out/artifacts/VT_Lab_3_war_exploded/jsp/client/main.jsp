
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Client page</title>
    <script src="../../resources/js/jquery-3.2.1.js"></script>
</head>
<body style="background-color: azure">

    <jsp:include page="../block/sitenavbar.jsp"/>
    <div style="margin-left: 42%">
        <h2 >${locale_client_table_header} </h2>
    </div>
    <div >
        <div >
            <div style="margin-left: 33%">
                <table >
                    <thead>
                        <tr style="background-color: bisque">
                            <th style="width: 130px; height: 40px">${locale_client_table_hotelname}</th>
                            <th style="width: 130px; height: 40px">${locale_client_table_hotelcount}</th>
                            <th style="width: 130px; height: 40px">${locale_client_table_reservationform}</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${hotelList}" var="item">
                            <tr>
                                <td>${item.name}</td>
                                <td align="center">${item.placesCount}</td>
                                <td align="center">
                                    <form action="/hotelsminsk" >
                                        <input type="text" name="hotelid" value="${item.id}" hidden="hidden"/>
                                        <input type="text" name="reservedplacescount" />
                                        <input type="text" name="command" hidden="hidden" value="reservehotel"/>
                                        <button type="submit" style="margin-top: 15px">${locale_client_table_btnreserve}  </button>
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
    <div >
        <div >
            <div >
                <div align="center">
                    <h3 >${locale_client_reservedtabel_header} </h3>
                </div>
            </div>
        </div>
    </div>

    <div >
        <div >
            <div style="margin-left: 37%">
                <table >
                    <thead>
                        <tr>
                            <th >${locale_client_reservedtabel_hotelname}</th>
                            <th >${locale_client_reservedtabel_hotelcount}</th>
                            <th >${locale_client_reservedtabel_cancelreservationform}</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestList}" var="item">
                            <tr>
                                <td>${item.hotelName}</td>
                                <td>${item.placesCount}</td>
                                <td>
                                    <form action="/hotelsminsk" >
                                        <%--<span>${item.hotelName} Reserved places count: ${item.placesCount}</span>--%>
                                        <input type="text" name="command" hidden="hidden" value="cancelreservation"/>
                                        <input type="text" name="requestid" hidden="hidden" value="${item.id}"/>
                                        <input type="text" name="placescount" hidden="hidden" value="${item.placesCount}"/>
                                        <input type="text" name="hotelid" value="${item.hotelId}" hidden="hidden"/>
                                        <button type="submit" >${locale_client_reservedtabel_btncancelreservation} </button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>




</body>
</html>
