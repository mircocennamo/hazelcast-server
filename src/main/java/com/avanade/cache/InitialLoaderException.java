package com.avanade.cache;

/**
 * @author mirco.cennamo on 04/12/2023
 * @project hazelcast-server
 */
public class InitialLoaderException
        extends RuntimeException {
    public InitialLoaderException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public InitialLoaderException(String errorMessage) {
        super(errorMessage);
    }
}
