package ru.sber.generics


// 1.
fun <K, V> compare(p1: Pair<K, V>, p2: Pair<K, V>): Boolean {
   return p1.first == p2.first &&  p1.second == p2.second
}

// 2.
fun <T: Comparable<T>> countGreaterThan(anArray: Array<T>, elem: T): Int {
   var count = 0
   anArray.forEach {
       if(it > elem)
           count ++
   }
    return count
}

// 3.
class Sorter<T: Comparable<T>> {
    val list: MutableList<T> = mutableListOf()

    fun add(value:T){
        list.add(value)
        list.sort()
    }
}

// 4.
class Stack<T> {
    val stack: MutableList<T> = mutableListOf()

    fun push(v: T) = stack.add(v)

    fun pop(): T = stack.removeLast()

    fun isEmpty(): Boolean = stack.isEmpty()

    fun peek(): T = stack.last()

    fun size(): Int = stack.size
}
