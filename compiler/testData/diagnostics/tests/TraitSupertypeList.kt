open class bar()

trait Foo<!CONSTRUCTOR_IN_TRAIT!>()<!> : bar<!SUPERTYPE_INITIALIZED_IN_TRAIT!>()<!>, <!MANY_CLASSES_IN_SUPERTYPE_LIST, SUPERTYPE_APPEARS_TWICE!>bar<!>, <!MANY_CLASSES_IN_SUPERTYPE_LIST, SUPERTYPE_APPEARS_TWICE!>bar<!> {
}

trait Foo2 : bar, Foo {
}

open class Foo1() : bar(), <!SUPERTYPE_NOT_INITIALIZED_DEFAULT, MANY_CLASSES_IN_SUPERTYPE_LIST, SUPERTYPE_APPEARS_TWICE!>bar<!>, Foo, <!SUPERTYPE_APPEARS_TWICE!>Foo<!><!NO_CONSTRUCTOR!>()<!> {}
open class Foo12 : bar(), <!SUPERTYPE_NOT_INITIALIZED_DEFAULT, MANY_CLASSES_IN_SUPERTYPE_LIST, SUPERTYPE_APPEARS_TWICE!>bar<!> {}