package com.tagtraum.perf.gcviewer.model;

import com.tagtraum.perf.gcviewer.math.DoubleData;
import com.tagtraum.perf.gcviewer.math.IntData;
import com.tagtraum.perf.gcviewer.math.RegressionLine;

import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

public interface GCModel {
    long getLastModified();

    URL getURL();

    void printDetailedInformation();

    void setURL(URL url);

    boolean isDifferent(File otherFile);

    boolean isDifferent(URL otherURL);

    AbstractGCEvent<?> getLastEventAdded();

    Iterator<AbstractGCEvent<?>> getStopTheWorldEvents();

    Iterator<GCEvent> getGCEvents();

    Iterator<AbstractGCEvent<?>> getVmOperationsEvents();

    Iterator<ConcurrentGCEvent> getConcurrentGCEvents();

    Iterator<AbstractGCEvent<?>> getEvents();

    Iterator<GCEvent> getFullGCEvents();

    void add(AbstractGCEvent<?> abstractEvent);

    int size();

    AbstractGCEvent<?> get(int index);

    DoubleData getFullGCPause();

    DoubleData getGCPause();

    DoubleData getVmOperationPause();

    DoubleData getPauseInterval();

    DoubleData getCmsInitiatingOccupancyFraction();

    RegressionLine getRelativePostFullGCIncrease();

    DoubleData getRelativePostGCIncrease();

    double getPostGCSlope();

    RegressionLine getCurrentPostGCSlope();

    RegressionLine getPostFullGCSlope();

    IntData getFreedMemoryByGC();

    IntData getFreedMemoryByFullGC();

    IntData getFootprintAfterGC();

    IntData getFootprintAfterFullGC();

    DoubleData getPause();

    Map<String, DoubleData> getGcEventPauses();

    Map<String, DoubleData> getFullGcEventPauses();

    Map<String, DoubleData> getVmOperationEventPauses();

    Map<String, DoubleData> getConcurrentEventPauses();

    double getThroughput();

    IntData getHeapAllocatedSizes();

    IntData getHeapUsedSizes();

    IntData getPermAllocatedSizes();

    IntData getPermUsedSizes();

    IntData getTenuredAllocatedSizes();

    IntData getTenuredUsedSizes();

    IntData getYoungAllocatedSizes();

    IntData getYoungUsedSizes();

    IntData getPostConcurrentCycleTenuredUsedSizes();

    IntData getPostConcurrentCycleHeapUsedSizes();

    IntData getPromotion();

    long getFootprint();

    double getRunningTime();

    double getFirstPauseTimeStamp();

    double getLastPauseTimeStamp();

    long getFreedMemory();

    DefaultGCModel.Format getFormat();

    void setFormat(DefaultGCModel.Format format);

    boolean hasCorrectTimestamp();

    boolean hasDateStamp();

    Date getFirstDateStamp();
}
