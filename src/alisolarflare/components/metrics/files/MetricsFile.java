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
	private String fileName = "metrics/playerLogins.txt";
	public MetricsFile(String directory){
		this.fileName = directory;
	}
	public void AddLine(String string){
		BufferedWriter inputStream = null;
		try {
			File file = new File("metrics/playerLogins.txt");
			TBMCCoreAPI.sendDebugMessage("Metrics File Exists: " + file.exists());
			inputStream = new BufferedWriter(new FileWriter(fileName, true));
			TBMCCoreAPI.sendDebugMessage("Input Stream Created!");
			inputStream.write(string);
			inputStream.newLine();
			inputStream.close();
		} catch (IOException e) {
			TBMCCoreAPI.SendException(fileName +" Input Stream could not be created! ", e);
		}
	}
	public List<String> toArrayList(){
		BufferedReader outputStream = null;
		try {
			outputStream = new BufferedReader(new FileReader(fileName));
			
			List<String> outputList = new ArrayList<String>();
			String currentLine;
			
			while ((currentLine = outputStream.readLine()) != null){
				outputList.add(currentLine);
			}
			outputStream.close();
			return outputList;
		} catch (FileNotFoundException e) {
			TBMCCoreAPI.SendException(fileName + " could not be found", e);
		} catch (IOException e1) {
			TBMCCoreAPI.SendException(fileName + "encountered an I/O Exception!", e1);
		}
		return new ArrayList<String>();
	}
}
