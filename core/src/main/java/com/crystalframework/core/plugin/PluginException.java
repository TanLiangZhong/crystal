package com.crystalframework.core.plugin;

/**
 * @author Tan
 * @version 1.0 2023/3/6
 */
public class PluginException extends RuntimeException {
    public PluginException(String message) {
        super(message);
    }

    public PluginException(Throwable cause) {
        super(cause);
    }
}

