import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class Library {


	private final static Logger LOG = LogManager.getLogger();


	public static void main(String[] args) throws IOException {

		ClassLoader cl = ClassLoader.getSystemClassLoader();
		URL[] urls = ((URLClassLoader) cl).getURLs();
		for (URL url : urls) {
			LOG.info(url.getFile());
		}


		final Properties properties = new Properties();

		URL resource = Library.class.getResource("/database.properties");
		if (resource == null || !(new File(resource.getFile()).exists())) {
			throw new IOException("File not found");
		}

		try (final InputStream stream = Library.class.getResourceAsStream("database.properties")) {
			properties.load(stream);
		}


		for (Entry<Object, Object> entry : properties.entrySet()) {
			LOG.info(entry.getKey() + " - " + entry.getValue());
		}
	}
}
