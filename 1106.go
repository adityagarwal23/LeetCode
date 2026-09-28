
    var pos int
    var expr string

    func nextChar() byte {
        pos++
        if pos < len(expr) {
            return expr[pos]
        } else {
            return 0 //end of the input
        }
    }

    func parseBoolExpr(expression string) bool {
        expr = expression
        pos = -1
        return parseExpr()    
    }

    // <expr> := <bool> | <not_expr> | <and_expr> | <or_expr>\

    const And = 1
    const Or = 2
    func parseExpr() bool {
        switch nextChar() {
            case 't': return true
            case 'f': return false
            case '!': return parseNotExpr()
            case '|': return parseAndOrExpr(Or)
            case '&': return parseAndOrExpr(And)
            default: return false
        }
    }

    func parseNotExpr() bool {
        nextChar() //eat (
        res := parseExpr()
        nextChar() //eat )
        return !res
    }

    func parseAndOrExpr(op int) bool {
        nextChar() //eat (
        res := parseExpr()
        for {
            switch nextChar() {
                case ')': return res
                case ',':
                    switch op {
                        case Or: res = parseExpr() || res
                        case And: res = parseExpr() && res
                    }
            }
        }
    }