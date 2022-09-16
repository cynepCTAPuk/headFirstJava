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
public class PhoneNumberValidator1 {
    class PhoneNumber {
        private String phoneNumber;

        public PhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }

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