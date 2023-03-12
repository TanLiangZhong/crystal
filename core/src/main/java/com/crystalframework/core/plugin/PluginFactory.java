package com.crystalframework.core.plugin;

import java.net.URLClassLoader;

/**
 * @author Tan
 * @version 1.0 2023/3/7
 */
public interface PluginFactory {

    URLClassLoader getPlugin(String pluginName);

}
