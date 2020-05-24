<title>Home</title>
<link rel="stylesheet" href="home.css">
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
<script src="home.js">
</script>
<%@include file="header.jsp" %>
<div class="container">
    <%!int counter = 0;%>
    <c:forEach items="${home}" var="home" >

        <div class="row" id="div1" data-aos="fade-up"
             data-aos-duration="3000" >

            <img src="${home.getImgPath()}" alt="" id="pic1" >
            <div class="content1">
                <h2 id="h21">${home.getHeader()}</h2>
                <p id="p1">${home.getParagraph()}</p>
                </br>
                </br>
                <% if (counter == 0) { %>
                <button type="button" class="btn" name="button" id="btn1" onclick="openPage('http://localhost:8080/MatrixProject/AboutServlet')"> ${home.getBtnInfo()} </button>
                <% } else if (counter == 1) { %>
                <button type="button" class="btn" name="button" id="btn1" onclick="openPage('http://localhost:8080/MatrixProject/ShopServlet?infoId=2')"> ${home.getBtnInfo()} </button>
                <% } else if (counter == 2) {%>
                <button type="button" class="btn" name="button" id="btn1" onclick="openPage('http://localhost:8080/MatrixProject/ShopServlet?infoId=1')"> ${home.getBtnInfo()} </button>
                <% } else if (counter == 3) {%>
                <button type="button" class="btn" name="button" id="btn1" onclick="openPage('http://localhost:8080/MatrixProject/ContactServlet')"> ${home.getBtnInfo()} </button>
                <% }
                %>
                </br>
                </br>
                </br>
                </br>
            </div>
            <%counter++;%>
            <% if (counter == 4) { %>
            <%counter = 0;%>
            <% }
            %>
        </div>
    </c:forEach>

    <div class="row" id="givingBack" data-aos="zoom-in"
         data-aos-duration="3000">
        <h2 id="h22">GIVING BACK</h2>
        <div class="row" id="give">
            <c:forEach items="${homeMiddle}" var="homeMiddle" >
                <div class="col-md-4" id="giving">
                    <div class="row">
                        <img src="${homeMiddle.getImgPath2()}" alt="" id="img4">
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
        <h3 class="hr-title" id="span1" data-aos="fade-right"
            data-aos-duration="3000"> OUR BEST- SELLING EQUIPMENT </h3>
    </div>


    <!-- ////////////////////////////////////////////////////////////- -->

    <div class="row" id="div13" data-aos="fade-left"
         data-aos-duration="3000">

        <div class="row" >
            <c:forEach items="${products}" var="product" >
                <p class="label info" id="info1"><c:out value="${product.getInfo()}"/></p>
                <img src="./img/${product.getImgPath()}" alt="foto" id="work_id">
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

    <div class="row" id="div12" data-aos="fade-down"
         data-aos-duration="3000">

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


    <button class="open-button" onclick="openForm()">Send your message</button>
    <div class="chat-popup" id="myForm">
        <form action="" class="form-container">
            <textarea placeholder="Type message..." name="msg" required></textarea>
            <button type="submit" class="btn">Send</button>
            <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
        </form>
    </div>

    <script>
        function openForm() {
            document.getElementById("myForm").style.display = "block";
        }
        function closeForm() {
            document.getElementById("myForm").style.display = "none";
        }
    </script>
    <script>
        AOS.init();
    </script>
    <%@include file="footer.jsp" %>

</html>
