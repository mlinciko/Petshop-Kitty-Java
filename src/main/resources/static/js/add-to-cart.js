document.querySelector('.add_to_cart').addEventListener('click', function () {
    addToCart();
})

function addToCart() {
    url = contextPath + "cart/add/" + petId;
    $.ajax({
        type:'POST',
        url: url
    }).done(function(response) {
        document.querySelector('.add_to_cart').classList.add("hidden")
        //document.querySelector('.in__cart').classList.remove("hidden")
        console.log(response)
    }).fail(function(){
        alert("Произошла ошибка! :(")
    })
}