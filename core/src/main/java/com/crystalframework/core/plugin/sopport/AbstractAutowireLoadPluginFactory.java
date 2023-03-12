package com.crystalframework.core.plugin.sopport;

import com.crystalframework.core.plugin.PluginException;
import com.crystalframework.core.plugin.config.PluginDefinition;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author Tan
 * @version 1.0 2023/3/7
 */
public abstract class AbstractAutowireLoadPluginFactory extends AbstractBeanFactory {

    @Override
    protected URLClassLoader loadPlugin(PluginDefinition pluginDefinition) throws PluginException {
        try {
            var classLoader = new URLClassLoader(new URL[]{new URL(pluginDefinition.getUrl())}, Thread.currentThread().getContextClassLoader());
            registerSingleton(pluginDefinition.getPluginName(), classLoader);
            return classLoader;
        } catch (IOException e) {
            throw new PluginException(e);
        }
    }
}
