#
#  Parser Class
#
load "TinyToken.rb"
load "TinyLexer.rb"
class Parser < Lexer
	
	def initialize(filename)
    super(filename)
		@error_count = 0
    consume()
  end
   	
	def consume()
    @lookahead = nextToken()
    while (@lookahead.type == Token::WS)
      @lookahead = nextToken()
    end
  end
  	
	def match(dtype)
    if (@lookahead.type != dtype)
		# if (!dtype.include?(@lookahead.type))
		# 	expect = dtype.map {|type| Token.type_name(type)}.join(" or ")
		# 	f = @lookahead.type == Token::EOF ? "eof" : @lookahead.text	
		# 	puts "Expected #{expect} found #{f}"
      puts "Expected #{dtype} found #{@lookahead.text}"
      @error_count += 1
    end
    consume()
  end
   	
	def program()
    while (@lookahead.type != Token::EOF)
			statement()  
    end
		# puts "There were #{@error_count} parse errors found."
  end

	def statement()
		puts "Entering STMT Rule"
    if (@lookahead.type == Token::PRINT)
      puts "Found PRINT Token: #{@lookahead.text}"
      match(Token::PRINT)
      exp()
    elsif (@lookahead.type == Token::ID)
      assign()
    else
      puts "Expected id found #{@lookahead.text}"
			# puts "Expected id found #{(@lookahead.type == Token::EOF) ? 'eof' : @lookahead.text}" 
			consume()
			@error_count += 1
    end
		puts "Exiting STMT Rule"
	end

	def assign()
    puts "Entering ASSGN Rule"
    if (@lookahead.type == Token::ID)
      puts "Found ID Token: #{@lookahead.text}"
			match(Token::ID)
		end	
    if (@lookahead.type == Token::ASSGN)
      puts "Found ASSGN Token: #{@lookahead.text}"
			match(Token::ASSGN)	
		else
			match(Token::ASSGN)	
		end	
    exp()
    puts "Exiting ASSGN Rule"
	end

	def exp()
		puts "Entering EXP Rule"
		term()
		etail()
		puts "Exiting EXP Rule"
	end

	def term()
		puts "Entering TERM Rule"
		factor()
		ttail()
		puts "Exiting TERM Rule"
	end

	def factor()
		puts "Entering FACTOR Rule"
    if (@lookahead.type == Token::LPAREN)
      puts "Found LPAREN Token: #{@lookahead.text}"
      match(Token::LPAREN)
			exp()
      if (@lookahead.type == Token::RPAREN)
        puts "Found RPAREN Token: #{@lookahead.text}"
      end
			match(Token::RPAREN)
		elsif (@lookahead.type == Token::INT)
			puts "Found INT Token: #{@lookahead.text}"
			match(Token::INT)
		elsif (@lookahead.type == Token::ID)
			puts "Found ID Token: #{@lookahead.text}"
			match(Token::ID)	
		else
			# match(Token::LPAREN, Token::INT, Token::ID)
			puts "Expected ( or INT or ID found #{@lookahead.text}"
			@error_count += 1
		end
		puts "Exiting FACTOR Rule"
	end

	def ttail()
		puts "Entering TTAIL Rule"
		if (@lookahead.type == Token::MULTOP)
			puts "Found MULTOP Token: #{@lookahead.text}"
			match(Token::MULTOP)
			factor()
			ttail()
		elsif (@lookahead.type == Token::DIVOP)
			puts "Found DIVOP Token: #{@lookahead.text}"
			match(Token::DIVOP)
			factor()
			ttail()
		else
			puts "Did not find MULTOP or DIVOP Token, choosing EPSILON production"	
		end
		puts "Exiting TTAIL Rule"
	end

	def etail()
		puts "Entering ETAIL Rule"
		if (@lookahead.type == Token::ADDOP)
			puts "Found ADDOP Token: #{@lookahead.text}"
			match(Token::ADDOP)
			term()
			etail()
		elsif (@lookahead.type == Token::SUBOP)
			puts "Found SUBOP Token: #{@lookahead.text}"
			match(Token::SUBOP)
			term()
			etail()
		else
			puts "Did not find ADDOP or SUBOP Token, choosing EPSILON production"	
		end
		puts "Exiting ETAIL Rule"
	end	
	puts "There were #{@error_count} parse errors found."
end
