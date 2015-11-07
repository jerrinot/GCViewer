package com.tagtraum.perf.gcviewer.imp;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;

import com.tagtraum.perf.gcviewer.model.GCModel;
import org.junit.Test;

import com.tagtraum.perf.gcviewer.model.DefaultGCModel;

/**
 *
 * Date: Jan 30, 2002
 * Time: 5:53:55 PM
 * @author <a href="mailto:hs@tagtraum.com">Hendrik Schreiber</a>
 */
public class TestDataReaderSun1_3_1_19 {

    @Test
    public void testCMSPrintGCDetails() throws Exception {
    	// does not seem to be implemented at all
    	
    	final InputStream in = UnittestHelper.getResourceAsStream(UnittestHelper.FOLDER_OPENJDK, "SampleSun1_3_1_19SunOS.txt");
        final DataReader reader = new DataReaderSun1_3_1(in, GcLogType.SUN1_3_1);
        GCModel model = new DefaultGCModel();
        reader.read(model);
        
        assertEquals("throughput", 95.21, model.getThroughput(), 0.01);
    }

}