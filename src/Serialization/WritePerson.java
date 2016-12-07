/**
 * 
 */
package Serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import Serialization.Person;

/**
 * @author blessonm
 *
 */
public class WritePerson {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		FileOutputStream fs = new FileOutputStream("Persons.ser");
		ObjectOutputStream out = new ObjectOutputStream(fs);
		Person person = new Person();
		person.setId(0);
		person.setName("Blesson");
		out.writeObject(person);
		out.close();
	}

}
