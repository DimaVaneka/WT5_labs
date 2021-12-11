package by.bsuir.DimaVaneka.client.view.menu;

import java.util.Scanner;

/**
 * Created by dima on 11/11/2021.
 */
public class MenuViewInput {

    private static Scanner scanner = new Scanner(System.in);

    public static String menuActionInput(){
        System.out.print("Ваше действие: ");
        String choice = scanner.nextLine().trim();
        System.out.println("----------------------------------------");
        return choice;
    }
}
