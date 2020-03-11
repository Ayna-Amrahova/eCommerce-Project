//$(document).ready(
//        function () {
//
//            $("#btn1").click(
//                    function () {
//                        var name = $("#input1").val();
//                        var email = $("#input2").val();
//                        var subject = $("#input3").val();
//                        var message = $("#input4").val();
//                        var data = {};
//                        data.name = name;
//                        data.email = email;
//                        data.subject = subject;
//                        data.message = message;
//                        $.ajax(
//                                {
//                                    "url": "/ContactServlet",
//                                    "method": "POST",
//                                    "data": data,
//                                    "success": function (check) {
//                                        if (!check.success) {
//                                            alert('Error!');
//                                        } else {
//                                            alert('Success!');
//                                        }
//                                        $("#input1").val("");
//                                        $("#input2").val("");
//                                        $("#input3").val("");
//                                        $("#input4").val("");
//                                    }
//
//                                }
//
//
//
//                        );
//                    }
//
//            );
//        }
//);