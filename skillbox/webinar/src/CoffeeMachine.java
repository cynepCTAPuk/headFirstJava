import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите сумму: ");
        int moneyAmount = scanner.nextInt();

        int[] drinkPrices = {150, 80, 40, 20};
        String[] drinkNames = {"капучинно", "эспрессо", "молоко", "воду"};
        int check = 0;
        for (int i = 0; i < drinkNames.length; i++) {
            if (moneyAmount >= drinkPrices[i]) {
                System.out.println("Вы можете купить " + drinkNames[i]);
                check++;
            }
        }
        if (check == 0) {
            System.out.println("Недостаточно средств для покупки напитка!");
        }
    }
}
