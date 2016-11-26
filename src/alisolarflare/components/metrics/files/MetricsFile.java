package alisolarflare.components.metrics.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
		BufferedWriter outputStream = null;
		try {
			outputStream = new BufferedWriter(new FileWriter(fileName, true));
			outputStream.write(string);
			outputStream.newLine();
			outputStream.close();
		} catch (IOException e) {
			TBMCCoreAPI.SendException(fileName +" Output Stream could not be created!", e);
		}
	}
	public List<String> toArrayList(){
		BufferedReader inputStream = null;
		try {
			inputStream = new BufferedReader(new FileReader(fileName));
			
			List<String> outputList = new ArrayList<String>();
			String currentLine;
			
			while ((currentLine = inputStream.readLine()) != null){
				outputList.add(currentLine);
			}
			inputStream.close();
			return outputList;
		} catch (FileNotFoundException e) {
			TBMCCoreAPI.SendException(" could not be found", e);
		} catch (IOException e1) {
			TBMCCoreAPI.SendException("encountered an I/O Exception!", e1);
		}
		return new ArrayList<String>();
	}
}
