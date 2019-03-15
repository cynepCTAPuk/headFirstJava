package vasilievAN;

import javax.swing.*;

public class WhatIsYourName {
    public static void main(String[] args) {
        String name;
        name = JOptionPane.showInputDialog("Добрый день! Как вас зовут?");
        JOptionPane.showMessageDialog(null,"Приятно познакомиться, \n"+name+"!");
    }
}
