import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class TextInterface extends Interface{
	
	Scanner reader;
	BufferedReader in;

	public TextInterface(){
		reader=new Scanner(System.in);
		in=null;
	}

	
	
	@Override
	public void getFile(String fileName){
		
		try {
			in = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	
	public void printCurFile(String fileName){
		if (in!=null){
			String str; 
			try {
				while ((str = in.readLine()) != null) { 
					printString(str); 
				}
				in.close(); 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}


	@Override
	public void printString(String toBePrinted){
		System.out.println(toBePrinted);
	}
	
	@Override
	public String readString(){
		return reader.nextLine();
	}
	
	@Override
	public int readInt(){
		return reader.nextInt();
	}

}
