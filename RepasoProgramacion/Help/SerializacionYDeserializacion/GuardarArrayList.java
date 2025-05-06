package SerializacionYDeserializacion;

import java.io.*;
import java.util.*;

public class GuardarArrayList {
	
	public static File file = new File("");
	public static ArrayList <?> nombreArrayList = new ArrayList<>();
	
	public static void guardarArrayList() {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(nombreArrayList); // Rellena uno a uno los objetos
		} catch (IOException e) {
			// TODO: handle exception
		}
	}


}
