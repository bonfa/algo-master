package it.fbonfadelli.algo.master.utils

fun IntArray.printable() =
    "[" + this.joinToString((",")) + "]"

fun <T> List<T>.printable() =
    "[" + this.joinToString((",")) + "]"