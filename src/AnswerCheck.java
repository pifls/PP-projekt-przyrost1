public class AnswerCheck {

    public AnswerCheck() {
    }

    String answer = "";

    public boolean checkAnswer(String ans){

        answer = ans.toLowerCase();

        int[] tab = new int[4];
        tab[0] = -1;
        tab[1] = -1;
        tab[2] = -1;
        tab[3] = -1;
        String finder = answer;

        int queryIndex;


        queryIndex = finder.indexOf("select");
        tab[0] = queryIndex;
        queryIndex = finder.indexOf("from");
        tab[1] = queryIndex;
        queryIndex = finder.indexOf("where");
        tab[2] = queryIndex;
        queryIndex = finder.indexOf("order by");
        tab[3] = queryIndex;

        /*
        System.out.println(tab[0]);
        System.out.println(tab[1]);
        System.out.println(tab[2]);
        System.out.println(tab[3]);
        */

        if(tab[0] == -1 || tab[1] == -1 || tab[2] == -1 || tab[3] == -1)
        {
            if(tab[0] == -1 || tab[1] == -1)
            {
                return false;
            }
            else
            {
                if(tab[2] == -1 && tab[3] == -1)
                {
                    if(tab[0] < tab[1])
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
                else if(tab[2] == -1)
                {
                    if(tab[0] < tab[1] && tab[1] < tab[3])
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
                else if(tab[3] == -1)
                {
                    if(tab[0] < tab[1] && tab[1] < tab[2])
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
            }
        }
        else
        {
            if(tab[0] < tab[1] && tab[1] < tab[2] && tab[2] < tab[3])
            {
                return true;
            }
            else
            {
                return false;
            }
        }


        return false;

    }
}
