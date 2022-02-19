package afterBurner.FileHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {
	
	File file = new File("E:\\StarGateTeam\\AfterBurnerHybridFramework\\src\\test\\java\\afterBurner\\TestData\\GlobalRepository.properties");
	FileInputStream fis ;
	
	public String getProperty(String key)  {
		 try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		Properties properties = new Properties();
		try {
			properties.load(fis);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		String values = properties.getProperty(key);
		return values;
	}
}
