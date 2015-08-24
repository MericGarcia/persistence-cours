package fr.keyconsulting.formation.plugins.dynamic;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class PluginClassLoader extends ClassLoader {
	
	private File binFolder;

	public PluginClassLoader(ClassLoader parent, File binFolder) {
		super(parent);
		this.binFolder = binFolder;
	}

	public Class<?> loadClass(String fullClassName) throws ClassNotFoundException {

		Class<?> clazz;
		
		if (!fullClassName.startsWith("fr.keyconsulting.formation.plugins")) {
			clazz = super.loadClass(fullClassName);
		} 
		else {
			// TODO : complete implementation load Java class from its binary file
			clazz = null;
		}
		return clazz;
	}

	private Class<?> loadClassFromFile(String fullClassName, File binaryClassFile) throws MalformedURLException, IOException, ClassFormatError {
		Class<?> clazz;
		URL classUrl = binaryClassFile.toURI().toURL();
		URLConnection connection = classUrl.openConnection();
		try(InputStream input = new BufferedInputStream(connection.getInputStream());) {
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			int data = input.read();
			while (data != -1) {
				buffer.write(data);
				data = input.read();
			}
			input.close();
			byte[] classData = buffer.toByteArray();

			clazz = defineClass(fullClassName, classData, 0, classData.length);
		}
		return clazz;
	}

}
