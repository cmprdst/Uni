package Uebung4.Logger;

enum LogLevel {
	Trace,
	Debug,
	Info,
	Warn,
	Error
}

interface Logger {
	default void trace(String format, Object... args) {
		this.log(LogLevel.Trace, format, args);
	}
	
	default void debug(String format, Object... args) {
		this.log(LogLevel.Debug, format, args);
	}
	
	default void info(String format, Object... args) {
		this.log(LogLevel.Info, format, args);
	}
	
	default void warn(String format, Object... args) {
		this.log(LogLevel.Warn, format, args);
	}
	
	default void error(String format, Object... args) {
		this.log(LogLevel.Error, format, args);
	}
	
	void setLogLevel(LogLevel level);
	
	void log(LogLevel level, String format, Object... args);
}

abstract class LoggerDeco implements Logger {
	protected Logger deco;
	protected LogLevel level;
	
	public LoggerDeco(Logger deco) {
		this.deco = deco;
	}
	
	public LoggerDeco(LogLevel level, Logger deco) {
		this.level = level;
		this.deco = deco;
	}
	
	@Override
	public void setLogLevel(LogLevel level) {
		this.level = level;
		if (deco != null) deco.setLogLevel(level);
	}
	
	@Override
	public void log(LogLevel level, String format, Object... args) {
		deco.log(level, format, args);
	}
}
