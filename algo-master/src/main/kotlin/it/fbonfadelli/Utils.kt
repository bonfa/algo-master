package it.fbonfadelli

fun IntArray.print() =
    "[" + this.joinToString((",")) + "]"

fun <T> List<T>.print() =
    "[" + this.joinToString((",")) + "]"