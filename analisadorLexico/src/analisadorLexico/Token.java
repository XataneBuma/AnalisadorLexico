package analisadorLexico;

public class Token {
	    private final int lineNumber;
	    private final String symbol;
	    private final String lexeme;

	    public Token(int lineNumber, String symbol, String lexeme) {
	        this.lineNumber = lineNumber;
	        this.symbol = symbol;
	        this.lexeme = lexeme;
	    }

	    public int getLineNumber() {
	        return lineNumber;
	    }

	    public String getSymbol() {
	        return symbol;
	    }

	    public String getLexeme() {
	        return lexeme;
	    }

	    @Override
	    public String toString() {
	        return "(" + lineNumber + ", " + symbol + ", \"" + lexeme + "\")";
	    }
	   

}
enum TokenType {
    IDENTIFICADOR, RESERVADA, OPERATOR, LITERAL, DELIMITADOR
}

class Token1 {
    private TokenType tipo;
    private String lexema;
    private int linhaNo;

    public Token1(TokenType tipo, String lexema, int linhaNo) {
        this.tipo = tipo;
        this.lexema = lexema;
        this.linhaNo = linhaNo;
    }

    public TokenType getTipo() {
        return tipo;
    }

    public String getLexema() {
        return lexema;
    }

    public int getLinhaNo() {
        return linhaNo;
    }
    @Override
    public String toString() {
        return "(" + linhaNo + ", " + tipo + ", \"" + lexema + "\")";
    }
}




