
<script>
    $(document).ready(
            funtion(){
        $(".img_prod").click(
        function(){
        var id = $(this).attr("id");
                var prod_name = $.trim($("#name_" + id).html());
                var prod_price = $.trim($("#price_" + id).html());
                $(#"productName").val(prod_name);
                $(#"productPrice").val(prod_price);
            }
    );
    }
    );
</script>