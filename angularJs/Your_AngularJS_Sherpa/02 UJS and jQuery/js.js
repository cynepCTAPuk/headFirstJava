$('#your-name').bind('input', function () {
    var name = $(this).val();
    // now you can use "name" here
    $('#output').html("Hello " + name);
});
