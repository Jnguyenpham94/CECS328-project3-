import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        HashSet<Object> table = new HashSet<>();
        table.HashMap(50);
        try {
            BufferedReader read = new BufferedReader(new FileReader("trump_speech.txt"));
            String line;
            while ((line = read.readLine()) != null){
                String parts = line.replaceAll("[^a-zA-Z ]", "");
                table.add(parts);
            }
            read.close();
            /*
            for(int i=0; i < tableSize - 1;i++){
                System.out.println(table[i]);
            }*/
        }
         catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND");
            e.printStackTrace();
        } catch (IOException f){
            System.out.println("I/O ERROR");
            f.printStackTrace();
        }
    }

}