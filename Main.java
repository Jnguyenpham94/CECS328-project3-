import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    static BufferedReader read;

    public static void main(String[] args) {
        HashSet<Object> table = new HashSet<>();
        table.HashMap(50);
        try {
            read = new BufferedReader(new FileReader("trump_speech.txt"));
            String line;
            while ((line = read.readLine()) != null) {
                String[] parts = line.replaceAll("[^a-zA-Z0-9\\s]", "").split(" ");// replaceall that is NOT letters, numbers, and spaces and split words by spaces
                for(String i : parts) {
                    table.add(i);
                }
            }
            read.close();
        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND");
            e.printStackTrace();
        } catch (IOException f) {
            System.out.println("I/O ERROR");
            f.printStackTrace();
        } finally {
            System.out.println("************************************");
            System.out.println(" Distinct words in hash set: " + table.count());
            System.out.println("************************************");
        }
    }
}