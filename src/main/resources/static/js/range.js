//динамически меняет значение value для ползунка
const setPrice = () => {
  document.getElementById('currentPrice').innerHTML = document.getElementById('price').value;
}
document.querySelector('#price').addEventListener('input', setPrice);


const setAge = () => {
  document.getElementById('currentAge').innerHTML = document.getElementById('age').value;
}
document.querySelector('#age').addEventListener('input', setAge);

const clearFilter = () => {
  document.getElementById('currentAge').innerHTML = 0;
  document.getElementById('age').value = 0;

   document.getElementById('currentPrice').innerHTML = 0;
   document.getElementById('price').value = 0;
}
document.querySelector('a.filter__clear').addEventListener('click', clearFilter);




