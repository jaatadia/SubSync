package org.jaatadia.subsync.controller.delay;

import org.jaatadia.subsync.model.SubtitleTable;
import org.jaatadia.subsync.view.DelayPanel;

public class DelayModeTimeStamp implements DelayMode{

    private DelayPanel delayPanel;

    public DelayModeTimeStamp(DelayPanel delayPanel) {
        this.delayPanel = delayPanel;
    }

    private int timeStampMilis(){
        int hs = delayPanel.spinnerModelHs.getNumber().intValue();
        int min = delayPanel.spinnerModelMin.getNumber().intValue();
        int sec = delayPanel.spinnerModelSec.getNumber().intValue();
        int millis = delayPanel.spinnerModelMillis.getNumber().intValue();
        return hs*3600000+min*60000+sec*1000+millis;
    }

    @Override
    public int getDelay(SubtitleTable s) {
        return getDelay(s,1);
    }

    @Override
    public int getDelay(SubtitleTable s, int from) {
        return timeStampMilis() - s.getSubs().get(from-1).getTimeRange().start.toMillis() ;
    }
}
