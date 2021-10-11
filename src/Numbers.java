import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Numbers {

    public Numbers() {

    }

    public ArrayList<Integer>  iterateNumbersWithApi() {

        ArrayList<Integer> allNumbers = parseNumbers();

    }

    public ArrayList<Integer> parseNumbers() {

        Scanner scanner = new Scanner(System.in);
        int chunks = Integer.parseInt(scanner.nextLine());
        int divider = Integer.parseInt(scanner.nextLine());
        ArrayList<Integer> allNumbers = new ArrayList<>();
        boolean isNum = true;
        int isInt = -1;

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Test\\Desktop\\Programme\\UE4_SimonLuger\\numbers.csv"))){

            String[] splitString = br.readLine().split(":");

            for (String s : splitString) {

                if(s.isEmpty() == false){
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

            return allNumbers;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

      return null;
    }
}
