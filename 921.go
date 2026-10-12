import (
    "regexp"
    "strings"
)
func minAddToMakeValid(s string) int {
    m := regexp.MustCompile(`\(\)`)
    for strings.Contains(s, "()") {
        s = m.ReplaceAllString(s, "")
    }
    return len(s)
}