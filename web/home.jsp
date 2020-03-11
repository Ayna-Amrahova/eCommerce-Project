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
                        <img src="${homeMiddle.getImgPath()}" alt="elka" id="img4">
                        <p id="p4">${homeMiddle.getHeader()}</p>
                        <p id="p5">${homeMiddle.getParagraph()} </p>
                    </div>
                </div>
            </c:forEach>
        </div>
        <button type="button" class="btn" name="button" id="btn5"> Read More </button>
        </br>
        </br>
        </br>
        </br>
    </div>

    <div class="hr" id="hr1">
        <h3 class="hr-title" id="span1"> OUR BEST- SELLING EQUIPMENT </h3>
    </div>


    <!-- ////////////////////////////////////////////////////////////- -->

    <p class="label info" id="info1">New Arrival</p>
    <p class="label info" id="info2">Sale</p>

    </br>
    <div class="row" id="div8">
        <div class="class6" id="class6">

            <span id="span2"> <img src="./img/kurtka.jpg" alt="kurtka" id="img7"> </span>
            <p id="p10"> I'm a product </p>
            <hr>
            <p id="p11"> $85.00 </p>
        </div>
        <!-- ////////////////////////////////////////////////////////////- -->
        <pre>   </pre>
        <div class="class7" id="div9">
            <span id="span3"> <img src="./img/matras.jpg" alt="matras" id="img8"></span>
            <p id="p12"> I'm a product </p>
            <hr>
            <p id="p13"> $45.00 </p>
        </div>
        <!-- ////////////////////////////////////////////////////////////- -->
        <pre>   </pre>
        <div class="class8" id="div10">

            <span id="span4"> <img src="./img/palatka.jpg" alt="palatka" id="img9"> </span>
            <p id="p14"> I'm a product </p>
            <hr>

            <p id="p15"> <strike id="strike1"> $120.00 </strike> &nbsp $102.00 </p>
        </div>
        <!-- ////////////////////////////////////////////////////////////- -->
        <pre>   </pre>
        <div class="class9" id="div11">
            <span id="span5"> <img src="./img/sumka.jpg" alt="sumka" id="img10"></span>
            <p id="p16"> I'm a product </p>
            <hr>
            <p id="p17"> $75.00 </p>
        </div>
        <button type="button" class="btn" name="button" id="btn6"> Shop All </button>

    </div>
    <div class="hr" id="hr2">
        <p class="hr-title" id="span6">FOLLOW US #MADAGASCAR </p>
    </div>

    <div class="row" id="div12">
        <div class="class10">
            <img src="./img/foto_1.jpg" alt="foto1" id="foto1">
        </div>
        <div class="class11">
            <img src="./img/foto_2.jpg" alt="foto2" id="foto2">
        </div>
        <div class="class12">
            <img src="./img/foto_3.jpg" alt="foto3" id="foto3">
        </div>
        <div class="class13">
            <img src="./img/foto_4.jpg" alt="foto4" id="foto4">
        </div>
    </div>
    </br>
    </br>
    </br>
    <%@include file="footer.jsp" %>
</html>
