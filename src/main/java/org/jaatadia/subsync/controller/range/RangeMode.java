package org.jaatadia.subsync.controller.range;

import org.jaatadia.subsync.controller.delay.DelayMode;
import org.jaatadia.subsync.model.SubtitleTable;

public interface RangeMode {
    void sync(SubtitleTable s, DelayMode dMode);
}