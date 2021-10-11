import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Numbers {

    public Numbers() {

    }

            /*public class ThreadPoolExample {
                public static void main(String[] args) {
                ThreadPoolExecutor executor = (ThreadPoolExecutor)
                Executors.newFixedThreadPool(2);
                for (int i = 1; i <= 5; i++) {
                Task task = new Task("Task " + i);
                System.out.println("Created : " +
                task.getName());
                executor.execute(task);
                }
                executor.shutdown();
                }
                }*/

    public ArrayList<Integer>  iterateNumbersWithApi() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("chunks>");
        int chunks = Integer.parseInt(scanner.nextLine());
        System.out.print("divider>");
        int divider = Integer.parseInt(scanner.nextLine());

        ArrayList<Integer> allNumbers = parseNumbers();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(8);

        for (int i = 0; i < chunks; i++) {

            executor.execute(new Runnable() {
                @Override
                public void run() {

                }
            });

        }
        System.out.println(allNumbers.size());


        return allNumbers;
    }

    public ArrayList<Integer> parseNumbers() {


        ArrayList<Integer> allNumbers = new ArrayList<>();
        boolean isNum = true;
        int isInt = -1;
        String line = "";


        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Test\\Desktop\\Programme\\UE4_SimonLuger\\numbers.csv"))){

            while((line = br.readLine())!= null) {

                String[] splitString = line.split(":");

                for (String s : splitString) {
                    isNum = true;
                    if(!s.isEmpty()){
                        try {
                            isInt = Integer.parseInt(s);
                        } catch (NumberFormatException e) {
                            isNum = false;
                        }

                        if(isNum) {
                            allNumbers.add(isInt);
                        }
                    }
                }
            }
            } catch (IOException e) {
            e.printStackTrace();
        }


        return allNumbers;
    }


}
