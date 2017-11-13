package org.jaatadia.subsync.controller.range;

import org.jaatadia.subsync.model.SubtitleTable;

public class RangeModeAll implements RangeMode {
    @Override
    public void sync(SubtitleTable s, int millis) {
        s.synchronize(millis);
    }
}