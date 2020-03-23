package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

class ReadFile {
	public static void main (String[] args){
		String unsortedText = "C:/000/tam.txt";
		File file = new File(unsortedText);
		try{
			FileReader fileReader = new FileReader(file);
			BufferedReader reader = new BufferedReader(fileReader);
			String line = null;
			while((line = reader.readLine()) !=null){
				System.out.println(line);
			}
			reader.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}