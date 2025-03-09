package main

import (
	"fmt"
	"strings"
)

func main() {
	fmt.Println("5_Longest_Palindromic_Substring")
	fmt.Println(longestPalindrome("babad"))
	// fmt.Println("aaa is palindrome=", isPalindrome("aaa"))
}

func longestPalindrome(s string) string {
	// nothing to do, always a palindrome
	if len(s) == 1 {
		return s
	}

	// auxiliary variables to keep track of the longest palindrome
	// using the same iteration to keep track of the longest palindrome
	maxNum := 0
	maxStr := ""

	// create each possible variation of the given string
	// and use an slice to obtain each substring
	for i := 0; i < len(s); i++ {
		for j := i + 1; j <= len(s); j++ {
			str := s[i:j]
			strLen := len(str)
			// here, for performance reasons we check the length of the string
			// and only if the lenght is greater than the maxNum of our current maxNum
			// palindrome, then we check if it is a palindrome, and if it is
			// set the maxNum and maxStr accordingly
			if strLen > maxNum && isPalindrome(str) {
				maxNum = strLen
				maxStr = str
			}
		}
	}

	return maxStr
}

func isPalindrome(s string) bool {
	strLen := len(s)

	if strLen == 1 {
		return true
	}

	// check if size is 2 or more a palindrome must start and end with the same character
	if strLen > 1 && s[0] == s[strLen-1] {
		return s == reverseString(s)
	}

	return false
}

// idiomatic reverse string
func reverseString(s string) string {
	var reversed strings.Builder

	// decrementing loop to start from the end
	for i := len(s) - 1; i >= 0; i-- {
		reversed.WriteByte(s[i])
	}

	return reversed.String()
}
