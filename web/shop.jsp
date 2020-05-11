<%@include file="shopHeader.jsp" %>
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
<link rel="stylesheet" href="shop.css">
<script src="shop.js">
</script>

<div id="id1" class="odal">
    <div class="col-md-3">
        <form class="modal-content animate"  method="post">
            <div class="imgcontainer">
                <span onclick="document.getElementById('id1').style.display = 'none'" class="close" title="Close Modal">&times;</span>

            </div>

            <div class="container">
                <input type="text" placeholder="Product Name" id="productName" required/> 

                <input type="text" placeholder="Price ($)" id="productPrice" required/> 

                <button type="submit" id="login">Add Product</button>

            </div>


        </form>
    </div>
</div>




<div class="container">



    <div class="row" id="row5">
        <label  id="shopBysorting">Choose a sorting:</label>
        &nbsp &nbsp &nbsp 
        <select class="sorting">
            <div class="row" id="foreach">
                <div class = "col-md-4" id="foreach" >
                    <option selected="" id="sorting"> Select an option</option>
                    <option value="asc"  id="sorting" > From cheap to expensive </option>
                    <option value="desc" id="sorting"> From expensive to cheap </option>
                    <script>
                        $(document).ready(function () {
                            $("select.sorting").change(function () {
                                var sortBy = $(this).children("option:selected").val();
                                $(window.location).attr('href', 'http://localhost:8080/MatrixProject/ShopServlet?sortBy=' + sortBy);
                            });
                        });
                    </script>
                </div>
            </div>
        </select>
    </div>

    <div class="menu" id="shopby">
        <p id="shopBy">Shop by </p>
        <hr>
        <c:forEach items="${category}" var="category">
            <ul class="categories"> 
                <li id="${category.getId()}"><c:out value="${category.getCategoryName()}"/></li>
            </ul>
            <script>
                $(document).ready(function () {
                    $("#${category.getId()}").click(function () {
                        var categoryId = $(this).attr("id");
                        if (categoryId != 4) {
                            $(window.location).attr('href', 'http://localhost:8080/MatrixProject/ShopServlet?categoryId=' + categoryId);
                        } else {
                            $(window.location).attr('href', 'http://localhost:8080/MatrixProject/ShopServlet');
                        }
                    });
                });



            </script>
        </c:forEach>
    </div>
    <div class="content" id="">
        <div class="row" >


            <c:forEach items="${products}" var="products">

                <div class="col-md-4" id="div1" data-aos="zoom-in-up"
                     data-aos-duration="3000" >
                    <p class="label info" id="info1"><c:out value="${products.getInfo()}"/></p>
                    <img src="${products.getImgPath()}" alt="palatka" class = "img_prod" id="${products.getId()}" onclick="document.getElementById('id1').style.display = 'block'"/>
                    <p id="name_${products.getId()}" class="p1"> <c:out value="${products.getName()}"/> </p>
                    <hr>
                    <p id="p2" class="p2"> <strike id="strike1"> 
                        <c:out value="${products.getPrice()}"/> 
                    </strike> &nbsp
                    <span id="price_${products.getId()}">
                        ${products.getActualPrice()} 
                    </span>
                    </p>
                    <br>
                    <br>
                </div>
            </c:forEach>
        </div
    </div>
</div>
<br>
<br>
<br>
<br>

<script>

    $(".img_prod").click(
            function () {
                var id = $(this).attr("id");
                var prod_name = $.trim($("#name_" + id).html());
                var prod_price = $.trim($("#price_" + id).html());
                        $(#"productName").val(prod_name);
                        $(#"productPrice").val(prod_price);
            }
    );

    // Get the modal
    var odal = document.getElementById('id1');

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function (event) {
        if (event.target === odal) {
            odal.style.display = "none";
        }
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
