package configreader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropReader {
	
	private Properties prop;
	private FileInputStream fis ;
	
	public Properties initLangProp()
	{
		//Run the following command from maven 
		//mvn clean install -Dlang="french"
		String language = System.getProperty("lang");
		System.out.println("lang is  : " +  language);
		prop = new Properties();
		switch (language.toLowerCase()) {
		case "english":
			try {
				fis = new FileInputStream("./src/main/resources/lang.english.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "french":
			try {
				fis = new FileInputStream("./src/main/resources/lang.french.properties");
				System.out.println("french loaded");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "russian":
			try {
				fis = new FileInputStream("./src/main/resources/lang.russian.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			System.out.println("language not found : "  + language);
			break;
		}
		
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return prop;
	}

}
