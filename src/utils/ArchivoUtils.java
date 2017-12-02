package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.hibernate.boot.archive.spi.ArchiveException;

import excepciones.ArchivoException;

public class ArchivoUtils
{
	public static byte[] getArchivoArray(String uri) throws ArchivoException {
		byte[] fileContent = null;
		
		File file = new File(uri);
		FileInputStream fin = null;
		try {
			// create FileInputStream object
			fin = new FileInputStream(file);

			fileContent = new byte[(int)file.length()];
			
			// Reads up to certain bytes of data from this input stream into an array of bytes.
			fin.read(fileContent);
		}
		catch (FileNotFoundException e) {
			throw new ArchivoException("No se pudo leer el archivo.\n" + e);
		}
		catch (IOException ioe) {
			throw new ArchivoException("No se pudo leer el archivo.\n" + ioe);
		}
		finally {
			// close the streams using close method
			try {
				if (fin != null) {
					fin.close();
				}
			}
			catch (IOException ioe) {
				throw new ArchivoException("No se pudo leer el archivo.\n" + ioe);
			}
		}
		
		return fileContent;
	}
}
