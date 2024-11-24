package main

import "testing"

func TestIsPalindrome(t *testing.T) {

	cases := []struct {
		input  int
		expect bool
	}{
		{input: 121, expect: true},
		{input: -121, expect: false},
		{input: 10, expect: false},
	}

	for _, c := range cases {
		if actual := isPalindrome(c.input); actual != c.expect {
			t.Errorf("isPalindrome(%d) = %v; expect %v", c.input, actual, c.expect)
		}
	}
}
