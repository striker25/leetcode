package main

import (
	"strconv"
)

func Reverse(s string) (result string) {
	for _, v := range s {
		result = string(v) + result
	}

	return
}

// complexity: O(N)
func isPalindrome(x int) bool {
	reversedNumberStr := Reverse(strconv.Itoa(x))
	reversedNumber, _ := strconv.Atoi(reversedNumberStr)

	return x == reversedNumber
}
