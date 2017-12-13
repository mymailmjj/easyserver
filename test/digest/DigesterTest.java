package digest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.digester3.Digester;
import org.xml.sax.SAXException;

public class DigesterTest {

	public static void main(String[] args) {

		File file = new File(
				"C:\\Users\\cango\\Desktop\\000f\\tomcat\\request.xml.txt");

		Digester digester = new Digester();

		digester.addObjectCreate("student", Student.class);
		digester.addSetProperties("student");

		digester.addObjectCreate("student/subjects", Subjects.class);
		digester.addSetProperties("student/subjects");

		digester.addSetNext("student/subjects", "add");

		try {
			Student student = digester.parse(file);

			ArrayList<Subjects> list = student.getList();
			Iterator<Subjects> iterator = list.iterator();

			System.out.println("---------------------------------------------");

			while (iterator.hasNext()) {
				Subjects next = iterator.next();
				System.out.println(next);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}

	}

}
