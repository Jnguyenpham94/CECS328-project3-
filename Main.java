import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) {
        HashSet<String> table = new HashSet<>();
        table.HashMap(50);
        try {
            BufferedReader read = new BufferedReader(new FileReader("trump_speech.txt"));
            String line;
            while ((line = read.readLine()) != null){
                table.add(line);
            }
            read.close();
        }
         catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND");
            e.printStackTrace();
        } catch (Exception f){
            System.out.println("FILE ERROR");
            f.printStackTrace();
        }
        
    }
}
