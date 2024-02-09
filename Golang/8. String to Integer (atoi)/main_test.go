package main

import "testing"

func TestMyAtoi(t *testing.T) {
	cases := []struct {
		input  string
		expect int
	}{
		{input: "42", expect: 42},
		{input: "   -42", expect: -42},
		{input: "4193 with words", expect: 4193},
		{input: "-5-", expect: -5},
		{input: "-91283472332", expect: -2147483648},
		{input: "+-12", expect: 0},
		{input: "-+12", expect: 0},
		{input: "00000-42a1234", expect: 0},
		{input: "21474836460", expect: 2147483647},
		{input: "  0000000000012345678", expect: 12345678},
		{input: "words and 987", expect: 0},
		{input: "-000000000000001", expect: -1},
		{input: "     +004500", expect: 4500},
		{input: "    -00134", expect: -134},
		{input: "  -0012a42", expect: -12},
	}

	for _, c := range cases {
		if actual := myAtoi(c.input); actual != c.expect {
			t.Errorf("myAtoi(%s) = %d, expect %d", c.input, actual, c.expect)
		}
	}
}
