import java.util.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException   {

        String ex = "";
        int nr = 0;

        ArrayList<Integer> nr_list = new ArrayList<Integer>();
        ArrayList<String> ex_list = new ArrayList<String>();


        while (!ex.equals("end")) {
            System.out.println("Insert exercise number:");

            Scanner nr_scanner = new Scanner(System.in);


            try {
                nr = nr_scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Wrong number !");
                continue;
            }

            System.out.println("Insert anserw to exercise " + nr + " / \"end\" to leave.");

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



        File file = new File("odp.txt");

        if (!file.exists()) {
            file.createNewFile();
        }


        FileWriter writer = new FileWriter(file);
        int size = nr_list.size();
        for (int i=0;i<size;i++) {
            String nr_line = nr_list.get(i).toString();
            String ex_line = ex_list.get(i).toString();
            writer.write(nr_line + ": " + ex_line);
            if(i < size-1)//This prevent creating a blank like at the end of the file**
            writer.write("\n");
        }
        writer.close();

    }
}
