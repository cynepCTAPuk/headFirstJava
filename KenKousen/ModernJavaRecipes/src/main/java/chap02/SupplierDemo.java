/**
 *  Реализация с помощью анонимного внутреннего класса
 *  Лямбда-выражение
 *  Ссылка на метод
 */
package chap02;

import java.util.function.DoubleSupplier;
import java.util.logging.Logger;

public class SupplierDemo {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("...");
        DoubleSupplier randomSupplier;
        randomSupplier = new DoubleSupplier() { // 
            @Override
            public double getAsDouble() {
                return Math.random();
            }
        };
        randomSupplier = () -> Math.random(); // 
        randomSupplier = Math::random; // 
        logger.info(String.valueOf(randomSupplier));
        System.out.println(logger);
    }
}
