package com.ashrapov

import java.io.BufferedReader
import java.io.InputStreamReader

enum class COMMANDS {CHECK , LIST, EXIT}

fun main() {
    val anagramDetector = AnagramDetector(HashMap())
    val greeting = """Welcome!
        |type 'check' to check if two strings are anagrams
        |type 'list' to get all anagrams for a given string
        |type 'exit' to quit
        |""".trimMargin()
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val allCommands = COMMANDS.entries.joinToString(", ") { it.name.lowercase() }

    println(greeting)
    while (true){
        println("enter your command:")
        val input = reader.readLine()
        if(input == null) {
            println("input is empty - terminating the program")
            break
        }
        try {
            val command = COMMANDS.valueOf(input.uppercase())

            if (command == COMMANDS.CHECK){
                println("enter first string:")
                val first = reader.readLine()
                println("enter second string:")
                val second = reader.readLine()
                println("checking...")
                if(anagramDetector.isAnagram(first, second)) {
                    println("TRUE: input strings are anagrams")
                } else {
                    println("FALSE: input strings are NOT anagrams")
                }

            } else if(command == COMMANDS.LIST) {
                println("enter the string to get all its anagrams recorded previously")
                val key = reader.readLine()
                println("listing all anagrams for the given string:")
                val anagrams = anagramDetector.getAllAnagrams(key)
                if(anagrams.isNotEmpty()){
                    for (anagram in anagrams){
                        println(anagram)
                    }
                } else {
                    println()
                }
            } else {
                println("terminating...")
                break
            }
        } catch (iae: IllegalArgumentException){
            println("available commands are: $allCommands")
        }
    }
}