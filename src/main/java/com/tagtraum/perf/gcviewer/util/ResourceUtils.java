package com.tagtraum.perf.gcviewer.util;

import java.io.Closeable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ResourceUtils {
    private static final Logger LOGGER = Logger.getLogger(ResourceUtils.class.getName());

    public static void closeQuitly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                LOGGER.log(Level.FINEST, "Error while closing " + closeable, e);
            }
        }
    }
}
