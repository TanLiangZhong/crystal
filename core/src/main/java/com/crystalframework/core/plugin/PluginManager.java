package com.crystalframework.core.plugin;

import com.crystalframework.core.plugin.config.PluginDefinition;
import com.crystalframework.core.plugin.sopport.DefaultListablePluginFactory;

import java.net.URLClassLoader;

/**
 * @author Tan
 * @version 1.0 2023/3/10
 */
public class PluginManager {

    private final static DefaultListablePluginFactory FACTORY = new DefaultListablePluginFactory();

    public static void registerPlugin(String pluginName, String url) {
        FACTORY.registerPluginDefinition(new PluginDefinition(pluginName, url));
    }

    public static void unload(String pluginName) {
        FACTORY.destroyPlugin(pluginName);
    }

    public static URLClassLoader getPlugin(String pluginName) {
        return FACTORY.getPlugin(pluginName);
    }


}
