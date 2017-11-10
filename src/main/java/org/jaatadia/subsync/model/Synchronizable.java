package org.jaatadia.subsync.model;

public interface Synchronizable {

    //applies synchronization and returns itself
    Synchronizable synchronize(int milliseconds);
}
