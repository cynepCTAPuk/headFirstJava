package oop.localClass;

public abstract class AbstractPhoneNumberValidator {
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
}