package com.tagtraum.perf.gcviewer.imp;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;

import org.junit.Test;

import com.tagtraum.perf.gcviewer.model.GCModel;

/**
 *
 * Date: Jan 30, 2002
 * Time: 5:53:55 PM
 * @author <a href="mailto:hs@tagtraum.com">Hendrik Schreiber</a>
 */
public class TestDataReaderIBM1_3_1 {

    @Test
    public void testParse1() throws Exception {
        InputStream in = UnittestHelper.getResourceAsStream(UnittestHelper.FOLDER_IBM, "SampleIBM1_3_1.txt");
        DataReader reader = new DataReaderIBM1_3_1(in);
        GCModel model = new GCModel();
        reader.read(model);
        
        assertEquals("number of events", 21, model.size());
    }
}
