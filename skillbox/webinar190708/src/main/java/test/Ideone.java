package test;

class Ideone {
    public static void main(String[] args) throws Exception {
        System.out.println("Кофе-машина");
        int moneyAmount = 120;

        int cappuccinoPrice = 150;
        int espressoPrice = 80;
        int milkPrice = 40;
        int waterPrice = 20;

        boolean canBuyAnything = false;

        if (moneyAmount >= cappuccinoPrice) {
            System.out.println("Вы можете купить капучино");
            canBuyAnything = true;
        }
        if (moneyAmount >= espressoPrice) {
            System.out.println("Вы можете купить эспрессо");
            canBuyAnything = true;
        }
        if (moneyAmount >= milkPrice) {
            System.out.println("Вы можете купить молоко");
            canBuyAnything = true;
        }
        if (moneyAmount >= waterPrice) {
            System.out.println("Вы можете купить воду");
            canBuyAnything = true;
        }
        if (canBuyAnything == false) {
            System.out.println("Недостаточно средств! Учите джаву и зарабатывайте много! :)");
        }
    }
}