package org.jaatadia.subsync.controller.delay;

import org.jaatadia.subsync.model.SubtitleTable;
import org.jaatadia.subsync.view.DelayPanel;

public class DelayModeMillis implements DelayMode {

    private DelayPanel delayPanel;

    public DelayModeMillis(DelayPanel delayPanel) {
        this.delayPanel = delayPanel;
    }

    @Override
    public int getDelay(SubtitleTable s) {
        return delayPanel.spinnerModelDelay.getNumber().intValue();
    }

    @Override
    public int getDelay(SubtitleTable s, int from) {
        return getDelay(s);
    }
}
