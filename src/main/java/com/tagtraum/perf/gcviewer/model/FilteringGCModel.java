package com.tagtraum.perf.gcviewer.model;

import java.util.Date;

public class FilteringGCModel extends DefaultGCModel {
    private final double filtered;

    public FilteringGCModel(double filtered) {
        this.filtered = filtered;
    }

    @Override
    public void add(AbstractGCEvent<?> abstractEvent) {
        double timestamp = abstractEvent.getTimestamp();
        if (timestamp >= filtered) {
            super.add(abstractEvent);
        }
    }
}
