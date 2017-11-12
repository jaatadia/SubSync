package org.jaatadia.subsync.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubtitleGroupTest {

    private String orig =
            "1\n00:00:01,723 --> 00:00:02,723\nfoo\n\n" +
            "2\n00:00:02,723 --> 00:00:03,723\nfoo\n\n" +
            "3\n00:00:03,723 --> 00:00:04,723\nfoo\n\n" +
            "4\n00:00:04,723 --> 00:00:05,723\nfoo\n\n";

    private String expected1 =
            "1\n00:00:02,723 --> 00:00:03,723\nfoo\n\n" +
            "2\n00:00:03,723 --> 00:00:04,723\nfoo\n\n" +
            "3\n00:00:04,723 --> 00:00:05,723\nfoo\n\n" +
            "4\n00:00:05,723 --> 00:00:06,723\nfoo";

    private String expected2 =
            "1\n00:00:01,723 --> 00:00:02,723\nfoo\n\n" +
            "2\n00:00:03,723 --> 00:00:04,723\nfoo\n\n" +
            "3\n00:00:04,723 --> 00:00:05,723\nfoo\n\n" +
            "4\n00:00:05,723 --> 00:00:06,723\nfoo";

    private String expected3 =
            "1\n00:00:01,723 --> 00:00:02,723\nfoo\n\n" +
            "2\n00:00:03,723 --> 00:00:04,723\nfoo\n\n" +
            "3\n00:00:04,723 --> 00:00:05,723\nfoo\n\n" +
            "4\n00:00:04,723 --> 00:00:05,723\nfoo";

    @Test
    public void synchronize() throws Exception {
        SubtitleGroup o = new SubtitleGroup(orig);
        o.synchronize(1000);
        assertEquals(expected1,o.toString());

        o = new SubtitleGroup(orig);
        o.synchronize(1000,2);
        assertEquals(expected2,o.toString());

        o = new SubtitleGroup(orig);
        o.synchronize(1000,2,3);
        assertEquals(expected3,o.toString());
    }



}