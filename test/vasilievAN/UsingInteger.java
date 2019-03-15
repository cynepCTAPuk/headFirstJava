package vasilievAN;

import javax.swing.*;

public class UsingInteger {
    public static void main(String[] args) {
        int Number = 321;
        String Not_A_Number = "123";

        int A_Number = Integer.parseInt(Not_A_Number);

        String title1 = "Команда: Number + Not_A_Number";
        String title2 = "Команда: Number + A_Number";
        String title3 = "Усё Окей";

        int type1 = JOptionPane.ERROR_MESSAGE;
        int type2 = JOptionPane.WARNING_MESSAGE;
        int type3 = JOptionPane.INFORMATION_MESSAGE;

        JOptionPane.showMessageDialog(null, Number+Not_A_Number,title1,type1);
        JOptionPane.showMessageDialog(null, Number+A_Number,title2,type2);
        JOptionPane.showMessageDialog(null, "Будем здоровы",title3,type3);
    }
}
