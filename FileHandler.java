import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileHandler {
    public static void main(String[] args) {
        try{
            readFile("nonexisting fike");
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch (IOException e){
            System.out.println(e.getMessage());

        }
    }

    private static void readFile(String fileName) throws FileNotFoundException, IOException {

        File file = new File(fileName);
        FileInputStream fileInputStream = new FileInputStream(file);

        fileInputStream.close();
    }

}