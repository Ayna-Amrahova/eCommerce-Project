<%@include file="header.jsp" %>
<link rel="stylesheet" href="blog.css">
<script src="blog.js">
</script>
<title> Blog </title>
<div class="container">
    <div class="hr" id="hr1">
        <h3 class="hr-title" id="span1"> BLOG </h3>
    </div>

    <div class="row" id="row1">
        <div class="allposts">
            <p id="allPosts"> All Posts </p>
        </div>
        <div class="searchicon">
            <button type="submit" id="submit1" > <img src="./img/search.png" alt="search_icon" id="search_icon"> </button>
        </div>
        
       

        
    </div>


    <div class="row" id="rows">
        <div class="column1" id="column1">
            <img src="./img/blogFoto_1.jpg" alt="blogFoto_1" id="blogFoto1">
            <div id="content1">
                <p id="admin1"> <img src="./img/user.jpg" alt="user" id="user"> Admin </p>
                <p id="date1">Jan 8 &middot 2min</p>
                <h5 id="spot"> The world's most stunning camping <br> spots </h5>
                <p id="text1"> Create a blog post subtitle that summarizes your post in a <br> few short, punchy sentences and entices your audience to <br>
                    continue reading. Welcome to your blog post. Use this... </p>
                <hr>
                <p id="view1"> 23 views &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp  Write a comment
                    <button type="submit" id="submit3" > <img src="./img/heart.jpg" alt="heart" id="heart1"> </button> </p>
            </div>

            <div class="column3" id="column3">
                <img src="./img/blogFoto_3.jpg" alt="blogFoto_3" id="blogFoto3">
                <div id="content3">
                    <p id="admin3"> <img src="./img/user.jpg" alt="user" id="user3"> Admin </p>
                    <p id="date3">Jan 8 &middot 2min</p>
                    <h5 id="himalaya"> Trekking in the Himalayas </h5>
                    <p id="text3"> Create a blog post subtitle that summarizes your post in a <br> few short, punchy sentences and entices your audience to <br>
                        continue reading. Welcome to your blog post. Use this... </p>
                    <hr>
                    <p id="view3"> 9 views &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp  Write a comment
                        <button type="submit" id="submit5" > <img src="./img/heart.jpg" alt="heart" id="heart3"> </button> </p>
                </div>
            </div>
        </div>


        <div class="column2" id="column2">
            <img src="./img/blogFoto_2.jpg" alt="blogFoto_2" id="blogFoto2">
            <div id="content2">
                <p id="admin2"> <img src="./img/user.jpg" alt="user" id="user2"> Admin </p>
                <p id="date2">Jan 8 &middot 1min</p>
                <h5 id="boots"> How to choose the best hiking boots? <br> Our expert's advise </h5>
                <p id="text2"> Create a blog post subtitle that summarizes your post in a <br> few short, punchy sentences and entices your audience to <br>
                    continue reading. Welcome to your blog post. Use this... </p>
                <hr>
                <p id="view2"> 17 views &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp  Write a comment
                    <button type="submit" id="submit4" > <img src="./img/heart.jpg" alt="heart" id="heart2"> </button> </p>

            </div>
        </div>

        <div class="column4" id="column4">
            <img src="./img/blogFoto_4.jpg" alt="blogFoto_4" id="blogFoto4">
            <div id="content4">
                <p id="admin4"> <img src="./img/user.jpg" alt="user" id="user4"> Admin </p>
                <p id="date4">Jan 8 &middot 1min</p>
                <h5 id="train"> 15 most scenic train rides </h5>
                <p id="text4"> Create a blog post subtitle that summarizes your post in a <br> few short, punchy sentences and entices your audience to <br>
                    continue reading. Welcome to your blog post. Use this... </p>
                <hr>
                <p id="view4"> 13 views &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp  Write a comment
                    <button type="submit" id="submit6" > <img src="./img/heart.jpg" alt="heart" id="heart4"> </button> </p>
            </div>
        </div>

    </div>
    <%@include file="footer.jsp" %>
</html>
