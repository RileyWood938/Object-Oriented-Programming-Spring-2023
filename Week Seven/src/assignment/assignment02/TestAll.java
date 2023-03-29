package assignment.assignment02;


public class TestAll {

	public static void main(String[] args) {
		{
			CeaserCypher thisDoesNothing = new CeaserCypher(0);
			MyFileReader fr = new MyFileReader("src/assignment/readFile.txt", "src/assignment/writeFile.txt", thisDoesNothing);//none of this matters
			fr.writeData(fr.readData("src/assignment/readFile.txt"), "src/assignment/writeFile.txt");
		}
		{
			CeaserCypher cypher1 = new CeaserCypher(1);

			MyFileReader fr2 = new MyFileReader("src/assignment/readFile2.txt", "src/assignment/writeFile2.txt", cypher1);

			fr2.readData();
			fr2.writeData();

			System.out.println("raw Data: " + fr2.getRawData().strip());
			System.out.println("Processed String: " + fr2.getProcessedData() + "\n");

			fr2.setReadFromFile("src/assignment/writeFile2.txt");
			fr2.readData(false);
			fr2.writeData();
			System.out.println("raw Data: " + fr2.getRawData().strip());
			System.out.println("Processed String: " + fr2.getProcessedData() + "\n");
		}
		{
			CeaserCypher cypher10 = new CeaserCypher(10);
			MyFileReader r2 = new MyFileReader("src/assignment/sampleInput.txt", "src/assignment/writeFile3.txt", cypher10);
			r2.readData();
			r2.writeData();
			System.out.println("raw Data: " + r2.getRawData().strip());
			System.out.println("Processed String: " + r2.getProcessedData() + "\n");
		}
	}
	
	
}
