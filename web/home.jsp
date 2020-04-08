<title>Home</title>
<link rel="stylesheet" href="home.css">
<script src="home.js">
</script>
<%@include file="header.jsp" %>
<div class="container">

    <c:forEach items="${home}" var="home" >

        <div class="row" id="div1">

            <img src="${home.getImgPath()}" alt="" id="pic1">
            <div class="content1">
                <h2 id="h21">${home.getHeader()}</h2>
                <p id="p1">${home.getParagraph()}</p>
                </br>
                </br>
                <button type="button" class="btn" name="button" id="btn1"> ${home.getBtnInfo()} </button>
                </br>
                </br>
                </br>
                </br>
            </div>
        </div>

    </c:forEach>


    <div class="row" id="givingBack">
        <h2 id="h22">GIVING BACK</h2>
        <div class="row" id="give">
            <c:forEach items="${homeMiddle}" var="homeMiddle" >
                <div class="col-md-4" id="giving">
                    <div class="row">
                        <img src="${homeMiddle.getImgPath2()}" alt="elka" id="img4">
                        <p id="p4">${homeMiddle.getHeader2()}</p>
                        <p id="p5">${homeMiddle.getParagraph2()} </p>
                    </div>
                </div>
            </c:forEach>
        </div>
        <button type="button" class="btn" name="button" id="btn5" onclick="openPage('http://localhost:8080/MatrixProject/BlogServlet')"> Read More </button>
        </br>
        </br>
        </br>
        </br>
    </div>

    <div class="hr" id="hr1">
        <h3 class="hr-title" id="span1"> OUR BEST- SELLING EQUIPMENT </h3>
    </div>


    <!-- ////////////////////////////////////////////////////////////- -->

    <div class="row" id="div13">

        <div class="row" >
                <c:forEach items="${products}" var="product" >
                    <p class="label info" id="info1"><c:out value="${product.getInfo()}"/></p>
                    <img src="${product.getImgPath()}" alt="foto" id="work_id">
                    <p id="pp1"> <c:out value="${product.getName()}"/> </p>
                    <hr>
                    <p id="pp2"> <strike id="strike1"> <c:out value="${product.getPrice()}"/> </strike> &nbsp ${product.getActualPrice()} </p>

                </c:forEach>
            
        </div>
       
    </div>

    <button type="button" class="btn" name="button" id="btn6" onclick="openPage('http://localhost:8080/MatrixProject/ShopServlet')"> Shop All </button>

    <div class="hr" id="hr2">
        <p class="hr-title" id="span6">FOLLOW US #MADAGASCAR </p>
    </div>

    <div class="row" id="div12">

        <div class="class10">
            <div class="row">
                <c:forEach items="${homeFooter}" var="homeFooter" >
                    <img src="${homeFooter.getImgPath3()}" alt="" id="foto1">
                </c:forEach>
            </div>
        </div>

    </div>
    </br>
    </br>
    </br>
    <script type="text/javascript">
        function openPage(pageURL)
        {
            window.location.href = pageURL;
        }
    </script>

    <%@include file="footer.jsp" %>

</html>
