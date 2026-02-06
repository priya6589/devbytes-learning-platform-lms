$(function () {

    /* LOGIN FORM */

    const loginForm = $("#loginForm");
    loginForm.validate({
        errorElement: "div",
        errorClass: "invalid-feedback",
        highlight: function (element) {
            $(element).addClass("is-invalid");
        },
        unhighlight: function (element) {
            $(element).removeClass("is-invalid");
        },
        errorPlacement: function (error, element) {
            error.insertAfter(element);
        },
        rules: {
            email: {
                required: true,
                email: true
            },

            password: {
                required: true,
                minlength: 6
            }
        },
        messages: {
            email: {
                required: "Email is required",
                email: "Please enter a valid email"
            },

            password: {
                required: "Password is required",
                minlength: "Minimum 6 characters"
            }
        },

        submitHandler: function(form){
            form.submit();
        }

    });



    /* REGISTER FORM */
    const form = $("#registerForm");
    form.validate({
    errorElement:"div",
    errorClass:"invalid-feedback",

    highlight:function(el){
    $(el).addClass("is-invalid");
    },

    unhighlight:function(el){
    $(el).removeClass("is-invalid");
    },

    rules:{
    fullName:{required:true},
    email:{required:true,email:true},
    password:{required:true,minlength:6},
    mobileNumber:{required:true,digits:true,minlength:10},
    city:{required:true},
    qualification:{required:true}
    },

    messages:{
    fullName:"Full name required",
    email:"Valid email required",
    password:"Minimum 6 characters",
    mobileNumber:"Valid mobile required",
    city:"City required",
    qualification:"Qualification required"
    }

    });

//    /* STEP 1 → STEP 2 */
$("#nextStep").click(function(){
    // trigger validation for visible fields
    const step1Fields = $(".form-step.active :input");
    step1Fields.each(function(){
        form.validate().element(this);
    });
    // check if step1 is valid
    if(step1Fields.valid()){
        $(".form-step").removeClass("active");
        $(".form-step").eq(1).addClass("active");
        $("#formProgress").animate({ width:"100%" },300);
    }

});

$("#prevStep").click(function(){
    $(".form-step").removeClass("active");
    $(".form-step").eq(0).addClass("active");
    $("#formProgress").animate({ width:"50%" },300);

});

});
