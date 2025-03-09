package main

import (
	"fmt"
	"strconv"
	"strings"
)

func main() {
	fmt.Println(reverse(-123))
}

func reverse(number int) int {

	numberStr := fmt.Sprintf("%d", number)
	numberStr = strings.Replace(numberStr, "-", "", -1)

	// reverse the number
	reverseStr := ""
	for i := len(numberStr) - 1; i >= 0; i-- {
		reverseStr += string(numberStr[i])
	}

	// convert to int
	reverseInt, _ := strconv.Atoi(reverseStr)

	// handle negative scenario
	if number < 0 {
		reverseInt *= -1
	}

	// handle overflow
	if reverseInt < -2_147_483_648 || reverseInt > 2_147_483_647 {
		return 0
	}

	return reverseInt
}
