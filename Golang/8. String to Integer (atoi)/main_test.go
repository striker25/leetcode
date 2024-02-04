package main

import "testing"

func TestMyAtoi(t *testing.T) {
	cases := []struct {
		input  string
		expect int
	}{
		{input: "42", expect: 42},
		// {input: "   -42", expect: -42},
		// {input: "4193 with words", expect: 4193},
	}

	for _, c := range cases {
		if actual := myAtoi(c.input); actual != c.expect {
			t.Errorf("myAtoi(%s) = %d, expect %d", c.input, actual, c.expect)
		}
	}
}
