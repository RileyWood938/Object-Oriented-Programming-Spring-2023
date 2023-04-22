import java.io.*;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        organizeDictionaryIntoNewFiles.dictionaryFileName = "src/ClearedDictionary.txt";
        organizeDictionaryIntoNewFiles.destiantionFilePath = "src/dictionaries/";
        organizeDictionaryIntoNewFiles.destiantionFileName = "DictOnly.txt";
        organizeDictionaryIntoNewFiles.sortDictionary();

    }
}

class organizeDictionaryIntoNewFiles{
    static public String dictionaryFileName;
    static public String destiantionFilePath;

    static public String destiantionFileName;

    public static void sortDictionary(){
        try {
            for(int i=0; i<=25; i++) {
                BufferedReader dictionaryScanner = new BufferedReader(
                        new FileReader(dictionaryFileName));
                String line = "";
                char c = (char)(65+i);

                BufferedWriter writer = new BufferedWriter(new FileWriter((destiantionFilePath+Character.toString(c)+destiantionFileName)));

                while ((line = dictionaryScanner.readLine()) != null){
                    if(line.charAt(0) == Character.toUpperCase(c)){
                        writer.write(line + "\n");
                    }
                }
                dictionaryScanner.close();
                writer.close();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}