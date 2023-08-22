package com.fungiggle.fridatest

import android.util.Log
import dalvik.system.PathClassLoader
import java.io.InputStream

class CustomClassLoader(parent: ClassLoader) : PathClassLoader("", parent) {
    override fun loadClass(className: String, resolve: Boolean): Class<*> {
        if (className.startsWith("com.fungiggle.fridatest.")) {
            val loadedClass = findLoadedClass(className)
            if (loadedClass != null) {
                return loadedClass
            }

            try {
                val classBytes = loadClassBytes(className)
                return defineClass(className, classBytes, 0, classBytes.size)
            } catch (e: ClassNotFoundException) {
                Log.e(TAG,e.toString())
            }
        }

        return super.loadClass(className, resolve)
    }

    private fun loadClassBytes(className: String): ByteArray {
        return fetchClassBytesFromClasspath(className)
    }

    private fun fetchClassBytesFromClasspath(className: String): ByteArray {
        val resourcePath = className.replace('.', '/') + ".class"
        val resourceStream: InputStream? = getResourceAsStream(resourcePath)
        return resourceStream?.readBytes() ?: throw ClassNotFoundException(className)
    }
}
