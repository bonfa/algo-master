package it.fbonfadelli.algo.master.utils

fun IntArray.printable() =
    "[" + this.joinToString(",") + "]"

fun CharArray.printable() =
    "[" + this.joinToString(",") + "]"

fun Array<String>.printable() =
    "[" + this.joinToString(",") + "]"

fun <T> List<T>.printable() =
    "[" + this.joinToString(",") + "]"

fun Array<IntArray>.printable() =
    "[" + this.joinToString(separator = ",", transform = { it.printable() } ) + "]"

fun Array<CharArray>.printable() =
    "[" + this.joinToString(separator = ",", transform = { it.printable() } ) + "]"