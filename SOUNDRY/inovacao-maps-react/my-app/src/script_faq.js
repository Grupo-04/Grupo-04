import jQuery from 'jquery'; 

(function($){
    "use strict";
    if($('.accordion-grp').length) {
        var accordionGrp = $('.accordion-grp');
        accordionGrp.each(function(){
            var accordionName = $(this).data('grp-name');
            var Self = $(this);
            var accordion = Self.find('.accordion');
            Self.addClass(accordionName);
            Self.find('.accordion .accordion-content').hide();
            Self.find('.accordion.active').find('.accordion-content').show();
            accordion.each(function(){
                $(this).find('.accordion-title').on('click', function(){
                    if($(this).parent().parent().hasClass('active') === false){
                        $('.accordion-grp.' +
                        accordionName).find('.accordion').removeClass('active');
                        $('.accordion-grp.' + 
                        accordionName).find('.accordion').find('.accordion-content').slideUp();
                        $(this).parent().parent().addClass('active');
                        $(this).parent().parent().find('.accordion-content').slideDown();
                    };
                });
            });
        });
    };
})(jQuery);
