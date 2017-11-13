package org.jaatadia.subsync.controller.range;

import org.jaatadia.subsync.controller.delay.DelayMode;
import org.jaatadia.subsync.model.SubtitleTable;

public class RangeModeAll implements RangeMode {
    @Override
    public void sync(SubtitleTable s, DelayMode dMode) {
        s.synchronize(dMode.getDelay(s));
    }
}