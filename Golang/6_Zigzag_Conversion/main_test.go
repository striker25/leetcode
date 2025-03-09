package main

import (
	"testing"
)

func TestConver(t *testing.T) {
	cases := []struct {
		input    string
		numRows  int
		expected string
	}{
		{input: "PAYPALISHIRING", numRows: 3, expected: "PAHNAPLSIIGYIR"},
		{input: "PAYPALISHIRING", numRows: 4, expected: "PINALSIGYAHRPI"},
		{input: "A", numRows: 1, expected: "A"},
		{input: "AB", numRows: 1, expected: "AB"},
	}

	for _, c := range cases {
		if actual := convert(c.input, c.numRows); actual != c.expected {
			t.Errorf("convert(%q, %d) == %q, want %q", c.input, c.numRows, actual, c.expected)
		}
	}
}
