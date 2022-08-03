package exceptions.task3804;

/* 
Фабрика исключений
*/

public class Solution {
    public static Class getFactoryClass() {
        return Factory.class;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Factory.createException(ApplicationExceptionMessage.UNHANDLED_EXCEPTION));
        System.out.println(Factory.createException(DatabaseExceptionMessage.NO_RESULT_DUE_TO_TIMEOUT));
        System.out.println(Factory.createException(UserExceptionMessage.USER_DOES_NOT_EXIST));
    }
}