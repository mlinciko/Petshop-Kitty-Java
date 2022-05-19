//добавляет стили активной вкладке
$(document).ready(function (){
    $(function () {
            $('.menu__item a').each(function () {
                var location = window.location.href;
                var link = this.href;
                if(location == link || (location.includes(link) && link !== 'http://localhost:8080/')) {
                    $(this).addClass('active');
                }
            });
        });
})



