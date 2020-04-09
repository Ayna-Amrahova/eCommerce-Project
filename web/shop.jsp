<%@include file="shopHeader.jsp" %>
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


<script>


    // Get the modal
    var odal = document.getElementById('id1');


    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function (event) {
        if (event.target === odal) {
            odal.style.display = "none";
        }
    }
</script>


<div class="container">


    <div class="hr" id="hr1">
        <h3 class="hr-title" id="span1"> SHOP </h3>
    </div>

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
        <div class="row">
            <c:forEach items="${products}" var="products">

                <div class="col-md-4" id="div1">
                    <p class="label info" id="info1"><c:out value="${products.getInfo()}"/></p>
                    <img src="${products.getImgPath()}" alt="palatka" class = "img_prod" id="${products.getId()}" onclick="document.getElementById('id1').style.display = 'block'" style="width:auto;" id="login" />
                    <p id="p1"> <c:out value="${products.getName()}"/> </p>
                    <hr>
                    <p id="p2"> <strike id="strike1"> <c:out value="${products.getPrice()}"/> </strike> &nbsp ${products.getActualPrice()} </p>

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
<%@include file="footer.jsp" %>
