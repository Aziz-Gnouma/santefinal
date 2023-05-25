jQuery(function ($) {

	'use strict';


    // -------------------------------------------------------------
    //  	Offcanvas Menu
    // -------------------------------------------------------------

        (function () {
            var menutoggle = $(".menu-toggle");
            var offcanvasmenu = $("#offcanvas-menu");
            var closemenu = $(".close-menu");

            menutoggle.on("click" ,function(){
                offcanvasmenu.addClass("toggled");
                return false;
            });

            closemenu.on("click" ,function() {
                offcanvasmenu.removeClass("toggled");
                return false;
            });
        }());



    // -------------------------------------------------------------
    //      Single-Page-Menu-Scrolling  Easy Plugin
    // -------------------------------------------------------------

        $(function() {
            $('a.page-scroll').on('click', function(event) {
                var $anchor = $(this);
                $('html, body').stop().animate({
                    scrollTop: $($anchor.attr('href')).offset().top
                }, 1500, 'easeInOutExpo');
                event.preventDefault();
            });
        });


    // -------------------------------------------------------------
    //      Sub-menu
    // -------------------------------------------------------------
        if ( $('.dropmenu').length) {
            $('.dropmenu').on("click" ,function(){
                $(this).parent().find('ul').slideToggle();
                return false;
            });
        }



    // -------------------------------------------------------------
    //      Burger Menu
    // -------------------------------------------------------------

        (function () {
            var menuSearch = $(".menu-search");
            var openMenu = $(".open-menu");
            var burgerMenu = $("#burger-menu");
            var closeMenu = $(".close-menu");

            openMenu.on("click" ,function(){
                menuSearch.addClass("action");
                burgerMenu.addClass("active");
                return false;
            });

            closeMenu.on("click" ,function() {
                menuSearch.removeClass("action");
                burgerMenu.removeClass("active");
                return false;
            });
        }());



    // -------------------------------------------------------------
    //      Search Bar
    // -------------------------------------------------------------

        (function () {
            var openbar = $(".open-bar");
            var searchbar = $("#search-bar");
            var closebar = $(".close-bar");
            var arrow = $(".arrow");

            openbar.on("click" ,function(){
                searchbar.addClass("active");
                arrow.addClass("active");
                return false;
            });

            closebar.on("click" ,function() {
                searchbar.removeClass("active");
                arrow.removeClass("active");
                return false;
            });
        }());



    

    // -------------------------------------------------------------
    //      LightBox-Js
    // -------------------------------------------------------------

        if ($('#lightBox').length) {
            $('#lightBox').poptrox({
                usePopupCaption: true,
                usePopupNav: true,
                popupPadding: 0
            });
        }



    // -------------------------------------------------------------
    //      Background-Color-change
    // -------------------------------------------------------------

        function colorChangeAnimation() {
            var section = $(".review-section");
            var home = $(".homePageOne");
            var about = $(".aboutPage");
            // var nextSection = section.next();
            var top = section.offset().top;
            
            if ($(window).scrollTop() >= top && $(window).innerWidth() > 992) {
                section.addClass("active-bg");
                home.addClass("active-bg");
                about.addClass("active-bg");
            }
            else {
                section.removeClass("active-bg");
                home.removeClass("active-bg");
                about.removeClass("active-bg");
            }  
        }




    // -------------------------------------------------------------
    //      Single-item-Parallax
    // -------------------------------------------------------------

        function bgParallax() {
            if ($(".section-caption").length) {
                $(".section-caption").each(function() {
                    var height = $(this).position().top;
                    var resize     = height - $(window).scrollTop();
                    var doParallax = -(resize/5);
                    var positionValue   = doParallax + "px";
                    var img = $(this).data("bg-image");

                    $(this).css({
                        backgroundImage: "url(" + img + ")",
                        backgroundPosition: "50%" + positionValue,
                    });
                });
            }
        }




    // ------------------------------------------------------------------
    //      Revulation Slider
    // ------------------------------------------------------------------

        if ($('.tp-banner').length) {
            $('.tp-banner').revolution({
                delay:9000,
                startwidth:1170,
                startheight:750,
                hideThumbs:10,
                fullWidth:"on",
                forceFullWidth:"on",
                onHoverStop:"off",
                navigationType:"none",
                navigationStyle:"preview2",
                spinner:"off",
                hideTimerBar:"on"
            });
        }



    // -------------------------------------------------------------
    //      client-Slider
    // -------------------------------------------------------------

        if ($('.client-carousel').length) {
            $('.client-carousel').owlCarousel({
                loop:true,
                autoplay:true,
                autoplayTimeout: 2000,
                margin:30,
                nav:true,
                responsive:{
                    0:{
                        items:1,
                        nav:false,
                        dots:false,
                    },
                    600:{
                        items:3,
                        nav:false,
                        dots:false,
                    },
                    1000:{
                        items:5
                    }
                }
            });
        }



    // -------------------------------------------------------------
    //      project-Slider
    // -------------------------------------------------------------

        if ($('.project-carousel').length) {
            $('.project-carousel').slick({
                centerMode: true,
                centerPadding: '300px',
                slidesToShow: 1,
                margin:30,
                arrows: true,
                responsive: [
                    {
                      breakpoint: 2100,
                      settings: {
                        arrows: true,
                        centerMode: true,
                        centerPadding: '500px',
                        slidesToShow: 1
                      }
                    },

                    {
                      breakpoint: 1500,
                      settings: {
                        arrows: true,
                        centerMode: true,
                        centerPadding: '300px',
                        slidesToShow: 1
                      }
                    },

                    {
                      breakpoint: 991,
                      settings: {
                        arrows: true,
                        centerMode: true,
                        centerPadding: '200px',
                        slidesToShow: 1
                      }
                    },
                    {
                      breakpoint: 768,
                      settings: {
                        arrows: true,
                        centerMode: true,
                        centerPadding: '100px',
                        slidesToShow: 1
                      }
                    },
                    {
                      breakpoint: 480,
                      settings: {
                        arrows: false,
                        centerMode: true,
                        centerPadding: '40px',
                        slidesToShow: 1
                      }
                    }
                ]
            });
        }




    // -------------------------------------------------------------
    //      Google Map
    // -------------------------------------------------------------

        if ($('#googleMap').length) {
            google.maps.event.addDomListener(window, 'load', init);
            
            function init() {
                var mapOptions = {
                    // How zoomed in you want the map to start at (always required)
                    zoom: 15,
                    scrollwheel: false,

                    // The latitude and longitude to center the map (always required)
                    center: new google.maps.LatLng(36.169941, -115.139830), // New York

                    // This is where you would paste any style found on Snazzy Maps.
                    styles:[{"featureType": "all","elementType": "labels.text.fill","stylers": [{"saturation": 36},{"color": "#333333"},{"lightness": 40}]},
                            {"featureType": "all","elementType": "labels.text.stroke","stylers": [{"visibility": "on"},{"color": "#ffffff"},{"lightness": 16}]},
                            {"featureType": "all","elementType": "labels.icon","stylers": [{"visibility": "off"}]},
                            {"featureType": "administrative","elementType": "geometry.fill","stylers": [{"color": "#fefefe"},{"lightness": 20}]},
                            {"featureType": "administrative","elementType": "geometry.stroke","stylers": [{"color": "#fefefe"},{"lightness": 17},{"weight": 1.2}]},
                            {"featureType": "landscape","elementType": "geometry","stylers": [{"color": "#f5f5f5"},{"lightness": 20}]},
                            {"featureType": "poi","elementType": "geometry","stylers": [{"color": "#f5f5f5"},{"lightness": 21}]},
                            {"featureType": "poi.park","elementType": "geometry","stylers": [{"color": "#dedede"},{"lightness": 21}]},
                            {"featureType": "road.highway","elementType": "geometry.fill","stylers": [{"color": "#ffffff"},{"lightness": 17}]},
                            {"featureType": "road.highway","elementType": "geometry.stroke","stylers": [{"color": "#ffffff"},{"lightness": 29},{"weight": 0.2}]},
                            {"featureType": "road.arterial","elementType": "geometry","stylers": [{"color": "#ffffff"},{"lightness": 18}]},
                            {"featureType": "road.local","elementType": "geometry","stylers": [{"color": "#ffffff"},{"lightness": 16}]},
                            {"featureType": "transit","elementType": "geometry","stylers": [{"color": "#f2f2f2"},{"lightness": 19}]},
                            {"featureType": "water","elementType": "geometry","stylers": [{"color": "#e9e9e9"},{"lightness": 17}]}]};

                            // Get the HTML DOM element that will contain your map 
                            var mapElement = document.getElementById('googleMap');

                            // Create the Google Map using our element and options defined above
                            var map = new google.maps.Map(mapElement, mapOptions);

                            // Let's also add a marker while we're at it
                            var marker = new google.maps.Marker({
                                position: new google.maps.LatLng(36.169941, -115.139830),
                                map: map,
                                title: 'Snazzy!'
                            });
            }
        }




    // -------------------------------------------------------------
    // Back To Top
    // -------------------------------------------------------------

        function backToTopBtnAppear() {
            if ($("#toTop").length) {
                var windowpos = $(window).scrollTop(),
                    backToTopBtn = $("#toTop");

                if (windowpos > 4000) {
                    backToTopBtn.fadeIn();
                } else {
                   backToTopBtn.fadeOut();
                }
            }
        }

        function backToTop() {
            if ($("#toTop").length) {
                var backToTopBtn = $("#toTop");
                backToTopBtn.on("click", function() {
                    $("html, body").animate({
                        scrollTop: 0
                    }, 1000);
                    
                    return false;
                })
            }
        }



     // -------------------------------------------------------------
    //  Wow Animation
    // -------------------------------------------------------------

        new WOW().init();



	// -------------------------------------------------------------
    // 		Preloader
    // -------------------------------------------------------------

        function preloader() {
            if ($('#preloader').length) {
                $('#preloader').delay(100).fadeOut('slow' , function () {});
            }
        }



    // -------------------------------------------------------------
    //      WHEN WINDOW LOAD
    // -------------------------------------------------------------

        $(window).on("load", function() {

            preloader();

            new WOW().init();

            backToTop();

            bgParallax();

        })



    // -------------------------------------------------------------
    //      WHEN WINDOW SCROLL
    // -------------------------------------------------------------
        $(window).on("scroll", function() {

            backToTopBtnAppear();

            if ($(".review-section").length) {
                colorChangeAnimation();
            }

            bgParallax();

        });

});   // Jquery-End