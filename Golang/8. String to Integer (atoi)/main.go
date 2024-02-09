package main

import (
	"fmt"
	"log"
	"strconv"
	"strings"
)

func main() {
	fmt.Println("Hello, World!")
}

func myAtoi(s string) int {
	// remove leading spaces
	s = strings.TrimSpace(s)

	if len(s) == 0 {
		return 0
	}

	// validate leading zeros with sign
	newStr := ""

	// validate leading zeroes with sign
	if strings.HasPrefix(s, "+0") || strings.HasPrefix(s, "-0") {
		for i := 1; i < len(s); i++ {
			if string(s[i]) == "0" {
				continue
			} else {
				if strings.HasPrefix(s, "+0") {
					newStr = string(s[0]) + s[i-1:]
				} else {
					newStr = string(s[0]) + s[i-2:]
				}	
			}
		}

		s = newStr
	}

	const allowedWhitespaces string = " "
	const allowedNumbers string = "0123456789"
	const allowedSigns string = "+-"

	intStr := ""
	lastSign := "+"
	signCount := 0
	hasLeadingZero := false

	for _, value := range s {

		v := string(value)
		// stop where the first letter is found
		if !strings.Contains(fmt.Sprintf("%s%s%s", allowedWhitespaces, allowedNumbers, allowedSigns), v) {
			break
		}

		// skip whitespaces
		if v == allowedWhitespaces {
			continue
		}

		// skip leading zeros
		if v == "0" && (intStr == "" || intStr == "-" || intStr == "+") {
			hasLeadingZero = true
			continue
		}

		// validate sign, if more than one, return 0
		if strings.Contains(allowedSigns, v) {
			signCount++
		}

		// validate sign in the middle when leading zeroes
		if hasLeadingZero && len(intStr) > 1 && signCount > 0 {
			intStr = "0"
			break
		}

		intStr += v
	}

	

	// validate sign
	negativeSignCount := strings.Count(intStr, "-")
	postiveSignCount := strings.Count(intStr, "+")
	if negativeSignCount == 1 && postiveSignCount == 1 {
		return 0
	}

	signIndex := strings.LastIndex(intStr, "-")
	
	if signIndex == 0 || signIndex == len(intStr)-1 { // sign at the beginning or end
		lastSign = "-"
	} else if signIndex != -1 { // sign in the middle
		intStr = "0"
	}

	// remove signs
	if signCount > 1 {
		intStr = strings.ReplaceAll(intStr, "+", "")
		intStr = strings.ReplaceAll(intStr, "-", "")

		// add the sign back
		intStr = lastSign + intStr
	}

	// validate length does not exceed 10
	if len(intStr) > 10 {
		if lastSign == "-" {
			return -2147483648
		} else {
			return 2147483647
		}
	}

	// validate empty conversion
	if intStr == "" {
		return 0
	}

	// validate conversion
	if len(intStr) == 1 && strings.Contains(allowedSigns, intStr) {
		return 0
	}

	integer, err := strconv.ParseInt(intStr, 10, 32)
	if err != nil {
		log.Fatalf("error: %s", err)
	}

	return int(integer)
}
