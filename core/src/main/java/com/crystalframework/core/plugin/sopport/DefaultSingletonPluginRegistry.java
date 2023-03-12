package com.crystalframework.core.plugin.sopport;

import com.crystalframework.core.plugin.config.SingletonPluginRegistry;
import org.springframework.util.Assert;

import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Tan
 * @version 1.0 2023/3/7
 */
public class DefaultSingletonPluginRegistry implements SingletonPluginRegistry {

    private final Map<String, URLClassLoader> singletonClassLoaders = new HashMap<>(16);

    @Override
    public URLClassLoader getSingleton(String pluginName) {
        return singletonClassLoaders.get(pluginName);
    }

    protected void registerSingleton(String pluginName, URLClassLoader classLoader) {
        Assert.notNull(pluginName, "Plugin name must not be null");
        Assert.notNull(classLoader, "Singleton ClassLoader must not be null");
        synchronized (this.singletonClassLoaders) {
            singletonClassLoaders.put(pluginName, classLoader);
        }
    }

    protected void destroySingletons(String pluginName) {
        synchronized (this.singletonClassLoaders) {
            singletonClassLoaders.remove(pluginName);
        }
    }

}
