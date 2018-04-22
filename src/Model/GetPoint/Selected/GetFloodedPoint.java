package Model.GetPoint.Selected;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

import asciiFunction.AsciiBasicControl;
import usualTool.AtCommonMath;
import Global.Global;

public class GetFloodedPoint {

	public GetFloodedPoint() throws IOException {
		// TODO Auto-generated method stub
		String iotList[][] = getIotStation();

		String floodedFile = Global.temptSaveFolder;

		for (String iot[] : iotList) {
			String stationName = iot[0];
			double x = Double.parseDouble(iot[1]);
			double y = Double.parseDouble(iot[2]);
			ArrayList<String> outArray = new ArrayList<String>();
			outArray.add(stationName);

			for (int eventFile = 0; eventFile < new File(floodedFile).list().length; eventFile++) {
				// read the event ascii grid
				outArray.add(new AsciiBasicControl(floodedFile + eventFile + ".asc").getValue(x, y));
			}
			outArray.forEach(text -> System.out.print(text + "\t"));
			System.out.println();
		}
	}

	private static String[][] getIotStation() {
		return new String[][] {{"安中五站","162347.19036844","2551199.14897445"},
			{"海佃四站","165662.855498722","2551505.05751402"},
			{"海佃三段站","166392.509038435","2549797.88912863"},
			{"朝皇宮站","166393.082894916","2548985.28362074"},
			{"龍金站","169960.008159805","2551746.18196554"},
			{"安中站","167349.839003952","2549370.51162728"},
			{"頂安站","168501.01265487","2549278.957237"},
			{"安和站","169782.704140448","2549447.95846844"},
			{"溪頂寮站","169520.714143787","2547951.88268649"}};

		// return Global.getIotPosition();
	}

}
