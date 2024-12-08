package Utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropertiesFile
{

	static Properties prop;
	static String valve = null;

	public static String getValve(String key) 
	{

		try
		{

			FileInputStream input = new FileInputStream(Variables.locProject + "/src/main/resources/Application.config");

			prop = new Properties();
			prop.load(input);

			valve = prop.getProperty(key);
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}

		return valve;
	}




}