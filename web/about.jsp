<%@include file="aboutHeader.jsp" %>
<div class="container">
    <div class="hr" id="hr1">
        <h3 class="hr-title" id="span1"> OUR STORY </h3>
    </div>

    <c:forEach items="${about}" var="about" >
        <c:set var="id" value="${about.getId()}"/>
        <c:choose> 
            <c:when test="${!(id % 2 == 0)}">
                <div class="row" id="div1">
                    <div class="row" id="paragraph1">
                        <p id="p1"> <c:out value="${about.getParagraph()}"/> </p>
                    </div>

                    <div class="row" id="div2">
                        <img src="${about.getImgPath()}" alt="foto" id="img${about.getId()}">
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <br>
                <br>
                <div class="row" id="div3">
                    <div class="row" id="img2">
                        <img src="${about.getImgPath()}" alt="foto" id="img${about.getId()}">
                    </div>

                    <div class="row" id="div4">
                        <p id="p2"> GIVING BACK </p>
                        <p id="p3"> <c:out value="${about.getParagraph()}"/> </p>
                    </div>
                </div>
                <br>
                <br>
            </c:otherwise>
        </c:choose>
    </c:forEach> 
    <br>
    <br><br><br><br><br>
    <%@include file="footer.jsp" %>
    </html>
