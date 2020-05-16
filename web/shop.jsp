<%@include file="shopHeader.jsp" %>
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
<link rel="stylesheet" href="shop.css">
<script src="shop.js">
</script>
<script
    src="https://code.jquery.com/jquery-3.4.1.min.js"
    integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
crossorigin="anonymous"></script>





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
                    <img src="${products.getImgPath()}" alt="palatka" class = "img_prod" id="${products.getId()}"
                         onclick="document.getElementById('id1').style.display = 'block'"/>

                    <p hidden id="img_${products.getId()}" class="p1" name="productImage"> ${products.getImgPath()} </p> 
                    <p id="prodImg"></p>
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
                <div id="id1" class="odal">
                    <div class="col-md-4">
                        <form class="modal-content animate"  method="post">
                            <div class="imgcontainer">
                                <span onclick="document.getElementById('id1').style.display = 'none'" 
                                      class="close" title="Close Modal">&times;</span>

                            </div>

                            <div class="container">
                                <input type="text" placeholder="Product Name" id="productName" name="productName" required/> 

                                <input type="text" placeholder="Price ($)" id="productPrice" name="productPrice" required/> 
                                
                                <input  type="hidden" placeholder="Price ($)" id="productImage" name="productImage" required/> 

                                <button type="submit" id="addProduct">Add Product</button>

                            </div>

                        </form>
                    </div>
                </div>

            </c:forEach>
            <script>
                $(document).ready(function () {
                    $(".img_prod").click(function () {
                        var id = $(this).attr("id");
                        var prod_name = $.trim($("#name_" + id).html());
                        var prod_price = $.trim($("#price_" + id).html());
                        var prod_img = $.trim($("#img_" + id).html());
                        $("#productImage").val(prod_img);
                        $("#productName").val(prod_name);
                        $("#productPrice").val(prod_price);



                    }
                    );
                }

                );

                $("#addProduct").click(function ( ) {
                    var name = $("#productName").val();
                    var price = $("#productPrice").val();
                    var img = $("#productImage").val();
                    alert(img);
                    var data = {};
                    data.name = name;
                    data.price = price;
                    data.img = img;

                    $.ajax(
                            {
                                "url": "/ShopServlet",
                                "method": "POST",
                                "data": data,
                                "success": function (check) {
                                    if (!check.success) {
                                        alert('Error!');
                                    } else {
                                        alert('Success!');
                                    }
                                    $("#productName").val("");
                                    $("#productPrice").val("");
                                    $("#prodImg").val("");

                                }

                            }

                    );
                }




                )

                var odal = document.getElementById('id1');

                window.onclick = function (event) {
                    if (event.target === odal) {
                        odal.style.display = "none";
                    }
                }
            </script>
        </div
    </div>
</div>
<br>
<br>
<br>
<br>


<script>

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
