package org.jaatadia.subsync.controller.range;

import org.jaatadia.subsync.model.SubtitleTable;

public interface RangeMode {
    void sync(SubtitleTable s, int millis);
}