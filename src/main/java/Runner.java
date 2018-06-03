import java.util.Scanner;

public class Runner {

    public static void main(String args[]) {

        EventSender eventSender = new EventSender();
        Scanner s = new Scanner(System.in);

        char enteredChar = s.nextLine().charAt(0);
        while (enteredChar > 'a' && enteredChar < 'z') {
            switch (enteredChar) {
                case 's':
                    eventSender.sendEvent();
                    break;
                default:
                    System.out.println("This char does not represent command!");
            }
            enteredChar = s.nextLine().charAt(0);
        }
    }
}
