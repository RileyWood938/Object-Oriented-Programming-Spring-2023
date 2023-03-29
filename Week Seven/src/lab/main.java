package lab;

public class main {

    public static void main(String[] args) {
        TextBlock[] textBlocksToPrint = new TextBlock[4];

        textBlocksToPrint[0] = new TextLine("asf");
        textBlocksToPrint[1] = new TextLine("ifgj");
        textBlocksToPrint[2] = new BoxedBlock(new TextLine("sffg"));
        textBlocksToPrint[3] = new BoxedBlock(textBlocksToPrint[2]);

        for(TextBlock i: textBlocksToPrint){
            System.out.println("Printing new TextBlock With area: " + Double.toString(i.getArea()) );
            try {
                printBlock(i);
            } catch (Exception e){
                throw new RuntimeException(e);
            }
        }

    }
    private static void printBlock(TextBlock textBlockToPrint) throws Exception {
        for (int i=0; i<textBlockToPrint.height(); i++){
            System.out.println(textBlockToPrint.GetTextFromrow(i));
        }
    }
}
