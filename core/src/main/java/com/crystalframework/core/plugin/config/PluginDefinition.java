package com.crystalframework.core.plugin.config;

/**
 * @author Tan
 * @version 1.0 2023/3/6
 */
public class PluginDefinition {

    private String pluginName;

    private String url;

    public PluginDefinition() {
    }

    public PluginDefinition(String pluginName, String url) {
        this.pluginName = pluginName;
        this.url = url;
    }

    public String getPluginName() {
        return pluginName;
    }

    public void setPluginName(String pluginName) {
        this.pluginName = pluginName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
