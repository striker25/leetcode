package main

import "fmt"

func main() {
	fmt.Println(convert("PAYPALISHIRING", 4))
}

func convert(s string, numRows int) string {
	// zigzag example
	// input: PAYPALISHIRING
	// zigzag:
	// P     I    N
	// A   L S  I G
	// Y A   H R
	// P     I
	//
	// output:
	// PINALSIGYAHRPI

	if len(s) == 1 {
		return s
	}

	var zigzag = make([][]string, numRows)

	vertical := 0
	forward := true
	for j := 0; j < len(s); j++ {

		// append to array in zigzag
		zigzag[vertical] = append(zigzag[vertical], string(s[j]))

		// change direction only if more than one row
		if numRows > 1 {
			if forward && vertical == numRows-1 {
				forward = false
			} else if !forward && vertical == 0 {
				forward = true
			}

			// increment/decrement
			if forward {
				vertical++
			} else {
				vertical--
			}
		}

	}

	strZigzag := ""
	for _, strArray := range zigzag {
		strZigzag += ReduceStrings(strArray, func(accumulator string, element string) string { return accumulator + element }, "")
	}

	return strZigzag
}

// StringReducer is a function that takes an accumulator and an element,
// and returns the new value of the accumulator after applying some logic.
type StringReducer func(accumulator string, element string) string

// ReduceStrings takes a slice of strings, a StringReducer, and an initial value, // and applies the reducer to each element of the slice.
// It returns the final result of the reduction process.
func ReduceStrings(slice []string, reducer StringReducer, initial string) string {
	result := initial

	for _, element := range slice {
		result = reducer(result, element)
	}

	return result
}
