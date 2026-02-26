package Ewerton.AgenciaBancaria;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try {
            while (true) {
                Menu.showMenu();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
