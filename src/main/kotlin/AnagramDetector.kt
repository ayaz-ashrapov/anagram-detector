package com.ashrapov

import java.util.*
import kotlin.collections.HashSet

class AnagramDetector(private val anagrams: MutableMap<String, MutableSet<String>>) {

    fun isAnagram(first: String, second: String): Boolean{
        if (first.length != second.length) return false

        val sortedFirst: String = sortLexicographically(first)
        val sortedSecond: String = sortLexicographically(second)

        if (sortedFirst != sortedSecond) return false

        val set = anagrams.getOrDefault(sortedFirst, HashSet())
        set.add(first)
        set.add(second)
        anagrams[sortedFirst] = set

        return true
    }

    fun getAllAnagrams(input: String): Set<String>{
        val allAnagrams = HashSet(anagrams.getOrDefault(sortLexicographically(input), Collections.emptySet()))

        if(!allAnagrams.contains(input)) {
            return emptySet()
        }

        allAnagrams.remove(input)

        return allAnagrams
    }


    private fun sortLexicographically(str: String): String {
        val sortedChars = str.toCharArray()
        sortedChars.sort()
        return String(sortedChars)
    }
}