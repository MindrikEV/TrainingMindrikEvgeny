package org.senlatraining.property.worker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;

public class ConfigWorker {
	private static final Logger log = Logger.getLogger(ConfigWorker.class);
	private final String PATH_TO_PROPERTIES = "config.properties";
	private org.senlatraining.autoservice.util.Properties properties;
	
	private Properties property = new Properties();
	
	public void initProperties() throws IOException{
		try {
			FileInputStream fis = new FileInputStream(PATH_TO_PROPERTIES);
			property.load(fis);
			properties.setAddebleOfGarage(Boolean.valueOf(property.getProperty("addebleOfGarage")));
			properties.setRemovebleOfGarage(Boolean.valueOf(property.getProperty("removebleOfGarage")));
			properties.setMovableOfOrder(Boolean.valueOf(property.getProperty("movableOfOrder")));
			properties.setRemovebleOfOrder(Boolean.valueOf(property.getProperty("removebleOfOrder")));
		} catch (FileNotFoundException fnfe){
			log.error(fnfe);
		}
	}
}
