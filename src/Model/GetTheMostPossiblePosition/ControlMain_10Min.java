package Model.GetTheMostPossiblePosition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

import main.MergeZoneAscii;
import usualTool.AtArrayFunction;
import usualTool.FileFunction;

public class ControlMain_10Min {
	private static int detecGrid = 5;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileFunction ff = new FileFunction();

		String saveAdd = Global.Global.temptSaveFolder;
		ff.delAllFile(saveAdd);

		// String eventSimulation =
		// "S:\\HomeWork\\ICCCBE2018\\多次成果\\20160927(09~09+1)\\10min_許\\";

		String eventSimulation = "S:\\HomeWork\\ICCCBE2018\\多次成果\\FloodAscii\\20160927(09~09+1)\\0410\\";
		String originalName = "\\dm1d";

		for (int index = 0; index < 144; index++) {
			ff.copyFile(eventSimulation + originalName + String.format("%04d", index) + ".asc",
					saveAdd + (index) + ".asc");
		}
		
		
		TreeMap<String, Double[]> iotTree = getIotStation();
		TreeMap<String , String> corTree = new TreeMap<String , String>();
		corTree = new GetMostPossiblePosition(detecGrid, "S:\\HomeWork\\ICCCBE2018\\observation\\10min\\0927.txt").getCorrelation();

		for (int index =0 ; index<iotTree.size() ; index++) {
			String iotStation = Global.Global.getIotPosition()[index][0];
			System.out.print(iotStation + "\t");
			String displacementList = corTree.get(iotStation);
				
				
					int row = Integer.parseInt(displacementList.split("_")[0]);
					int column =  Integer.parseInt(displacementList.split("_")[1]);

					System.out.print(iotTree.get(iotStation)[0] + column * 20 + "\t");
					System.out.print(iotTree.get(iotStation)[1] + row * 20);
					System.out.println();

			
		}
	}

	private static TreeMap<String, Double[]> getIotStation() {
		TreeMap<String, Double[]> temptTree = new TreeMap<String, Double[]>();
		String iotStations[][] = Global.Global.getZoneOneIotPosition();
		for (String[] iotStation : iotStations) {
			temptTree.put(iotStation[0],
					new Double[] { Double.parseDouble(iotStation[1]), Double.parseDouble(iotStation[2]) });
		}
		return temptTree;
	}

}
