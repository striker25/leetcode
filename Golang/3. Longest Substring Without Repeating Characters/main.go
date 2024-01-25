package main

import (
	"fmt"
	"strings"
)

func main() {
	fmt.Println(lengthOfLongestSubstring(" "))
}

// func lengthOfLongestSubstring(s string) int {

// 	count := 0

// 	for i := 0; i < len(s); i++ {
// 		for j := 1; j <= len(s)-1; j++ {
// 			if s[i] == s[j] {
// 				count = 0
// 			}

// 			count++
// 		}
// 	}

// 	return count
// }

func lengthOfLongestSubstring(s string) int {

	if len(s) == 1 { // no need to check
		return 1
	}

	// 1. Create each possible word combination
	// without repeating characters

	combinations := make(map[string][]string)
	for i := 0; i < len(s)-1; i++ {
		letter := string(s[i])

		currentWord := letter
		// mininum value by default
		combinations[letter] = append(combinations[letter], currentWord)

		for j := i + 1; j <= len(s)-1; j++ {
			iterationLetter := string(s[j])

			// first iteration check, no combinations yet
			if i == 0 && j == 1 && iterationLetter != letter {
				currentWord += iterationLetter
				combinations[letter] = append(combinations[letter], currentWord)
			} else if iterationLetter != letter && !strings.Contains(currentWord, iterationLetter) {
				currentWord += iterationLetter
				combinations[letter] = append(combinations[letter], currentWord)
			} else {
				break
			}

		}
	}

	// 2. Find the longest word combination
	max := 0
	for _, c := range combinations {
		for _, v := range c {
			if len(v) > max {
				max = len(v)
			}
		}
	}

	return max
}
