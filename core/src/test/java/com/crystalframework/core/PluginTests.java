package com.crystalframework.core;

import com.crystalframework.core.plugin.PluginManager;

import java.net.URLClassLoader;

/**
 * @author Tan
 * @version 1.0 2023/3/7
 */
public class PluginTests {

    public static void main(String[] args) throws Exception {
        PluginManager.registerPlugin("simple", "file:/Users/tan/workspace/lz/crystal/simple-extend/build/libs/simple-extend-1.0-SNAPSHOT-plain.jar");
        URLClassLoader classLoader = PluginManager.getPlugin("simple");
        var clazz = classLoader.loadClass("com.crystalframework.simple.extend.MusicExtendImpl");
        var instance = clazz.getDeclaredConstructor().newInstance();
        var method = clazz.getMethod("playBefore", String.class);
        method.invoke(instance, "Hello");
    }

//
//    public static void main(String[] args) throws Exception {
//        ModuleFinder.of(Path.of(""));
//        // 加载插件
//        var classLoader = new URLClassLoader(new URL[]{new URL("file:/Users/tan/workspace/lz/crystal/simple-extend/build/libs/simple-extend-1.0-SNAPSHOT-plain.jar")});
//        Class<?> pluginClass = classLoader.loadClass("org.crystalframework.simple.extend.Hello");
//        Object plugin = pluginClass.newInstance();
//
//        // 调用插件方法
//        Method pluginMethod = pluginClass.getMethod("hello",String.class);
//        pluginMethod.invoke(plugin,"crystal");
//
//        // 将插件ClassLoader中的类添加到主线程ClassLoader中
//        URL[] urls = ((URLClassLoader) pluginClass.getClassLoader()).getURLs();
//        for (URL url : urls) {
//            ClassLoader.getSystemClassLoader().loadClass("file:/Users/tan/workspace/lz/crystal/simple-extend/build/libs/simple-extend-1.0-SNAPSHOT-plain.jar");
//        }
//    }

}
