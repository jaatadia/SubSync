package org.jaatadia.subsync.controller.range;

import org.jaatadia.subsync.controller.delay.DelayMode;
import org.jaatadia.subsync.model.SubtitleTable;
import org.jaatadia.subsync.view.RangePanel;

import javax.swing.*;

public class RangeModeFrom implements RangeMode {

    private SpinnerNumberModel from;

    public RangeModeFrom(RangePanel panel){
        this.from=panel.spinnerModelFrom;
    }

    @Override
    public void sync(SubtitleTable s, DelayMode dMode) {
        int intFrom = from.getNumber().intValue();
        s.synchronize(dMode.getDelay(s,intFrom), intFrom);
    }
}