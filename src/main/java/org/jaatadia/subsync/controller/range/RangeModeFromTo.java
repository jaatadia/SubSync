package org.jaatadia.subsync.controller.range;

import org.jaatadia.subsync.controller.delay.DelayMode;
import org.jaatadia.subsync.model.SubtitleTable;
import org.jaatadia.subsync.view.RangePanel;

import javax.swing.*;

public class RangeModeFromTo implements RangeMode {

        private SpinnerNumberModel from;
    private SpinnerNumberModel to;

        public RangeModeFromTo(RangePanel panel){
            this.from=panel.spinnerModelFrom;
            this.to=panel.spinnerModelTo;
        }

        @Override
        public void sync(SubtitleTable s, DelayMode dMode) {
            int intFrom = from.getNumber().intValue();
            s.synchronize(dMode.getDelay(s,intFrom), intFrom,to.getNumber().intValue());
        }
}