import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void print(List<String> input){
        String result="";
        for (String str: input){
            result+= str+" ";
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        File csvFile = new File("input.txt"); //Assuming csv file already created
        Scanner reader = new Scanner(System.in);

        List<List<String>> storedInfo = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(csvFile);

            while (scanner.hasNextLine()){ //create a temporary local copy of the data
                String line = scanner.nextLine();
                String[] fields = line.split(",");
                List<String> record = new ArrayList<>();

                for(String str: fields){
                    record.add(str);
                }
                storedInfo.add(record);
            }

        }catch (Exception error){
            error.printStackTrace();
            System.out.println(error+error.getMessage());
        }

        System.out.println("Please enter the first name, last name, or DOB for the record you are searching for.");
        String input= reader.nextLine();

        while (!input.equalsIgnoreCase("q")){
            for(List<String> records: storedInfo){
                if(records.contains(input)){
                    print(records);
                }
            }
            System.out.println("Enter q to exit, or new data to find records.");
            input = reader.nextLine();
        }



    }

}
