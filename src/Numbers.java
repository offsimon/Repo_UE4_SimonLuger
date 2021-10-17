import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Numbers {

    public Numbers() {

    }

    public void iterateNumbersWithApi() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("chunks>");
        int chunks = Integer.parseInt(scanner.nextLine());
        System.out.print("divider>");
        int divider = Integer.parseInt(scanner.nextLine());
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(8);

        ArrayList<Integer> allNumbers = parseNumbers();
        int chunkSize = allNumbers.size()/chunks;
        int upperLimit = chunkSize;
        int lowerLimit = 0;

        for (int i = 0; i < chunks; i++) {

            final List<Integer> list = allNumbers.subList(lowerLimit, upperLimit);

            upperLimit += chunkSize;
            lowerLimit += chunkSize;

            executor.execute((() -> {

                for (int j = 0; j < list.size(); j++) {
                    if(list.get(j) % divider == 0) {
                        System.out.println(list.get(j));
                    }
                }
            }));
        }
        executor.shutdown();
    }

    public ArrayList<Integer> parseNumbers() {


        ArrayList<Integer> allNumbers = new ArrayList<>();
        boolean isNum = true;
        int isInt = -1;
        String line = "";


        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Test\\Desktop\\Programme\\UE4_SimonLuger\\numbers.csv"))) {

            while ((line = br.readLine()) != null) {

                String[] splitString = line.split(":");

                for (String s : splitString) {
                    isNum = true;
                    if (!s.isEmpty()) {
                        try {
                            isInt = Integer.parseInt(s);
                        } catch (NumberFormatException e) {
                            isNum = false;
                        }

                        if (isNum) {
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
