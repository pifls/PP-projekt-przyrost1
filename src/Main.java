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

        LinkedList<Query> query_list = new LinkedList<Query>();


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
                for(int i = 0; i < query_list.size(); i++)
                {
                    /* Overwriting ex with same number */
                    if(query_list.get(i).getNr() == nr)
                    {
                        query_list.remove(i);
                    }

                }
                query_list.add(new Query(nr, ex));
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

        /* Sorting anserws */
        Collections.sort(query_list);


        /* Saving to file */
        File file = new File("odp.txt");

        if (!file.exists())
        {
            file.createNewFile();
        }

        FileWriter writer = new FileWriter(file);
        int size = query_list.size();
        for (int i=0;i<size;i++) {
            int nr_line =  query_list.get(i).getNr();
            String ex_line =   query_list.get(i).getEx().toString();
            writer.write(nr_line + ": " + ex_line);
            if(i < size-1)
            writer.write("\n");
        }
        writer.close();

    }
}
