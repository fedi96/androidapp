
$(function () {

    /***** ******/
    var trigger = $('.hamburger'),
            overlay = $('.overlaymenu'),
            isClosed = false;

    trigger.click(function () {
        hamburger_cross();
    });
    function hamburger_cross() {
        if (isClosed == true) {

            overlay.addClass('hiddenmenu');
            overlay.removeClass("afficheover");
            setTimeout(function () {
                overlay.css("display", "none");
            }, 450);
            $('#wrapper').toggleClass('toggled');
            $('#footer').toggleClass('togglefoo');
            trigger.addClass('is-closed');
            trigger.removeClass('is-open');
            isClosed = false;
        } else {
            trigger.addClass('is-open');

            overlay.addClass("afficheover");
            overlay.removeClass('hiddenmenu');
            overlay.css("display", "block");

            $('#wrapper').toggleClass('toggled');
            $('#footer').toggleClass('togglefoo');
            isClosed = true;
        }

    }

    $('[data-toggle="offcanvas"]').click(function () {

    });
    $(".ok").click(function () {
        $(".cookies").css("opacity", "0");
        setTimeout(function () {
            $(".cookies").css("display", "none");
        }, 1000);
    });
    /*
     setTimeout(function () {
     $(".cookies").css("opacity", "0");
     setTimeout(function () {
     $(".cookies").css("display", "none");
     }, 1000);
     }, 3000);
     */
});
$(document).ready(function () {

    /*chrome = /chrom(e|ium)/.test(navigator.userAgent.toLowerCase());
     if(chrome){
     $(".customcustom").height(34);
     }
     else{
     $(".customcustom").height(30);
     }
     
     var header_height = $('#detail-header').height();
     var window_height = $(window).height();
     
     var new_height = parseInt(window_height) - parseInt(header_height) - 59;
     var txt_cont_height = new_height - 280;
     
     $("#content").height(new_height);
     $("#text-content").height(txt_cont_height);*/

    /*var menu_container_height = $('#menu-container').height();
     var menu_list_height = $('ul.menu_list').height();
     
     var final_height = menu_container_height - menu_list_height - 381 - 70;
     $(".submenulist").height(final_height);*/

    var hoverElem = "";
    $('*').hover(function () {
        hoverElem = $(this)
    });
    $('.flexslider').flexslider({
        animation: "slide"
    });
    $('a.overlay').hover(
            function () {
                $(this).css("background", "url('/img/overlay.png') no-repeat");
            },
            function () {
                $(this).css("background", "none");
            }
    );
    $('a.overlay125').hover(
            function () {
                $(this).css("background", "url('/img/overlay.png') no-repeat");
            },
            function () {
                $(this).css("background", "none");
            }
    );
    $('.fsite, .fpart').fancybox({
        'padding': [15, 15, 0, 15],
        'afterLoad': function () {
            $('.fancybox-skin').css("border-bottom", "");
            $('.fancybox-skin').css("border-bottom", "10px solid #3289ea");
        }
    });
    $('.fetr').fancybox({
        'padding': [15, 15, 0, 15],
        'afterLoad': function () {
            $('.fancybox-skin').css("border-bottom", "");
            $('.fancybox-skin').css("border-bottom", "10px solid #79b017");
        }
    });
    $('.fjeun').fancybox({
        'padding': [15, 15, 0, 15],
        'afterLoad': function () {
            $('.fancybox-skin').css("border-bottom", "");
            $('.fancybox-skin').css("border-bottom", "10px solid #e37409");
        }
    });
    $('.fpro').fancybox({
        'padding': [15, 15, 0, 15],
        'afterLoad': function () {
            $('.fancybox-skin').css("border-bottom", "");
            $('.fancybox-skin').css("border-bottom", "10px solid #666666");
        }
    });
    $('.fenter').fancybox({
        'padding': [15, 15, 0, 15],
        'afterLoad': function () {
            $('.fancybox-skin').css("border-bottom", "");
            $('.fancybox-skin').css("border-bottom", "10px solid #a843c8");
        }
    });
    /*'closeBtn': false,*/

    /*
     $('li.target').hover(
     function(){
     
     if($(this).hasClass("blue")){$(this).addClass("blue-hover");}
     if($(this).hasClass("green")){$(this).addClass("green-hover");}
     if($(this).hasClass("gray")){$(this).addClass("gray-hover");}
     if($(this).hasClass("orange")){$(this).addClass("orange-hover");}
     if($(this).hasClass("purple")){$(this).addClass("purple-hover");}
     
     $(".mi").each(function(){
     $(this).hide();
     });
     
     $($(this).attr("tg")).show();
     },
     function (evt) {
     //setTimeout(function() {
     //if($(this).hasClass("blue")){$(this).removeClass("blue-hover");}
     if($(this).hasClass("green")){$(this).removeClass("green-hover");}
     if($(this).hasClass("gray")){$(this).removeClass("gray-hover");}
     //if($(this).hasClass("orange")){$(this).removeClass("orange-hover");}
     if($(this).hasClass("purple")){$(this).removeClass("purple-hover");}
     
     $(".mi").each(function(){
     $(this).hide();
     });
     $(".mi-or").each(function(){
     $(this).show();
     });
     $(".mi-blue").each(function(){
     $(this).show();
     });
     //}, 5000);
     }
     );
     */

    $('.article-link').each(function () {
        if ($(this).attr('view-state') === 'hidden') {
            $(this).hide();
        }
    });
    setInterval(function () {
        var i = 0;
        var len = $('.article-link').length;
        $('.article-link').each(function (index, element) {
            if (i === 0) {
                if ($(this).attr('view-state') === 'visible') {
                    $(this).attr('view-state', 'hidden');
                    if (index === len - 1) {
                        $('.article-link').first().attr('view-state', 'visible');
                        $(this).hide();
                        $('.article-link').first().show();
                    }
                    else {
                        $(this).next().attr('view-state', 'visible');
                        $(this).hide();
                        $(this).next().show();
                    }
                    i++;
                }
            }
        });
    }, 5000);
    $('#type-credit').on('change', function () {
        $("#blue-slider").slider("value", 50);
        $("#montant-credit").val("0.000 TND");
        $("#mensualite-credit").val("0.000 TND");
    });
    if ($("#blue-slider").length) {
        $("#blue-slider").slider({
            orientation: "horizontal",
            min: 0,
            max: 100000,
            step: 1000,
            slide: function (event, ui) {
                var taux = parseFloat($("#tmm_rate").val());
                var duree = parseInt($("#type-credit").val()) * 12;
                var mnt = parseInt(ui.value);
                var mensualite = computeMensualite(taux, duree, mnt);
                $("#montant-credit").val(ui.value + " TND");
                $("#mensualite-credit").val(mensualite + " TND");
            }
        });
    }

    $('#duree-bon').hide();
    $('#duree-certificat').hide();
    $('#type-placement').on('change', function () {
        if (parseInt($(this).val()) === 1) {
            initCompte();
        }
        else if (parseInt($(this).val()) === 2) {
            initBon();
        }
        else {
            initCertificat();
        }
        $("#nb-mois").val("");
        $("#montant-placement").val("");
        $("#interet-placement").val("0.000 TND");
    });
    $('#nb-mois').on('keyup', function () {
        if (!isInt($(this).val())) {
            $(this).val('');
            alert('Le nombre de mois dot être de type numérique.');
        }
        else {
        }
    });
    $('#montant-placement').on('focus', function () {
    });
    if ($("#blue-slider2").length) {
        $("#blue-slider2").slider({
            orientation: "horizontal",
            min: 0,
            max: 100000,
            step: 1000,
            slide: function (event, ui) {
                var taux = parseFloat($("#tmm_rate").val());
                var duree = parseInt($("#nb-mois").val());
                var mnt = parseInt(ui.value);
                var interet = 0;
                if (parseInt($('#type-placement').val()) === 1) {
                    var check = parseInt($('#select-compte').val());
                    interet = computeInteretCompte(taux, duree, mnt, check);
                }
                else if (parseInt($('#type-placement').val()) === 2) {
                    var check = parseInt($('#select-bon').val());
                    interet = computeInteretBon(taux, duree, mnt, check);
                }
                else {
                    var check = parseInt($('#select-certificat').val());
                    interet = computeInteretCertificat(taux, duree, mnt, check);
                }

                $("#montant-placement").val(ui.value);
                $("#interet-placement").val(interet);
            }
        });
    }

    initConversion();
    $("#result-depart").on('change', function () {
        convertVente();
    });
	$("#devise-depart").on('change', function () {
        convertVente();
    });
    $("#result-arrivee").on('change', function () {
        convertAchat();
    });
	$("#devise-arrivee").on('change', function () {
        convertAchat();
    });
});
function computeMensualite(taux, duree, mnt) {
    var a = (mnt * taux * 30) / 36000;
    var b = 1 + (taux * 30 / 36000);
    var mensualite = (a * Math.pow(b, duree)) / (Math.pow(b, duree) - 1);
    mensualite = (Math.floor(1000 * mensualite) / 1000).toFixed(3);
    return mensualite;
}

function initCompte() {
    $('#select-compte, #select-bon, #select-certificat').val(1);
    $('#duree-bon, #duree-certificat').hide();
    $('#duree-compte').show();
}

function initBon() {
    $('#select-compte, #select-bon, #select-certificat').val(1);
    $('#duree-certificat, #duree-compte').hide();
    $('#duree-bon').show();
}

function initCertificat() {
    $('#select-compte, #select-bon, #select-certificat').val(1);
    $('#duree-compte, #duree-bon').hide();
    $('#duree-certificat').show();
}

function computeInteretCompte(taux, duree, mnt, check) {

    if (check === 5) {
        var rate = taux + 0.5;
    }
    else {
        var rate = taux - 0.5;
    }

    var djours = duree * 30;
    var interet = (rate * djours * mnt) / 36500;
    interet = (Math.floor(1000 * interet) / 1000).toFixed(3);
    return interet;
}

function computeInteretBon(taux, duree, mnt, check) {
}

function computeInteretCertificat(taux, duree, mnt, check) {
}

function isInt(value) {
    if (isNaN(value)) {
        return false;
    }
    var x = parseFloat(value);
    return (x | 0) === x;
}

function initConversion() {
    var depart = parseFloat($("#result-depart").val());
    var tx = parseFloat($('#devise-arrivee').find(":selected").attr('vente'));
    var res = depart / tx;
    $("#result-arrivee").val(res)
}

function convertVente() {

	var valdevicedep = $('#devise-depart').find(":selected").attr('vente');
	var unitedep = $('#devise-depart').find(":selected").attr('unite');
	var valconvert = $("#result-depart").val();
	
	var valdevicearr = $('#devise-arrivee').find(":selected").attr('vente');
	var unitearr = $('#devise-arrivee').find(":selected").attr('unite');
	
	$("#result-arrivee").val(((valdevicedep/unitedep) * valconvert) / (valdevicearr/unitearr));

}

function convertAchat() {

	var valdevicedep = $('#devise-depart').find(":selected").attr('achat');
	var unitedep = $('#devise-depart').find(":selected").attr('unite');
	
	var valconvert = $("#result-arrivee").val();
	
	var valdevicearr = $('#devise-arrivee').find(":selected").attr('achat');
	var unitearr = $('#devise-arrivee').find(":selected").attr('unite');
	
	$("#result-depart").val(((valdevicearr/unitearr)*valconvert) / (valdevicedep/unitedep));

}