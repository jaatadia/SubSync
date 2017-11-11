package org.jaatadia.subsync.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.*;

public class SubtitleGroupTest {

    private Vector<Vector<String>> origv;
    private Vector<Vector<String>> expected1v;
    private Vector<Vector<String>> expected2v;
    private Vector<Vector<String>> expected3v;

    @Before
    public void setUp() throws Exception {


        origv = new Vector<>();
        Vector<String> origvr1 = new Vector<>();
        Vector<String> origvr2 = new Vector<>();
        Vector<String> origvr3 = new Vector<>();
        Vector<String> origvr4 = new Vector<>();
        origv.add(origvr1);
        origv.add(origvr2);
        origv.add(origvr3);
        origv.add(origvr4);
        origvr1.add("1");origvr1.add("00:00:01,723 --> 00:00:02,723");origvr1.add("foo");
        origvr2.add("2");origvr2.add("00:00:02,723 --> 00:00:03,723");origvr2.add("foo");
        origvr3.add("3");origvr3.add("00:00:03,723 --> 00:00:04,723");origvr3.add("foo");
        origvr4.add("4");origvr4.add("00:00:04,723 --> 00:00:05,723");origvr4.add("foo");

        expected1v = new Vector<>();
        Vector<String> expected1vr1 = new Vector<>();
        Vector<String> expected1vr2 = new Vector<>();
        Vector<String> expected1vr3 = new Vector<>();
        Vector<String> expected1vr4 = new Vector<>();
        expected1v.add(expected1vr1);
        expected1v.add(expected1vr2);
        expected1v.add(expected1vr3);
        expected1v.add(expected1vr4);
        expected1vr1.add("1");expected1vr1.add("00:00:02,723 --> 00:00:03,723");expected1vr1.add("foo");
        expected1vr2.add("2");expected1vr2.add("00:00:03,723 --> 00:00:04,723");expected1vr2.add("foo");
        expected1vr3.add("3");expected1vr3.add("00:00:04,723 --> 00:00:05,723");expected1vr3.add("foo");
        expected1vr4.add("4");expected1vr4.add("00:00:05,723 --> 00:00:06,723");expected1vr4.add("foo");

        expected2v = new Vector<>();
        Vector<String> expected2vr1 = new Vector<>();
        Vector<String> expected2vr2 = new Vector<>();
        Vector<String> expected2vr3 = new Vector<>();
        Vector<String> expected2vr4 = new Vector<>();
        expected2v.add(expected2vr1);
        expected2v.add(expected2vr2);
        expected2v.add(expected2vr3);
        expected2v.add(expected2vr4);
        expected2vr1.add("1");expected2vr1.add("00:00:01,723 --> 00:00:02,723");expected2vr1.add("foo");
        expected2vr2.add("2");expected2vr2.add("00:00:03,723 --> 00:00:04,723");expected2vr2.add("foo");
        expected2vr3.add("3");expected2vr3.add("00:00:04,723 --> 00:00:05,723");expected2vr3.add("foo");
        expected2vr4.add("4");expected2vr4.add("00:00:05,723 --> 00:00:06,723");expected2vr4.add("foo");

        expected3v = new Vector<>();
        Vector<String> expected3vr1 = new Vector<>();
        Vector<String> expected3vr2 = new Vector<>();
        Vector<String> expected3vr3 = new Vector<>();
        Vector<String> expected3vr4 = new Vector<>();
        expected3v.add(expected3vr1);
        expected3v.add(expected3vr2);
        expected3v.add(expected3vr3);
        expected3v.add(expected3vr4);
        expected3vr1.add("1");expected3vr1.add("00:00:01,723 --> 00:00:02,723");expected3vr1.add("foo");
        expected3vr2.add("2");expected3vr2.add("00:00:03,723 --> 00:00:04,723");expected3vr2.add("foo");
        expected3vr3.add("3");expected3vr3.add("00:00:04,723 --> 00:00:05,723");expected3vr3.add("foo");
        expected3vr4.add("4");expected3vr4.add("00:00:04,723 --> 00:00:05,723");expected3vr4.add("foo");

    }


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
        assertEquals(expected1v,o.toVector());

        o = new SubtitleGroup(orig);
        o.synchronize(1000,2);
        assertEquals(expected2,o.toString());
        assertEquals(expected2v,o.toVector());

        o = new SubtitleGroup(orig);
        o.synchronize(1000,2,3);
        assertEquals(expected3,o.toString());
        assertEquals(expected3v,o.toVector());


        o = new SubtitleGroup(origv);
        o.synchronize(1000,-1,500);
        assertEquals(expected1,o.toString());
        assertEquals(expected1v,o.toVector());


        o = new SubtitleGroup(origv);
        o.synchronize(1000);
        assertEquals(expected1,o.toString());
        assertEquals(expected1v,o.toVector());

        o = new SubtitleGroup(origv);
        o.synchronize(1000,2);
        assertEquals(expected2,o.toString());
        assertEquals(expected2v,o.toVector());

        o = new SubtitleGroup(origv);
        o.synchronize(1000,2,3);
        assertEquals(expected3,o.toString());
        assertEquals(expected3v,o.toVector());


        o = new SubtitleGroup(origv);
        o.synchronize(1000,-1,500);
        assertEquals(expected1,o.toString());
        assertEquals(expected1v,o.toVector());
    }



}