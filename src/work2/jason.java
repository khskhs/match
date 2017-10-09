package work2;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import com.google.gson.Gson;

public class jason {
	public static void main(String[] args) throws Exception {
		
	
	File input = new File(System.getProperty("user.dir")+"\\input_data");
	File output = new File(System.getProperty("user.dir")+"\\output_data");
	
	FileWriter writer = new FileWriter(output);
	FileReader reader = new FileReader(input);
	
	Gson gson = new Gson();
	bean b =(work2.bean) gson.fromJson(reader,bean.class);
	out ou=null;
	ou=match.result(b);
	
	String o =gson.toJson(ou);
	//String s=gson.toJson(b);
	writer.write(o);
	writer.flush();
	reader.close();
	writer.close();
	
	
	
	
	}
}
