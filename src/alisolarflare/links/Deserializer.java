package alisolarflare.links;


import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class Deserializer{

	public static void main (String args[]) {

		//Deserializer deserializer = new Deserializer();
		//List<Link> aliLink = deserializer.loadLink(aliLink);
		//System.out.println(aliLink);
	}

	@SuppressWarnings("unchecked")
	public List<Link> loadLinkList(){
		List<Link> aliLinkList;
		try{

			FileInputStream fin = new FileInputStream("AliLinkList.ser");
			ObjectInputStream ois = new ObjectInputStream(fin);
			aliLinkList = (List<Link>) ois.readObject();
			ois.close();

			return aliLinkList;

		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
}
