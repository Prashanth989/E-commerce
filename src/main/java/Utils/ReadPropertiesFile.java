package Utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropertiesFile {

	static Properties prop;
	static String valve = null;

	public static String getValve(String key) {
		try {

			prop = new Properties();

			FileInputStream input = new FileInputStream(
					Variables.locProject + "/src/main/resources/Application.config");

			prop.load(input);
			valve = prop.getProperty(key);
		}

		catch (Exception e) {
			ReusableMethods.log("Valve is not fetched for the Key: " + key + " " + "Exception got: " + e.getMessage());
			e.printStackTrace();
		}

		return valve;
	}

}
