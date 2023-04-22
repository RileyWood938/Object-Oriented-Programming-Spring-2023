import java.io.*;
import java.util.Locale;

public class sortThroughDictionary {
    static public String dictionaryFileName;
    static public String destiantionFileName;

    public static void SiftThroughDictionary() {
        String lastLine = "";
        try {
            BufferedReader dictionaryScanner = new BufferedReader(
                    new FileReader(dictionaryFileName));
            String line;

            BufferedWriter writer = new BufferedWriter(new FileWriter(destiantionFileName));


            while ((line = dictionaryScanner.readLine()) != null) {
                line.strip();
                if (line.isBlank() == false) {
                    if (line == line.toUpperCase(Locale.ROOT)) {
                        if (containsNumber(line) == false) {
                            if (line.equals(lastLine) == false) {
                                lastLine = line;
                                if (line.contains(";")) {
                                    writer.write(line.split(";")[0].strip() + "\n");
                                    writer.write(line.split(";")[1].strip() + "\n");
                                } else {
                                    writer.write(line + "\n");
                                }
                            }
                        }
                    }
                }
            }
            writer.close();
            dictionaryScanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    static private boolean containsNumber(String inputString) {
        for (char c : inputString.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
}
