import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String ex = "";
        int nr = 0;

        List<Integer> nr_list = new ArrayList<Integer>();
        List<String> ex_list = new ArrayList<String>();


        while (!ex.equals("end")) {
            System.out.println("Insert exercise number:");

            Scanner nr_scanner = new Scanner(System.in);


            try {
                nr = nr_scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Wrong number !");
                System.exit(0);
            }

            System.out.println("Insert anserw to exercise " + nr);

            Scanner ex_scanner = new Scanner(System.in);
            ex = ex_scanner.nextLine();


            AnswerCheck check = new AnswerCheck();

            if (check.checkAnswer(ex) == true)
            {
                nr_list.add(nr);
                ex_list.add(ex);
                System.out.println("QUERY SAVED");
            }
            else
            {
                if(ex.equals("end"))
                {
                    System.out.println("SEE YOU !");
                }
                else
                {
                    System.out.println("WRONG QUERY");
                }

            }


        }
    }
}
