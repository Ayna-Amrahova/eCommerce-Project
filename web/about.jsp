<%@include file="aboutHeader.jsp" %>
<div class="container">
    <div class="hr" id="hr1">
        <h3 class="hr-title" id="span1"> OUR STORY </h3>
    </div>
    <div class="row" id="div1">
        <c:forEach items="${about}" var="about" >
            <c:set var="id" value="${about.getId()}"/>
            <c:choose> 
                <c:when test="${id % 2 == 0}">
                    <img src="${about.getImgPath()}" alt="foto" id="img${about.getId()}">
                    <p id="p1"> <c:out value="${about.getParagraph()}"/> </p>
                </c:when>
                <c:otherwise>
                    <p id="p3"> <c:out value="${about.getParagraph()}"/> </p>
                    <img src="${about.getImgPath()}" alt="foto" id="img${about.getId()}">
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <br>
    </div>
    <br><br><br><br><br>
    <%@include file="footer.jsp" %>
    </html>
