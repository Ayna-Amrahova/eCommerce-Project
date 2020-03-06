$(document).ready(
        function () {
//            $(".img_prod").click(
//                    function () {
//                        var productName;
//                        var productPrice;
//                        productName = $("#1").text();
//                        productPrice = $("#2").text();
//                        $("#productName").val(productName);
//                        $("#productPrice").val(productPrice);
//                        alert('You add the product to the basket');
//                    }
//            );
//            $("#1").click(
//                    function () {
//                        var productName;
//                        var productPrice;
//                        productName = $("#p1").text();
//                        productPrice = $("#p2").text();
//                        $("#productName").val(productName);
//                        $("#productPrice").val(productPrice);
//                        alert('#1 clicked');
//                    }
//            );
//            $("#2").click(
//                    function () {
//                        var productName;
//                        var productPrice;
//                        productName = $("#p1").text();
//                        productPrice = $("#p2").text();
//                        $("#productName").val(productName);
//                        $("#productPrice").val(productPrice);
//                        alert('#2 clicked');
//                    }
//            );
            $("#img2").click(
                    function () {
                        $("#productName").val("Red tent");
                        $("#productPrice").val("106.25");
                        alert('You add the 2nd product');
                    }
            )

            $("#img3").click(
                    function () {
                        $("#productName").val("Blue tent");
                        $("#productPrice").val("114.75");
                        alert('You add the 3rd product');
                    }
            )

            $("#img4").click(
                    function () {
                        $("#productName").val("Green tent");
                        $("#productPrice").val("119");
                        alert('You add the 4th product');
                    }
            )


            $("#img5").click(
                    function () {
                        $("#productName").val("Grey tent");
                        $("#productPrice").val("148.75");
                        alert('You add the 5th product');
                    }
            )


            $("#img6").click(
                    function () {
                        $("#productName").val("Orange tent");
                        $("#productPrice").val("80.75");
                        alert('You add the 6th product');
                    }
            )


            $("#img7").click(
                    function () {
                        $("#productName").val("Blue jacket");
                        $("#productPrice").val("85");
                        alert('You add the 7th product');
                    }
            )


            $("#img8").click(
                    function () {
                        $("#productName").val("Green jacket");
                        $("#productPrice").val("115");
                        alert('You add the 8th product');
                    }
            )


            $("#img9").click(
                    function () {
                        $("#productName").val("Light green jacket");
                        $("#productPrice").val("145");
                        alert('You add the 9th product');
                    }
            )


            $("#img10").click(
                    function () {
                        $("#productName").val("Purple jacket");
                        $("#productPrice").val("60");
                        alert('You add the 10th product');
                    }
            )


            $("#img11").click(
                    function () {
                        $("#productName").val("Black jacket");
                        $("#productPrice").val("45");
                        alert('You add the 11th product');
                    }
            )


            $("#img12").click(
                    function () {
                        $("#productName").val("Dark blue jacket");
                        $("#productPrice").val("55");
                        alert('You add the 12th product');
                    }
            )


            $("#img13").click(
                    function () {
                        $("#productName").val("Blue bag");
                        $("#productPrice").val("75");
                        alert('You add the 13th product');
                    }
            )


            $("#img14").click(
                    function () {
                        $("#productName").val("Sky blue bag");
                        $("#productPrice").val("45");
                        alert('You add the 14th product');
                    }
            )


            $("#img15").click(
                    function () {
                        $("#productName").val("Red bag");
                        $("#productPrice").val("65");
                        alert('You add the 15th product');
                    }
            )


            $("#img16").click(
                    function () {
                        $("#productName").val("Big blue bag");
                        $("#productPrice").val("35");
                        alert('You add the 16th product');
                    }
            )


            $("#img17").click(
                    function () {
                        $("#productName").val("Big grey bag");
                        $("#productPrice").val("95");
                        alert('You add the 17th product');
                    }
            )


            $("#img18").click(
                    function () {
                        $("#productName").val("Big green bag");
                        $("#productPrice").val("60");
                        alert('You add the 18th product');
                    }
            )

            $("#submit").click(
                    function () {
                        var name = $("#productName").val();
                        var price = $("#productPrice").val();
                        var data = {};
                        data.name = name;
                        data.price = price;
                        $.ajax(
                                {
                                    "url": ".\ShopServlet",
                                    "method": "POST",
                                    "data": data,
                                    "success": function (check) {
                                        if (!check.success) {
                                            alert('Error!');
                                        } else {
                                            alert('Success!');
                                        }
                                        $("#name").val("");
                                        $("#price").val("");
                                    }

                                }

                        );
                    }

            );
        }
);
