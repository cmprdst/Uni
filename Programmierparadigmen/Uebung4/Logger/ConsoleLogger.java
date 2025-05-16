package Uebung4.Logger;

class ConsoleLogger extends LoggerDeco {
	public ConsoleLogger(Logger deco) {
		super(deco);
	}
	
	@Override
	public void log(LogLevel level, String format, Object... args) {
		System.out.printf((format) + "%n", args);
		super.log(level, format, args);
	}
}
