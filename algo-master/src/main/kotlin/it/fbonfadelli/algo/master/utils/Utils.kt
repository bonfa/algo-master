package it.fbonfadelli.algo.master.utils

fun IntArray.print() =
    "[" + this.joinToString((",")) + "]"

fun <T> List<T>.print() =
    "[" + this.joinToString((",")) + "]"