package assignment.assignment02;

import assignment.encryption_algorithm.Encryption;
import assignment.input_output_handling.IOHandling;

public class MyFileReader implements IOHandling {
    private String readFromFile;
    private String writeToFile;
    private String rawData = "";
    private String processedData = "";
    private Encryption eAlgorythm;

    public MyFileReader(String readFile, String writeFile, Encryption encryptionAlgorythm){
        if(readFile == "" || readFile == null) {
            System.out.println("input " + readFile + " is not a valid file to read from. please enter a file name");
        }else{
            this.readFromFile = readFile;
        }
        if(writeFile == "" || writeFile == null) {
            System.out.println("input " + writeFile + " is not a valid file to write from. please enter a file name");
        }else{
            this.writeToFile = writeFile;
        }
        if(encryptionAlgorythm == null) {
            System.out.println("The encryption algorythm you entered is not valid.");
        }else{
            this.eAlgorythm = encryptionAlgorythm;
        }
    }

    public void readData(){
        rawData = readData(readFromFile);
        processData();
    }
    public void readData(boolean forceEncryptDecrypt){
        rawData = readData(readFromFile);
        if (forceEncryptDecrypt){
            rawData = "encrypt" + rawData;
        }else{
            rawData = "decrypt" + rawData;
        }
        processData();

    }
    public void writeData(){
        writeData(processedData,writeToFile);
    }
    private void processData() {
        String firstWord = "";

        try {
            firstWord = (rawData.substring(0, 7)).strip();
        }catch(IndexOutOfBoundsException e){
            System.out.println("skipping encrypt/decrypt as string length is too short");
        }

        if(firstWord.contains("encrypt")){
            processedData = eAlgorythm.encrypt(rawData.substring(7,rawData.length()));
        }else if(firstWord.contains("decrypt")){
            processedData = eAlgorythm.decrypt(rawData.substring(7,rawData.length()));

        }else{
            processedData = rawData;
        }
    }

    public void setReadFromFile(String newReadFromFile){
        this.readFromFile = newReadFromFile;
    }
    public void setWriteToFile(String newWriteToFile){
        this.writeToFile = newWriteToFile;
    }

    public String getRawData(){
        return rawData;
    }
    public String getProcessedData(){
        return processedData;
    }
}
