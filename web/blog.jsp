<%@include file="header.jsp" %>
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
<link rel="stylesheet" href="blog.css">
<script src="blog.js">
</script>
<title> Blog </title>
<div class="container">
    <div class="hr" id="hr1">
        <h3 class="hr-title" id="span1" data-aos="zoom-in"
            data-aos-duration="3000"> BLOG </h3>
    </div>


    <div class="content" id="">
        <div class="row" >
            <c:forEach items="${blog}" var="blog" >

                <div class="col-md-6" id="div${blog.getId()}" data-aos="fade-up"
                     data-aos-duration="3000" >
                    <img src="${blog.getImgPath()}" alt="blogFoto" id="blogFoto${blog.getId()}" >

                    <h5 id="header${blog.getId()}"> ${blog.getHeader()} </h5>
                    <p id="text${blog.getId()}">${blog.getText()}  </p>

                    <button class="comment" id="comment${blog.getId()}" onclick="openCmn()">${blog.getBtnInfo()}</button>


                </div>
            </c:forEach>
            <div class="cmnt" id="form">
                <form class="comment-container" method="POST">
                    <textarea placeholder="Type comment..." name="comment" id="comment" required></textarea>
                    <button type="submit" id="bttn">Send</button>
                    <button type="button" class="bttn cancel" onclick="closeCmn()">Close</button>
                </form>
            </div>
            <script>

                $(document).ready(
                        function () {

                            $("#bttn").click(
                                    function () {
                                        var comment = $("#comment").val();
                                        var data = {};
                                        data.comment = comment;
                                        alert(comment);
                                        $.ajax(
                                                {
                                                    "url": "/BlogServlet",
                                                    "method": "post",
                                                    "data": data,
                                                    "success": function (check) {
                                                        if (!check.success) {
                                                            alert('Error!');
                                                        } else {
                                                            alert('Success!');
                                                        }

                                                    }

                                                }

                                        );

                                    }

                            );
//                            $("#comment").val("");
                        }
                );
                function openCmn() {
                    document.getElementById("form").style.display = "block";
                }
                function closeCmn() {
                    document.getElementById("form").style.display = "none";
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
        </div>
    </div>
</div>

<script>
    AOS.init();
</script>

<%@include file="footer.jsp" %>
</html>
