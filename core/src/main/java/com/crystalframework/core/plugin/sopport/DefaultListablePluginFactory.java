package com.crystalframework.core.plugin.sopport;

import com.crystalframework.core.plugin.PluginException;
import com.crystalframework.core.plugin.config.PluginDefinition;
import com.crystalframework.core.plugin.config.PluginDefinitionRegistry;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tan
 * @version 1.0 2023/2/16
 */
public class DefaultListablePluginFactory extends AbstractAutowireLoadPluginFactory implements PluginDefinitionRegistry {
    private final Map<String, PluginDefinition> pluginDefinitionMap = new HashMap<>();

    @Override
    protected PluginDefinition getPluginDefinition(String pluginName) throws PluginException {
        var pluginDefinition = pluginDefinitionMap.get(pluginName);
        if (pluginDefinition == null) throw new PluginException("No plugin named '" + pluginName + "' is defined");
        return pluginDefinition;
    }

    @Override
    public void registerPluginDefinition(PluginDefinition pluginDefinition) {
        Assert.notNull(pluginDefinition, "Plugin Definition must not be null");
        Assert.notNull(pluginDefinition.getPluginName(), "Plugin name must not be null");
        Assert.notNull(pluginDefinition.getUrl(), "Singleton ClassLoader must not be null");
        synchronized (this.pluginDefinitionMap) {
            pluginDefinitionMap.put(pluginDefinition.getPluginName(), pluginDefinition);
        }
    }

    @Override
    protected void destroyPluginDefinition(String pluginName) throws PluginException {
        pluginDefinitionMap.remove(pluginName);
    }
}
