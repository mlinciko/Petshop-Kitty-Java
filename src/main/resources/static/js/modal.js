
var modal = document.querySelector('.modal');
document.querySelector('.cart__checkout').addEventListener('click', function () {
  // отобразим модальное окно
  modal.classList.add('modal__show')
});
document.querySelector('.modal__btn-close').addEventListener('click', function () {
  // отобразим модальное окно
  modal.classList.remove('modal__show')
  clear();
});
document.querySelector('.modal__cancel').addEventListener('click', function () {
  // отобразим модальное окно
  modal.classList.remove('modal__show')
  clear();
});

//проверяем валидность при нажатии кнопки "Заказать"
document.querySelector('form').onsubmit = function (){
  console.log("work")
  //переменные хранят введенные данные
  let firstName = document.querySelector('#first-name').value;
  let lastName = document.querySelector('#last-name').value;
  let email = document.querySelector('#email').value;
  let tel = document.querySelector('#tel').value;
  let address = document.querySelector('#address').value;

  let message = document.querySelector('.alert')

  switch (validateData(firstName, lastName, email, tel, address)) {
    case 0:
      //отправляет данные формы
      document.querySelector('form').submit();
      clear();
      message.innerHTML = "";
      modal.classList.remove('modal__show')
      break;
    case 1:
      message.innerHTML = "Некорректное Имя или Фамилия";
      break;
    case 2:
      message.innerHTML = "Некорректный email";
      break;
    case 3:
      message.innerHTML = "Введите все данные";
      break;
    case 4:
      message.innerHTML = "Некорректный номер телефона";
      break;
    default:
      message.innerHTML = "Некорректные данные";
      break;
  }
  return false;

}

function clear(){
  document.querySelectorAll('.modal input').forEach((item) => {
    item.value = null
  })
}
function validateData(firstName, lastName, email, tel, address) {
  //регулярные выражения для проверки валидности
  regExpName = /^[A-ZА-Яa-zа-я -]+$/;
  regExpEmail = /^((([0-9A-Za-z]{1}[-0-9A-z\.]{1,}[0-9A-Za-z]{1})|([0-9А-Яа-я]{1}[-0-9А-я\.]{1,}[0-9А-Яа-я]{1}))@([-A-Za-z]{1,}\.){1,2}[-A-Za-z]{2,})$/u;
  regExpTel = /^((8|\+7)[\- ]?)?(\(?\d{3}\)?[\- ]?)?[\d\- ]{7,10}$/;

  if (!regExpName.test(firstName) || !regExpName.test(lastName)) {
    return 1;
  }
  else if (!regExpEmail.test(email)) {
    return 2;
  }
  else if (firstName === "" || lastName === "" || email === "" || tel === "" || address === "") {
    return 3;
  }
  else if (!regExpTel.test(tel)) {
    return 4;
  }
  else return 0;
}