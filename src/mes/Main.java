package mes;

import java.util.Scanner;

public class Main {
	
	private static GlobalData globalData;
	
	public static void main(String[] args){
		System.out.println("Podaj nazwe pliku z danymi globalnymi:");
		
		Scanner in=new Scanner(System.in);
		
		String name=in.nextLine();
		StringBuilder builder=new StringBuilder();
		builder.append(name);
		builder.append(".xml");
		String fileName=builder.toString();
		globalData=new GlobalData(fileName);
		
		
	}

}
