package org.jaatadia.subsync.controller.range;

import org.jaatadia.subsync.model.SubtitleTable;

import javax.swing.*;

public class RangeModeFrom implements RangeMode {

        private SpinnerNumberModel from;

        public RangeModeFrom(SpinnerNumberModel from){
            this.from=from;
        }

        @Override
        public void sync(SubtitleTable s, int millis) {
            s.synchronize(millis, from.getNumber().intValue());
        }
}