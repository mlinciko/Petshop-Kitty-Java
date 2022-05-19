let pets;
window.onload = function(){
    $.ajax({
        type:'GET',
        url: "/allpets"
    }).done(function(response) {
        pets = response;
    }).fail(function(){
        alert("Произошла ошибка! :(")
    })
}

document.querySelector('.search').addEventListener('click', function (){
  document.querySelector('.search__container').classList.remove('show')
  document.querySelector('.search').style.display = "none";
})
document.querySelector('.close__search').addEventListener('click', function () {
  document.querySelector('.search__result').classList.add('show')
  setTimeout(function(){
    document.querySelector('.search__container').classList.add('show')
  }, 500);

  document.querySelector('.search').style.display = "block";
  document.querySelector('.search__input').value = ""
})


document.querySelector('.search__input').addEventListener('input', function (e) {
  document.querySelector('.search__result').classList.remove('show')
})
document.querySelector('.search__input').addEventListener('keydown', function (e) {
  if (e.keyCode === 13) {

    var element = document.querySelector('.header__goods')
    while (element.firstChild) {
      element.removeChild(element.firstChild);
    }

    let value = e.target.value;
    if (e.target.value === ""){
      return;
    }
    else {
      var reg = new RegExp(value, 'gi');

      let filteredPets = pets.filter(function (item) {
        if (item.description.replace(reg).includes("undefined"))
          return true;
        else return false;
      })
      insertPets(filteredPets)
    }
  }
  if (e.keyCode === 8){
    var element = document.querySelector('.header__goods')
    while (element.firstChild) {
      element.removeChild(element.firstChild);
    }
  }
});

types = [ "cats", "dogs", "rodents", "parrots"]

function insertPets(pets){
  pets.forEach(function(item)  {
  console.log(item.name)
  console.log(item.price)
    let div = document.createElement('div')
    div.className = "header__goods__container"
    div.innerHTML = `
    <a href="/${types[item.petType-1]}/pet-details?id=${item.id}" class="header__goods__link">
      <img src="images/${item.image}" alt="" class="header__goods__image">
      <div class="header__goods__text">
        <div class="header__goods__name">${item.name}</div>
        <div class="header__goods__price">${item.price} &#8381;</div>
      </div>
    <a href="">`
    document.querySelector('.header__goods').append(div);
  })

}