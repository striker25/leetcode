package main

import "testing"

func TestReverse(t *testing.T) {
	cases := []struct {
		input    int
		expected int
	}{
		{
			123,
			321,
		},
		{
			-123,
			-321,
		},
		{
			120,
			21,
		},
		{
			-2147483412,
			-2143847412,
		},
		{
			1534236469,
			0,
		},
	}

	for _, c := range cases {
		actual := reverse(c.input)
		if actual != c.expected {
			t.Errorf("reverse(%d) == %d, expected %d", c.input, actual, c.expected)
		}
	}
}
