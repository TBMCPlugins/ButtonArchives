package alisolarflare.components.links.serializer;


import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import alisolarflare.components.links.entities.Link;

/**
 * @deprecated
 * @author Alisolarflare
 *
 */
public class Serializer {

	public static void main (String args[]) {

		//Serializer serializer = new Serializer();
		//serializer.saveLink(plugin, frequency, location)
	}
	/**@deprecated*/
	public void saveLinkList(List<Link> aliLinkList){
		//saves link
		
		try{

			FileOutputStream fout = new FileOutputStream("AliLinkList.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(aliLinkList);
			oos.close();
			System.out.println("Done");

		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}