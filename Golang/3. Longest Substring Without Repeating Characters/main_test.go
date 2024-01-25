package main

import (
	"testing"
)

func TestLengthOfLongestSubstring(t *testing.T) {
	t.Log("lengthOfLongestSubstring")

	t.Log("testing: abcabcbb")
	actual := lengthOfLongestSubstring("abcabcbb")

	if actual != 3 {
		t.Errorf("expected: 3, actual: %d", actual)
	}

	t.Log("testing: bbbbb")
	actual = lengthOfLongestSubstring("bbbbb")

	if actual != 1 {
		t.Errorf("expected: 1, actual: %d", actual)
	}

	t.Log("testing: pwwkew")
	actual = lengthOfLongestSubstring("pwwkew")

	if actual != 3 {
		t.Errorf("expected: 3, actual: %d", actual)
	}

	t.Log("testing: a whitespace \" \"")
	actual = lengthOfLongestSubstring(" ")
	if actual != 1 {
		t.Errorf("expected: 1, actual: %d", actual)
	}
}
