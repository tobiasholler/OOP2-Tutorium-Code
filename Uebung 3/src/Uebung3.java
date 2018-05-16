import java.util.*;

public class Uebung3 {

	public static void main(String[] args) {
		/*
		 * Vector<String> viktor = new Vector<String>(); viktor.add("Eins");
		 * viktor.add("Zwei"); viktor.add("Drei");
		 * 
		 * Collections.sort(viktor);
		 * 
		 * for (Enumeration<String> entries = viktor.elements();
		 * entries.hasMoreElements();) { System.out.println(entries.nextElement()); }
		 */

		/*Stack<String> obst = new Stack<String>();

		obst.push("Apfel");
		obst.push("Birne");
		obst.push("Mandarine");
		obst.push("Kirsche");

		while (true) {
			System.out.println(obst.pop());
		}*/

		Hashtable<String, String> ali = new Hashtable<String, String>();
		ali.put("Stef", "s.mueller@mueller.de");
		ali.put("Udo", "u.mueller@mueller.de");
		ali.put("Petra", "p.mueller@mueller.de");
		ali.put("Bernd", "b.mueller@mueller.de");
		
		//String[] _keySet = (String[]) ali.keySet().toArray();
		//for (int _i = 0; _i < _keySet.length; _i++) {
		//	String key = _keySet[_i];
		//	//...
		//}
		
		for (String key : ali.keySet()) {
			//...
		}
		
		
		String[] keyArray = ali.keySet().toArray(new String[] {});
		
		Arrays.sort(keyArray, null);
		
		for (String key : keyArray) {
			String value = ali.get(key);
			System.out.println(key + " --> " + value);
		}
		
		
//		String[] unserArray = new String[] { "Apfel", "Birne", "Orange" };
//		
//		for (int i = 0; i < unserArray.length; i++) {
//			String element = unserArray[i];
//			// dein Code
//		}
//		
//		for (String element : unserArray) {
//			// dein Code
//		}

	}

}
