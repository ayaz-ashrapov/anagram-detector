# Anagram Detector

Small program to detect anagrams and list all anagrams for the input string.

## Table of Contents

- [Assumptions](#assumptions)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Running tests](#running-tests)
- [License](#license)

## Assumptions

This program is implemented with the focus on simplicity.
Following assumptions were done during the implementation:
- Only single-line strings are considered as the input. If you want to work with multiline strings - see open issues
- For the second feature aka list-all-anagrams the program checks if the input string was entered before. 
So, if you enter a string that was not saved as an anagram - you will get the empty list.

## Features

- Checks if two texts are anagrams of each other following the definition of anagram from [Wikipedia](https://en.wikipedia.org/wiki/Anagram)
- Out of all inputs to feature #1: provides all the anagrams for a given string. Given these hypothetical invocations of the feature#1 function -> f1(A, B), f1(A, C), f1(A, D) IF A, B and D are anagrams
*     f2(A) should return [B, D] 
*     f2(B) should return [A, D] 
*     f2(C) should return []

## Installation
To get started with this project, clone the repository and navigate to the project

```sh
git clone https://github.com/ayaz-ashrapov/anagram-detector.git
cd anagram-detector
```

## Usage

To build the project, use the following command:

```sh
./gradlew build
```
To run the application, use:

```sh
./gradlew run -q --console=plain
```

## Running Tests

This project includes unit tests. To run the tests, use:

```sh
./gradlew test
```

## License

This software is provided as is. Use it on your own risk.
