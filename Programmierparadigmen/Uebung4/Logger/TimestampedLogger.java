package Uebung4.Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class TimestampedLogger extends LoggerDeco {
	public TimestampedLogger(Logger deco) {
		super(deco);
	}
	
	@Override
	public void log(LogLevel level, String format, Object... args) {
		Object[] newArgs = new Object[args.length + 1];
		newArgs[0] = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		System.arraycopy(args, 0, newArgs, 1, args.length);
		super.log(level, format, newArgs);
	}
}
