package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties properties;

	String path = ".\\src\\test\\resources\\config.properties";

	//constructor
	public ReadConfig() {
		try {
			properties = new Properties();


			//to open config .properties file in input mode and load the file
			FileInputStream  file = new FileInputStream(path);
			properties.load(file);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public String getBrowser()
	{
		String value = properties.getProperty("browser");

		if(value!=null)
			return value;
		else
			throw new RuntimeException("url not specified in config file.");

	}

}
