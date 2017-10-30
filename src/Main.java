import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {

        String ex="";
        int nr=0;
        boolean nr_test = true;


        System.out.println("Insert exercise number:");

        Scanner nr_scanner = new Scanner(System.in);


            try {
                nr = nr_scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Wrong number !");
                System.exit(0);
            }

        System.out.println("Insert anserw to exercise "+ nr);

        Scanner ex_scanner = new Scanner(System.in);
        ex = ex_scanner.nextLine();

    }
}
