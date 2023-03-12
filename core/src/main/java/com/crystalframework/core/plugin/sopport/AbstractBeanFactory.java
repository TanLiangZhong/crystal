package com.crystalframework.core.plugin.sopport;

import com.crystalframework.core.plugin.PluginException;
import com.crystalframework.core.plugin.PluginFactory;
import com.crystalframework.core.plugin.config.PluginDefinition;

import java.net.URLClassLoader;

/**
 * @author Tan
 * @version 1.0 2023/3/7
 */
public abstract class AbstractBeanFactory extends DefaultSingletonPluginRegistry implements PluginFactory {

    @Override
    public URLClassLoader getPlugin(String pluginName) {
        var classLoader = getSingleton(pluginName);
        if (classLoader != null) {
            return classLoader;
        }
        var pluginDefinition = getPluginDefinition(pluginName);
        return loadPlugin(pluginDefinition);
    }

    public void destroyPlugin(String pluginName) {
        destroySingletons(pluginName);
        destroyPluginDefinition(pluginName);
    }

    protected abstract PluginDefinition getPluginDefinition(String pluginName) throws PluginException;
    
    protected abstract void destroyPluginDefinition(String pluginName) throws PluginException;

    protected abstract URLClassLoader loadPlugin(PluginDefinition pluginDefinition) throws PluginException;


}
