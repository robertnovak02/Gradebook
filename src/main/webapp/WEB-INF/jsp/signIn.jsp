<%-- 
    Document   : login.jsp
    Created on : Jan 12, 2020, 7:38:11 AM
    Author     : rnovak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign In</title>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
        <link rel = "stylesheet" href="${pageContext.request.contextPath}/resources/css/gradebook.css"/>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
                    <div class="card card-signin my-5">
                        <div class="card-body">
                            <h5 class="card-title text-center">Sign In</h5>
                            <form class="form-signin" action="SignIn" method="POST">
                                <div class="form-label-group">
                                    <input type="text" id="userNameInput" name="userName" class="form-control" placeholder="User Name" required autofocus>
                                    <label for="userNameInput">User Name</label>
                                </div>

                                <div class="form-label-group">
                                    <input type="password" id="passwordInput" name="password" class="form-control" placeholder="Password" required>
                                    <label for="passwordInput">Password</label>
                                </div>

                                <input class="btn btn-lg btn-primary btn-block text-uppercase" type = "submit" value = "Sign In" />
                                <hr class="my-4">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
