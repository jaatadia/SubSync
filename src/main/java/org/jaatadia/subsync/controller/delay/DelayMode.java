package org.jaatadia.subsync.controller.delay;

import org.jaatadia.subsync.model.SubtitleTable;

public interface DelayMode {
    int getDelay(SubtitleTable s);
    int getDelay(SubtitleTable s,int from);
}
