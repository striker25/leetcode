package main

import (
	"errors"
	"fmt"
	"regexp"
	"strconv"
	"strings"
)

func main() {
	fmt.Println(myAtoi("-2147483647"))
	// expected 4500
}

func myAtoi(s string) int {
	re := regexp.MustCompile(`^\s*([+-]?\d+)\D*`)
	matches := re.FindStringSubmatch(s)

	if len(matches) == 0 {
		return 0
	}

	number, err := strconv.Atoi(matches[1])
	if err != nil {
		if errors.Is(err, strconv.ErrRange) {
			if strings.Contains(matches[1], "-") {
				return -2147483648
			} else {
				return 2147483647
			}
		}

		return 0
	}

	// Clamping to the 32-bit signed integer range
	if number < -1<<31 {
		return -1 << 31
	}
	if number > 1<<31-1 {
		return 1<<31 - 1
	}

	return number
}
