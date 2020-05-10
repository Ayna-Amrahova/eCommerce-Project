<%@include file="aboutHeader.jsp" %>
<link rel="stylesheet" href="about.css">
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
<script src="about.js">
</script>
<title> About </title>
<div class="container">
    <div class="hr" id="hr1" data-aos="slide-down">
        <h3 class="hr-title" id="span1"> OUR STORY </h3>
    </div>

    <c:forEach items="${about}" var="about" >
        <c:set var="id" value="${about.getId()}"/>
        <c:choose> 
            <c:when test="${!(id % 2 == 0)}">
                <div class="row" id="div1" >
                    <div class="row" id="paragraph1" data-aos="fade-down"
                         data-aos-duration="3000">
                        <p id="p1"> <c:out value="${about.getParagraph()}"/> </p>
                    </div>

                    <div class="row" id="div2" data-aos="fade-up"
                         data-aos-duration="3000">
                        <img src="${about.getImgPath()}" alt="foto" id="img${about.getId()}" >
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <br>
                <br>
                <div class="row" id="div3" >
                    <div class="row" id="img2" data-aos="fade-right"
                         data-aos-duration="3000" >
                        <img src="${about.getImgPath()}" alt="foto" id="img${about.getId()}">
                    </div>

                    <div class="row" id="div4"  data-aos="fade-left"
                             data-aos-duration="3000">
                        <p id="p2"> GIVING BACK </p>
                        <div id="pp3" >
                            <p id="p3"> <c:out value="${about.getParagraph()}"/> </p>
                        </div>
                    </div>
                </div>
                <br>
                <br>
            </c:otherwise>
        </c:choose>
    </c:forEach> 

    <script>
        AOS.init({
            duration: 1200,
        })
    </script>
    <%@include file="footer.jsp" %>
</html>
