
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags always come first -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">

    <!-- Page title -->
    <title>Login</title>
    <!-- Vendor styles -->
    <link rel="stylesheet" href="http://vdcm-qvxp-framework.unix.gsm1900.org/global_ui_comps/assets/css/master.css">

    <link rel="stylesheet" href="css/wro.css"/>

</head>
<body class="tmo-login-bg">
<header class="header">
<nav class="navbar navbar-fixed-top">
    <div class="container-fluid tmo-container">
        <div class="tmo-clearfix">



        <button class="navbar-toggler hidden-lg-up pull-right" type="button" data-toggle="collapse" data-target="#exCollapsingNavbar2">
            &#9776;
        </button>
        <a class="navbar-brand logo" href="#"><img src="http://vdcm-qvxp-framework.unix.gsm1900.org/global_ui_comps/assets/img/T-logo-flame.jpg" alt="T-Mobile Flame" title="T-Mobile Flame"></a>

            <ul class="hidden-lg-up nav navbar-nav pull-xs-right glyph-menu">
                <li class="nav-item"><a class="nav-link" href="#"><i class="fa fa-search fa-2x"></i></a></li>
                <li class="nav-item"><a class="nav-link" href="#"><i class="fa fa-shopping-cart fa-2x fa-flip-horizontal"></i></a></li>
            </ul>

        </div>

        <div class="collapse navbar-toggleable-md clearfix" id="exCollapsingNavbar2">

        <ul class="nav navbar-nav nav-links pull-lg-right">
            <li class="nav-item dropdown login-link">
                <a class="nav-link user-login"  href="#" role="button" aria-haspopup="true" aria-expanded="false">
                    Login
                </a>
            </li>

        </ul>
        </div>
    </div><!-- /.container -->
</nav><!-- /.navbar -->
</header><!-- /.header -->

<div class="container-fluid">
    <div class="row">
        <div class="col-xs-12 col-sm-12">

            <!--login content -->
            <section id="login">
                <form class="form-signin tmo-floating-label" action="login" method="post">
                    <h1 class="form-signin-heading">Hi there!</h1>
                    
                    <#if RequestParameters['error']??>
					<div class="alert alert-danger">
						There was a problem logging in. Please try again.
					</div>
					</#if>

                        <fieldset class="form-group">
                            <input type="text" class="form-control" id="username" name="username">
                            <label for="username">Username</label>
                        </fieldset>
                        <fieldset class="form-group">
                            <input type="password" class="form-control" id="password" name="password" >
                            <label for="password">Password</label>
                        </fieldset>

                        <p class="tmo-forgetpassword"><a href="#">Forgot your password?</a></p>

					<input type="hidden" id="csrf_token" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                     
                      <button type="submit" class="btn btn-primary btn-block">Submit</button>

                </form>
                
                             
            </section>
        </div>
        <!--/ login content -->

    </div><!--/row-->

</div><!--/.container-->



<!-- Vendor scripts -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/js/bootstrap.min.js" integrity="sha384-vZ2WRJMwsjRMW/8U7i6PWi6AlO1L79snBrmgiDpgIWJ82z8eA5lenwvxbMV1PAh7" crossorigin="anonymous"></script>

<script type="text/javascript">

    $(".form-group input, .form-group textarea ").change(function() {
        if ($(this).val() != "") {
            $(this).addClass('filled');
        } else {
            $(this).removeClass('filled');
        }
    })

</script>


<script src="js/wro.js" type="text/javascript"></script>
</body>
</html>










