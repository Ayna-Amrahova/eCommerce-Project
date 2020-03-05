<%@include file="header.jsp" %>
<br>
<br>
<div class="container">
    <h3>Your selected products' info:</h3>
    <table border="5" width="500">
        <tr>
            <td width="168"><b>ID</b></td>
            <td width="168"><b> Name</b></td>
            <td width="168"><b> Actual Price</b></td>
        </tr>
        <%Iterator iter;%>
        <% List selectedProducts = (List) request.getAttribute("selectedProducts");
            for (iter = selectedProducts.iterator(); iter.hasNext();) {
        %>
        <tr>
            <td width="168"><%=iter.next()%></td>
            <td width="168"><%=iter.next()%></td>
            <td width="168"><%=iter.next()%></td>
        </tr>
        <%}%>
    </table>
    <%--<c:forEach items="${selectedProducts}" var="selectedProduct">
        <div class="row" >
            <div class = "col-md-4" id="foreach" >
                <p id="p1"> <c:out value="${selectedProduct.getName()}"/> </p>
                <hr>
                <p id="p2"> ${selectedProduct.getActualPrice()}  </p>
            </div>

                </div>
            </c:forEach>--%>
    <%@include file="footer.jsp" %>
</div>

</body>
</html>
