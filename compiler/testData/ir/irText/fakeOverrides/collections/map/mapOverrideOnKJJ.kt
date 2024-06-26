// TARGET_BACKEND: JVM
// FULL_JDK
// WITH_STDLIB
// SEPARATE_SIGNATURE_DUMP_FOR_K2
// ^ ISSUE: KT-65667

// FILE: Java1.java
import java.util.SortedMap;

abstract public class Java1 implements SortedMap<Object, Object> {}

// FILE: 1.kt
abstract class A : Java1()

abstract class B(override val size: Int) : Java1() {
    override fun put(key: Any?, value: Any?): Any? {
        return null
    }

    override fun remove(key: Any?): Any? {
        return null
    }
}

fun test(a: A, b: B) {
    a.size
    a[true] = true
    a.put(null, null)
    a.get(true)
    a.get(null)
    a.remove(null)
    a.remove(true)

    b.size
    b.put(false, false)
    b.put(null, null)
    b[null] = null
    b[true] = true
    b.get(null)
    b.get(true)
    b.remove(null)
    b.remove(true)
}