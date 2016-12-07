/**
 * 
 */
package Serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import Serialization.Person;

/**
 * @author blessonm
 *
 */
public class ReadPerson {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fi = new FileInputStream("Persons.ser");
		ObjectInputStream in = new ObjectInputStream(fi);
		Person person = (Person) in.readObject();
		System.out.println(person.getId()+" "+person.getName());
		in.close();
		System.out.println("Working Directory = " +
	              System.getProperty("user.dir"));
	}

}
