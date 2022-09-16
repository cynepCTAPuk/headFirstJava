package oop.localClass;

/**
 * https://javarush.ru/groups/posts/2199-primerih-nasledovanija-vnutrennikh-klassov
 * Локальный класс может наследоваться от:
 * 1. Обычного класса.
 * 2. Внутреннего класса (inner class), который объявлен в том же классе,
 * что и local class, либо в его предках.
 * 3. От другого локального класса, объявленного в том же методе (блоке).
 */
// Пример 1 — «наследование локального класса от Внутреннего класса (inner class),
// который был объявлен в том же классе, что и local class»:
// Пример 2 – «...либо в предках этого класса».
public class PhoneNumberValidator2 extends AbstractPhoneNumberValidator {
    public void validatePhoneNumber(final String number) {
        class CellPhoneNumber extends PhoneNumber {
            public CellPhoneNumber(String phoneNumber) {
                super(number);
            }
        }
        class LandlinePhoneNumber extends PhoneNumber {
            public LandlinePhoneNumber(String phoneNumber) {
                super(number);
            }
        }
        //...код валидации номера
    }
}