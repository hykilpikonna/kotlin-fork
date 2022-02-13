/*
 * Copyright 2010-2022 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.gradle.kpm

import org.jetbrains.kotlin.gradle.kpm.idea.InternalKotlinGradlePluginApi
import java.io.Serializable

interface KotlinHasExternalModel {
    val external: KotlinExternalModelContainer
}

abstract class KotlinExternalModelContainer internal constructor() : Serializable {
    abstract operator fun <T : Any> contains(key: KotlinExternalModelKey<T>): Boolean
    abstract operator fun <T : Any> get(key: KotlinExternalModelKey<T>): T?
    fun <T : Any> getOrThrow(key: KotlinExternalModelKey<T>): T = get(key)
        ?: throw NoSuchElementException("Missing external model for ${key.id}")

    @InternalKotlinGradlePluginApi
    companion object {
        fun mutable(): KotlinMutableExternalModelContainer = KotlinMutableExternalModelContainerImpl()
    }

    object Empty : KotlinExternalModelContainer() {
        override fun <T : Any> contains(key: KotlinExternalModelKey<T>): Boolean = false
        override fun <T : Any> get(key: KotlinExternalModelKey<T>): T? = null
    }
}

abstract class KotlinMutableExternalModelContainer internal constructor() : KotlinExternalModelContainer() {
    abstract operator fun <T : Any> set(key: KotlinExternalModelKey<T>, value: T)
}
