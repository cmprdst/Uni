package Uebung4.Logger;

import java.io.FileWriter;
import java.io.IOException;

class FileLogger extends LoggerDeco {
	public FileLogger(Logger deco) {
		super(deco);
	}
	
	@Override
	public void log(LogLevel level, String format, Object... args) {
		// try-with-resources → FileWriter-Objekt Ressource, die das AutoClosable-Interface implementiert und somit
		// nach Abschluss oder bei Fehlschlag automatisch geschlossen wird
		try (FileWriter log = new FileWriter("log", true)) {
			log.write(String.format(format, args) + "\n");
		} catch (IOException e) {
			System.out.println("Creation of log file failed!");
		}
		super.log(level, format, args);
	}
}
