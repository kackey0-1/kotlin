/*
 * Copyright 2010-2018 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

@file:JvmName("FlagsKt")

package kotlinx.metadata

import kotlinx.metadata.internal.FlagImpl

/**
 * Declaration flags are represented as bitmasks of this type.
 *
 * @see Flag
 */
@Deprecated(
    "Flags API is deprecated and this typealias will be removed. Use Int directly and then migrate to corresponding Km nodes extensions, e.g. KmClass.visibility",
    ReplaceWith("Int")
)
typealias Flags = Int

/**
 * Combines several flags into an integer bitmask.
 *
 * Note that in case several mutually exclusive flags are passed (for example, several visibility flags), the resulting bitmask will
 * hold the value of the latest flag. For example, `flagsOf(Flag.IS_PRIVATE, Flag.IS_PUBLIC, Flag.IS_INTERNAL)` is the same as
 * `flagsOf(Flag.IS_INTERNAL)`.
 */
@Suppress("DEPRECATION")
@Deprecated(
    "Flags API is deprecated and this function will be removed. Create Km nodes directly and then use corresponding Km nodes extensions, e.g. KmClass.visibility",
)
fun flagsOf(vararg flags: Flag): Int =
    flags.fold(0) { acc, flag -> (flag as FlagImpl) + acc }
