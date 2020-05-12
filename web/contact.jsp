<title>Contact</title>
<link rel="stylesheet" href="contact.css">
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
<script src="contact.js">
</script>
<%@include file="header.jsp" %>

<div class="container">

    <div class="row" data-aos="fade-up"
         data-aos-duration="3000"  >
        <div class="class1" id="class1" >
            <p id="p1" > VISIT US </p>
        </div>
        <div class="class2" id="class2">
            <p id="p2"> Our Store </p>
            <br>
            <p id="p3">500 Terry Francois Street </p>
            <p id="p4">San Francisco, CA 94158 </p>
            <p id="p5">Tel: 123-456-7890 </p>
            <p id="p6">info@my-domain.com </p>
            <br>
            <br>
            <p id="map">
                View Map
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d50467.307610154305!2d-122.44189423283424!3d37.76175067159055!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x80859a6d00690021%3A0x4a501367f076adff!2sSan%20Francisco%2C%20CA%2C%20USA!5e0!3m2!1sen!2s!4v1583916632681!5m2!1sen!2s"
                        width="100%" height="400" frameborder="0" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
            </p>
        </div>

        <div class="class3" id="class3">
            <p id="p7"> Opening Hours </p>
            <br>
            <p id="p8">Mon - Fri: 7am - 10pm </p>
            <p id="p9">Saturday: 8am - 10pm </p>
            <p id="p10">Sunday: 8am - 11pm </p>
        </div>
    </div>

    <br>
    <br>
    <br>
    <div class="hr" id="hr1" data-aos="zoom-out-up"
         data-aos-duration="3000" >
        <h3 class="hr-title" id="span1"> CONTACT US</h3>
    </div>
    <p class="" id="span179" data-aos="zoom-in-up"
       data-aos-duration="3000"> Swing by for a cup of coffee, or leave us a message</p>
    <div id="div1" class="coffee" data-aos="zoom-in-up"
         data-aos-duration="3000">

        <img src="img/source.gif" alt="coffee" width="60px" height="60px"/>
    </div>

    <div class="col-md-6" id="inputs">
        <form action="/MatrixProject/ContactServlet" method="get">
            <input type="text" name="name" id="input1" placeholder="Name" required 
                   data-aos="zoom-out-left"
                   data-aos-duration="1500">
            <input type="text" name="email" id="input2" placeholder="Email" required
                   data-aos="zoom-out-right"
                   data-aos-duration="1500">
            <input type="text" name="subject" id="input3" placeholder="Subject" required
                   data-aos="zoom-out-left"
                   data-aos-duration="1500">
            <input type="text" name="message" id="input4" placeholder="Message" required
                   data-aos="zoom-out-right"
                   data-aos-duration="1500">
            <button type="submit" class="btn" name="button" id="btn1"
                    data-aos="zoom-out-left"
                    data-aos-duration="3000"> Send </button>
        </form>
    </div>

    <div class="hr" id="hr2" data-aos="fade-up"
         data-aos-duration="3000">
        <h3 class="hr-title" id="span2"> STOCKISTS </h3>
    </div>
    <div class="row" data-aos="fade-up"
         data-aos-duration="3000">
        <div class="class7" id="class7">
            <p id="p18"> EUROPE </p>
        </div>
        <div class="class8" id="class8">
            <p id="p19"> Store 01 </p>
            <br>
            <p id="p20">500 Terry Francois Street </p>
            <p id="p21">San Francisco, CA 94158 </p>
            <p id="p22">info@mysite.com </p>
            <p id="p23"> Tel: 123-456-7890</p>
        </div>

        <div class="class9" id="class9">
            <p id="p24"> Store 02 </p>
            <br>
            <p id="p25">500 Terry Francois Street </p>
            <p id="p26">San Francisco, CA 94158 </p>
            <p id="p27">info@mysite.com  </p>
            <p id="p28">Tel: 123-456-7890 </p>
        </div>

    </div>


    <div class="row" data-aos="fade-up"
         data-aos-duration="3000" >
        <div class="class10" id="class10">
            <p id="p29"> NORTH AMERICA </p>
        </div>
        <div class="class11" id="class11">
            <p id="p30"> Store 03 </p>
            <br>
            <p id="p31">500 Terry Francois Street </p>
            <p id="p32">San Francisco, CA 94158 </p>
            <p id="p33">info@mysite.com </p>
            <p id="p34">Tel: 123-456-7890 </p>
        </div>

        <div class="class12" id="class12">
            <p id="p35"> Store 04 </p>
            <br>
            <p id="p36">500 Terry Francois Street </p>
            <p id="p37">San Francisco, CA 94158 </p>
            <p id="p38">info@mysite.com </p>
            <p id="p39">Tel: 123-456-7890 </p>
        </div>

    </div>


    <div class="row" data-aos="fade-up"
         data-aos-duration="3000">
        <div class="class13" id="class13">
            <p id="p40"> ASIA </p>
        </div>
        <div class="class14" id="class14">
            <p id="p41"> Store 05 </p>
            <br>
            <p id="p42">500 Terry Francois Street </p>
            <p id="p43">San Francisco, CA 94158 </p>
            <p id="p44">info@mysite.com</p>
            <p id="p45">Tel: 123-456-7890</p>
        </div>

        <div class="class15" id="class15">
            <p id="p46"> Store 06 </p>
            <br>
            <p id="p47">500 Terry Francois Street </p>
            <p id="p48">San Francisco, CA 94158 </p>
            <p id="p49">info@mysite.com </p>
            <p id="p50">Tel: 123-456-7890 </p>
        </div>

    </div>


    <p id="karta">
        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d50467.307610154305!2d-122.44189423283424!3d37.76175067159055!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x80859a6d00690021%3A0x4a501367f076adff!2sSan%20Francisco%2C%20CA%2C%20USA!5e0!3m2!1sen!2s!4v1583916632681!5m2!1sen!2s"
                width="100%" height="400" frameborder="0" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
    </p>


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
