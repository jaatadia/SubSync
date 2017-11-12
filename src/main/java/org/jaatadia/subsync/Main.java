package org.jaatadia.subsync;

import org.jaatadia.subsync.controller.Controller;
import org.jaatadia.subsync.view.MainWindow;

public class Main {
    public static void main(String[] args) {
        new Controller(new MainWindow());
    }
}
