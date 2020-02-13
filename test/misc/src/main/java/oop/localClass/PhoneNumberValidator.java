package oop.localClass;

/**
 * https://javarush.ru/groups/posts/2199-primerih-nasledovanija-vnutrennikh-klassov
 * от локального класса могут наследоваться только другие локальные классы
 * внутри того же метода (или блока).
 */
public class PhoneNumberValidator {
    public void validatePhoneNumber(final String number) {
        class PhoneNumber {
            private String phoneNumber;

            public PhoneNumber() {
                this.phoneNumber = number;
            }

            public String getPhoneNumber() {
                return phoneNumber;
            }

            public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
            }
        }
        class CellPhoneNumber extends PhoneNumber {
        }
        class LandlinePhoneNumber extends PhoneNumber {
        }
        //...код валидации номера
    }
}
