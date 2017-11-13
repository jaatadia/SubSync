package org.jaatadia.subsync.controller.range;

import org.jaatadia.subsync.model.SubtitleTable;

import javax.swing.*;

public class RangeModeFromTo implements RangeMode {

        private SpinnerNumberModel from;
    private SpinnerNumberModel to;

        public RangeModeFromTo(SpinnerNumberModel from, SpinnerNumberModel to){
            this.from=from;
            this.to=to;
        }

        @Override
        public void sync(SubtitleTable s, int millis) {
            s.synchronize(millis, from.getNumber().intValue(),to.getNumber().intValue());
        }
}