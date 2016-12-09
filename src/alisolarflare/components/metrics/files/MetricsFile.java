package alisolarflare.components.metrics.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import buttondevteam.lib.TBMCCoreAPI;

public class MetricsFile { 
	private String fileName = "src/alisolarflare/resources/metrics/playerLogins.txt";
	public MetricsFile(String filePath){
		this.fileName = filePath;
	}
	public void AddLine(String string){
		BufferedWriter inputStream = null;
		try {
			TBMCCoreAPI.sendDebugMessage("Trying to Open File: "+fileName+"...");
			File file = new File(fileName);
			TBMCCoreAPI.sendDebugMessage("File Exists: " + file.exists());
			inputStream = new BufferedWriter(new FileWriter(fileName, true));
			TBMCCoreAPI.sendDebugMessage("Input Stream Created!");
			TBMCCoreAPI.sendDebugMessage("Trying to write to file...");
			inputStream.write(string);
			TBMCCoreAPI.sendDebugMessage("Ending with newLine...");
			inputStream.newLine();
			TBMCCoreAPI.sendDebugMessage("Closing File...");
			inputStream.close();
			TBMCCoreAPI.sendDebugMessage("File Closed!");
		} catch (IOException e) {
			TBMCCoreAPI.sendDebugMessage(fileName +" Input Stream could not be created! ");
			TBMCCoreAPI.sendDebugMessage(e.toString());
		}
	}
	public List<String> toArrayList(){
		BufferedReader outputStream = null;
		try {
			TBMCCoreAPI.sendDebugMessage("Creating FileReader: "+fileName);
			FileReader reader = new FileReader(fileName);
			TBMCCoreAPI.sendDebugMessage("Creating BufferedReader...");
			outputStream = new BufferedReader(reader);

			List<String> outputList = new ArrayList<String>();
			String currentLine;
			while ((currentLine = outputStream.readLine()) != null){
				outputList.add(currentLine);
			}
			TBMCCoreAPI.sendDebugMessage("Message! "+outputList.toString());
			outputStream.close();
			return outputList;
		} catch (FileNotFoundException e) {
			TBMCCoreAPI.sendDebugMessage(fileName + " could not be found");
			TBMCCoreAPI.sendDebugMessage(e.toString());
		} catch (IOException e1) {
			TBMCCoreAPI.SendException(fileName + "encountered an I/O Exception!", e1);
			TBMCCoreAPI.sendDebugMessage(e1.toString());
		}
		return new ArrayList<String>();
	}
}
