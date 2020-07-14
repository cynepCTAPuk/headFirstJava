"use strict";
let name, admin;
name = "Джон"
admin = name;
alert(admin);
// alert(1/0);
// alert(-1/0);
// alert("не число"/2);
// alert("не число"/2 + 5);

const bigInt = 123456789012345678901234567890123456789012345678901234567890n;
// alert(bigInt);

let name1 = "Иван";
// Вставим переменную
// alert( `Привет, ${name1}!` ); // Привет, Иван!
// Вставим выражение
// alert( `результат: ${1 + 2}` ); // результат: 3

name = null;
if(name != null) alert(`${name} is not null`);
else alert(`${name} is null`);