
<%@include file="header.jsp" %>
<title>Selected Products</title>
<link rel="stylesheet" href="selectedProducts.css">
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
<br>
<br>
<div class="container">
    <h3 id="span1">Your selected products' info:</h3>

    <div class="row" >

        <c:forEach items="${selectedProducts}" var="selectedProduct">
            <div class="col-md-4" id="div1" data-aos="zoom-in-up"
                 data-aos-duration="3000" >
                <img src="${selectedProduct.getImgPath()}" class = "img_prod"  alt="productImage"/>
                <p id="p1"> <c:out value="${selectedProduct.getName()}"/> </p>
                <hr>
                <p id="p2"> ${selectedProduct.getActualPrice()}  </p>

                <br>
                <br>
            </div>
        </c:forEach>
    </div>

    <script>
        AOS.init();
    </script>
    <%@include file="footer.jsp" %>

