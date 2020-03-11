<%-- 
    Document   : createAccount.jsp
    Created on : Jan 12, 2020, 7:37:57 AM
    Author     : rnovak
--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Account</title>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/gradebook.css"/>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-lg-10 col-xl-9 mx-auto">
                    <div class="card card-signin flex-row my-5">
                        <div class="card-img-left d-none d-md-flex">
                            <!-- Background image for card set in CSS! -->
                        </div>
                        <div class="card-body">
                            <h5 class="card-title text-center">Register</h5>
                            <form class="form-signin" action="">
                                <div class="form-label-group">
                                    <input type="text" id="inputUserame" class="form-control" placeholder="Username" required autofocus name="username" />
                                    <label for="inputUserame">Username</label>
                                </div>

                                <div class="form-label-group">
                                    <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required name="email">
                                    <label for="inputEmail">Email address</label>
                                </div>

                                <hr>

                                <div class="form-label-group">
                                    <input type="password" id="inputPassword" class="form-control" placeholder="Password" required name="password">
                                    <label for="inputPassword">Password</label>
                                </div>

                                <div class="form-label-group">
                                    <input type="password" id="inputConfirmPassword" class="form-control" placeholder="Password" required>
                                    <label for="inputConfirmPassword">Confirm password</label>
                                </div>

                                <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Register</button>
                                <a class="d-block text-center mt-2 small" href="SignIn">Sign In</a>
                                <hr class="my-4">
                                <script>
                                    $(document).ready(function () {
                                        var values;
                                        $('form').submit(function (e) {
                                            e.preventDefault();
                                            values = $(this).serialize();
                                            $.ajax({
                                                url: "CreateAccount",
                                                type: "post",
                                                data: values,
                                                success: function (response) {
                                                    alert('Form submitted successfully...');
                                                    console.log(JSON.stringify(response));
                                                    var json = JSON.parse(JSON.stringify(response));
                                                    console.log('Message: ' + json.message);
                                                    $('#message').text(json.message);
                                                },
                                                error: function (jqXHR, textStatus, errorThrown) {
                                                    console.log(jqXHR);
                                                }
                                            });
                                        })
                                    });
                                </script>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
