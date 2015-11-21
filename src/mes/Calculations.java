package mes;

import java.util.Scanner;

public class Calculations {
	
	private GlobalData globalData;
	private FemGrid femGrid;
	private Element[] elements;
	private Node[] nodes;
	
	public void setGlobalData() {
		System.out.println("Podaj nazwe pliku z danymi globalnymi:");

		try(Scanner in = new Scanner(System.in))
		{

		String name = in.nextLine();
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		builder.append(".xml");
		String fileName = builder.toString();
		globalData = new GlobalData(fileName);
		}
	}
	
	public void setMaterialData(){
		System.out.println("ustawiam właściwości elementów");
		for(int i=0; i<globalData.getNh();i++){
			if(i==0)
				nodes[i]=new Node(i, 1, globalData.getL()/globalData.getNe());
			else if(i==(globalData.getNh()-1))
				nodes[i]=new Node(i, 2, globalData.getL()/globalData.getNe());
			else
				nodes[i]=new Node(i, 0, globalData.getL()/globalData.getNe());
				
		}
		
		for(int i=0; i<globalData.getNe();i++){
			elements[i]=new Element(nodes[i], nodes[i+1], globalData.getS(), globalData.getK(),
					globalData.getL()/globalData.getNe());
		}
		
	}
	public void generateFemGrid(){
		System.out.println("Generuję siatkę ES");

		femGrid=new FemGrid(elements, nodes);
	}
	
	public void solveSystemOfEquations(){
		
	}
}
