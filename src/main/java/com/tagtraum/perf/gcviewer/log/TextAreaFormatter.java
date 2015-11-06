package com.tagtraum.perf.gcviewer.log;

import com.tagtraum.perf.gcviewer.util.ResourceUtils;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.io.IOException;
import java.io.StringWriter;
import java.io.PrintWriter;

/**
 * TextAreaFormatter.
 *
 * @author <a href="mailto:hs@tagtraum.com">Hendrik Schreiber</a>
 */
public class TextAreaFormatter extends Formatter {
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public String format(LogRecord record) {
        StringBuffer sb = new StringBuffer();
        sb.append(record.getLevel().getLocalizedName());
        sb.append(" [");
        final String logger = record.getLoggerName();
        sb.append(logger.substring(logger.lastIndexOf('.') + 1));
        sb.append("]: ");
        sb.append(record.getMessage());
        sb.append(LINE_SEPARATOR);
        if (record.getThrown() != null) {
            StringWriter sw = null;
            PrintWriter pw = null;
            try {
                sw = new StringWriter();
                pw = new PrintWriter(sw);

                record.getThrown().printStackTrace(pw);
                sb.append(sw.toString());
            }
            finally {
                ResourceUtils.closeQuitly(sw);
                ResourceUtils.closeQuitly(pw);
            }

        }
        return sb.toString();
    }
}
