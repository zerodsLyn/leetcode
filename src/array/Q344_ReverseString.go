package main

import "fmt"

func main() {
    bytes := []byte{'x', 'a', 'd'}
    reverseString(bytes)
    fmt.Println(string(bytes))
}

func reverseString(s []byte)  {
    for i, j := 0, len(s)-1; i < j; i, j = i+1, j-1 {
        s[i], s[j] = s[j], s[i]
    }
}