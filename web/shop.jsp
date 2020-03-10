<%@include file="header.jsp" %>
<div class="container">

    <div class="hr" id="hr1">
        <h3 class="hr-title" id="span1"> SHOP </h3>
    </div>

    <div  id="addProduct">

        <input type="text" name="name" value="" id="productName"/> Product name
        <hr>
        <input type="text" name="price" value="" id="productPrice"/> Price ($)
        <hr>
        <input type="submit" name="submit" value="Add product" id="submit"/> 

        <script>
            window.onscroll = function () {
                myFunction();
            };

            var header = document.getElementById("addProduct");
            var sticky = header.offsetTop;

            function myFunction() {
                if (window.pageYOffset > sticky) {
                    header.classList.add("sticky");
                } else {
                    header.classList.remove("sticky");
                }
            }
        </script>
    </div>


    <br>
    <br>
    <br>
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

    <div class="row">
        <div class="col-md-3" id="shopby">
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

        <c:forEach items="${products}" var="products">

            <div class="col-md-3" id="div1">
                <p class="label info" id="info1"><c:out value="${products.getInfo()}"/></p>
                <img src="${products.getImgPath()}" alt="palatka" class = "img_prod" id="${products.getId()}" />
                <p id="p1"> <c:out value="${products.getName()}"/> </p>
                <hr>
                <p id="p2"> <strike id="strike1"> <c:out value="${products.getPrice()}"/> </strike> &nbsp ${products.getActualPrice()} </p>

                <br>
                <br>
                <br>
                <br>
                <%-- <%! int var = 1;%>
                 <% if (var % 4 == 0) { %>
                 <br>
                 <% } else { %>
                 <p class="label info" id="info1"><c:out value="${products.getInfo()}"/></p>
                 <img src="${products.getImgPath()}" alt="palatka" class = "img_prod" id="${products.getId()}" />
                 <p id="p1"> <c:out value="${products.getName()}"/> </p>
                 <hr>
                 <p id="p2"> <strike id="strike1"> <c:out value="${products.getPrice()}"/> </strike> &nbsp ${products.getActualPrice()} </p>
                     <%}%>
                     <% var++;%>
                --%>
            </div>
        </c:forEach>
    </div>

</div>
<br>
<br>
<br>
<br>
<%@include file="footer.jsp" %>
