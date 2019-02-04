package chap09_interfaces.interfaceprocessor;

import chap09_interfaces.filters.*;

class FilterAdapter implements Processor {
    Filter filter;

    public FilterAdapter(Filter filter) {
        this.filter = filter;
    }

    public String name() {
        return filter.name();
    }

    public Waveform process(Object input) {
        return filter.process((Waveform) input);
    }
}
