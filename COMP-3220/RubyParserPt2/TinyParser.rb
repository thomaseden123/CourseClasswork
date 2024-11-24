#
#  Parser Class
#
load "TinyLexer.rb"
load "TinyToken.rb"
load "AST.rb"

class Parser < Lexer

    def initialize(filename)
        super(filename)
        consume()
    end

    def consume()
        @lookahead = nextToken()
        while(@lookahead.type == Token::WS)
            @lookahead = nextToken()
        end
    end

    def match(dtype)
        if (@lookahead.type != dtype)
            puts "Expected #{dtype} found #{@lookahead.text}"
			@errors_found += 1
        end
        consume()
    end

    def program()
    	@errors_found = 0
		
		p = AST.new(Token.new("program","program"))
		
	    while( @lookahead.type != Token::EOF)
            p.addChild(statement())
        end
        
        puts "There were #{@errors_found} parse errors found."
      
		return p
    end

    def statement()
		stmt = AST.new(Token.new("statement","statement"))
        if (@lookahead.type == Token::PRINT)
			stmt = AST.new(@lookahead)
            match(Token::PRINT)
            stmt.addChild(exp())
        else
            stmt = assign()
        end
		return stmt
    end

    def exp()
        term = term()
        if (@lookahead.type == Token::ADDOP or @lookahead.type == Token::SUBOP)
            opetail = etail()
            opetail.addChild(term)
            return opetail 
        end
        return term
    end

    def term()
        factor = factor()
        if (@lookahead.type == Token::MULTOP or @lookahead.type == Token::DIVOP)
            opttail = ttail()
            opttail.addChild(factor)
            return opttail
        end
        return factor
    end

    def factor()
        fct = AST.new(Token.new("factor", "factor"))
        if (@lookahead.type == Token::LPAREN)
            match(Token::LPAREN)
            fct = exp()
            if (@lookahead.type == Token::RPAREN)
                match(Token::RPAREN)
            else
				match(Token::RPAREN)
            end
        elsif (@lookahead.type == Token::INT)
            fct = AST.new(@lookahead)
            match(Token::INT)
        elsif (@lookahead.type == Token::ID)
            fct = AST.new(@lookahead)
            match(Token::ID)
        else
            puts "Expected ( or INT or ID found #{@lookahead.text}"
            @errors_found += 1
            consume()
        end
		return fct
    end

    def ttail()
        opttail = AST.new(Token.new("operation", "operation"))
        if (@lookahead.type == Token::MULTOP)
            opttail = AST.new(@lookahead)
            match(Token::MULTOP)
            opttail.addChild(factor())
            opttail_next = ttail()
            if (opttail_next != nil)
                opttail.addChild(opttail_next)
            end

        elsif (@lookahead.type == Token::DIVOP)
            opttail = AST.new(@lookahead)
            match(Token::DIVOP)
            opttail.addChild(factor())
            opttail_next = ttail()
            if (opttail_next != nil)
                opttail.addChild(opttail_next)
            end
		else
			return nil
        end
        return opttail
    end

    def etail()
        opetail = AST.new(Token.new("operation", "operation"))
        if (@lookahead.type == Token::ADDOP)
            opetail = AST.new(@lookahead)
            match(Token::ADDOP)
            opetail.addChild(term())
            opetail_next = etail()
            if (opetail_next != nil)
                opetail.addChild(opetail_next)
            end
        elsif (@lookahead.type == Token::SUBOP)
            opetail = AST.new(@lookahead)
            match(Token::SUBOP)
            opetail.addChild(term())
            opetail_next = etail()
            if (opetail_next != nil)
                opetail.addChild(opetail_next)
            end
		else
			return nil
        end
        return opetail
    end

    def assign()
        assgn = AST.new(Token.new("assignment","assignment"))
		if (@lookahead.type == Token::ID)
			idtok = AST.new(@lookahead)
			match(Token::ID)
			if (@lookahead.type == Token::ASSGN)
				assgn = AST.new(@lookahead)
				assgn.addChild(idtok)
            	match(Token::ASSGN)
				assgn.addChild(exp())
        	else
				match(Token::ASSGN)
			end
		else
			match(Token::ID)
        end
		return assgn
	end
end
