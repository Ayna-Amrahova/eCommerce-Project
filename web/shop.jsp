<%@include file="header.jsp" %>
<div class="container">


    <div class="hr" id="hr1">
        <h3 class="hr-title" id="span1"> SHOP </h3>
    </div>

    <input type="text" name="name" value="" id="productName"/> Product name
    <hr>
    <input type="text" name="price" value="" id="productPrice"/> Price ($)
    <hr>
    <input type="submit" name="submit" value="Add product" id="submit"/> 



    <div class="row" id="row1">
        <div class="shopby" id="shopby">
            <p id="shopBy">Shop by &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp  Sort by </p> 
            <hr>
            <div class="row" id="row3">
                <label for="categories">Choose a category:</label>
                &nbsp &nbsp &nbsp 
                <select class="category">
                    <c:forEach items="${category}" var="category">
                        <div class="row" id="foreach">
                            <div class = "col-md-4" id="foreach" >
                                <option value="${category.getId()}"><c:out value="${category.getCategoryName()}"/></option>

                                <script>
                                    $(document).ready(function () {
                                        $("select.category").change(function () {
                                            var categoryId = $(this).children("option:selected").val();

                                            $(window.location).attr('href', 'http://localhost:8080/MatrixProject/ShopServlet?categoryId=' + categoryId);
                                        });
                                    });

                                </script>

                            </div>
                        </div>
                    </c:forEach>
                </select>
                &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp 
                <hr>
                <div class="row" id="row5">
                    <label for="categories" id="shopBysorting">Choose a sorting:</label>
                    &nbsp &nbsp &nbsp 
                    <select class="sorting">
                        <div class="row" id="foreach">
                            <div class = "col-md-4" id="foreach" >
                                <option value="asc" id="sorting"> From cheap to expensive </option>
                                <option value="desc" id="sorting"> From expensive to cheap </option>
                                <script>
                                    $(document).ready(function () {
                                        $("select.sorting").change(function () {
                                            var sortBy = $(this).children("option:selected").val();
                                            $(window.location).attr('href', 'http://localhost:8080/MatrixProject/ShopServlet?sortBy=' + sortBy);
                                        });

                                        $("select.category").change(function () {
                                            var categoryId = $(this).children("option:selected").val();
                                            $("select.sorting").change(function () {
                                                var sortBy = $(this).children("option:selected").val();
                                                if (categoryId === null && sortBy === null) {
                                                    $(window.location).attr('href', 'http://localhost:8080/MatrixProject/ShopServlet');
                                                } else if (!(categoryId === null) && !(sortBy === null)) {
                                                    $(window.location).attr('href', 'http://localhost:8080/MatrixProject/ShopServlet?categoryId=' + categoryId + '&sortBy=' + sortBy);
                                                }

                                            });
                                        });
                                    });
                                </script>

                            </div>
                        </div>
                    </select>
                </div>


                <hr>
            </div>

            <hr>

        </div>

        <div class ="row">
            <c:forEach items="${products}" var="products">
                <div class="col-md-4" id="div1">

                    <p class="label info" id="info1"><c:out value="${products.getInfo()}"/></p>
                    <img src="${products.getImgPath()}" alt="palatka" class = "img_prod" id="${products.getId()}" />
                    <p id="p1"> <c:out value="${products.getName()}"/> </p>
                    <hr>
                    <p id="p2"> <strike id="strike1"> <c:out value="${products.getPrice()}"/> </strike> &nbsp ${products.getActualPrice()} </p>

                </div>
            </c:forEach>
        </div>

    </div>
    <br>
    <br>
    <br>
    <br>
    <%@include file="footer.jsp" %>
