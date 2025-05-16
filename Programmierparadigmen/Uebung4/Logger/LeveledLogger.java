package Uebung4.Logger;

class LeveledLogger extends LoggerDeco {
	public LeveledLogger(LogLevel level, Logger deco) {
		super(level, deco);
	}
	
	@Override
	public void log(LogLevel level, String format, Object... args) {
		if (level.compareTo(super.level) >= 0) {
			super.log(level, format, args);
		}
	}
}
