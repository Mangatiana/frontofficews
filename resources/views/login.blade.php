<!DOCTYPE html>
<html>

<head>
  <!-- Basic -->
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <!-- Mobile Metas -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <!-- Site Metas -->
  <meta name="keywords" content="" />
  <meta name="description" content="site informations sur intelligence artificielle" />
  <meta name="author" content="" />

  <title>AI ETU1437</title>

  <!-- slider stylesheet -->
  <link rel="stylesheet" type="text/css"
    href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.1.3/assets/owl.carousel.min.css" />

  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="{{ secure_asset('assets/css/bootstrap.css') }}" />
  <!-- fonts style -->
  <link href="https://fonts.googleapis.com/css?family=Poppins:400,700|Roboto:400,700&display=swap" rel="stylesheet">
  <!-- Custom styles for this template -->
  <link href="{{ secure_asset('assets/css/style.css') }}" rel="stylesheet" />
  <!-- responsive style -->
  <link href="{{ secure_asset('assets/css/responsive.css') }}" rel="stylesheet" />
</head>

<body class="sub_page">
<div class="hero_area">
    <!-- header section strats -->
    <header class="header_section">
      <div class="container-fluid">
        <nav class="navbar navbar-expand-lg custom_nav-container ">
          <a class="navbar-brand" href="">
            <img src="{{ secure_asset('assets/images/logo.png') }}" alt="">
            <span>
              AI ETU1437
            </span>
          </a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>

          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <div class="d-flex mx-auto flex-column flex-lg-row align-items-center">
            </div>
            <div class="quote_btn-container  d-flex justify-content-center">
              <a href="">
                <img src="{{ secure_asset('assets/images/call.png') }}" alt="">
              </a>
              <a href="">
                <span>
                  @
                </span>
              </a>
            </div>
          </div>
        </nav>
      </div>
    </header>
    <!-- end header section -->
</div>

  <!-- contact section -->

  <section class="contact_section layout_padding">
    <div class="container">
      <div class="d-flex flex-column align-items-end">
        <div class="custom_heading-container">
          <hr>
          <h2>
            Login
          </h2>
        </div>
      </div>
      <div class="layout_padding-top layout_padding2-bottom">
        <div class="row">
          <div class="col-md-7">

            <form action="{{route('connecter')}}" method="post">
            @csrf
              <div class="contact_form-container">
                <div>
                  <div>
                    <input type="text" placeholder="User" name="user" value="momo">
                  </div>
                  <div class="">
                    <input type="text" placeholder="Mot de passe" name="mdp" value="1437">
                  </div>
                  <div class="mt-5">
                    <button type="submit">
                      Connecter
                    </button>
                  </div>
                </div>
              </div>
            </form>

          </div>
          <div class="col-md-5">

          </div>
        </div>
      </div>

    </div>
  </section>


  <!-- end contact section -->

  <!-- info section -->
  <section class="info_section layout_padding">
    <div class="container">
      <div class="info_social">
        <div>
          <a href="">
            <img src="images/fb.png" alt="">
          </a>
        </div>
        <div>
          <a href="">
            <img src="images/twitter.png" alt="">
          </a>
        </div>
        <div>
          <a href="">
            <img src="images/linkedin.png" alt="">
          </a>
        </div>
        <div>
          <a href="">
            <img src="images/insta.png" alt="">
          </a>
        </div>
      </div>
      <div>
        <p>
          RAJAONARIVONY Sombiniaina Morgan ETU1437
        </p>
      </div>
    </div>
  </section>

  <!-- end info_section -->



  <script type="text/javascript" src="{{secure_asset('assets/js/jquery-3.4.1.min.js')}}"></script>
  <script type="text/javascript" src="{{secure_asset('asset/js/bootstrap.js')}}"></script>

</body>
</body>

</html>
