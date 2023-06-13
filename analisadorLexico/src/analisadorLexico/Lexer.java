package analisadorLexico;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Lexer {
	
private static int tokenErros;
	public String tempo;
	public long tempoIn;
	public int result;
	public static int totalTokens;
	public static int totalChars;
	public static int totalErros;
	
	
	public Lexer() {
		long tempoIn = System.currentTimeMillis();
	}


    public static ArrayList<Token> tokenize(String codigo) {
    	ArrayList<Token> tokens = new ArrayList<>();
    	ArrayList<Token> erros = new ArrayList<>();
    	codigo = codigo.toLowerCase();
    	totalChars =codigo.length();
        String[] linhas = codigo.split("\\r?\\n");
        
        Pattern pattern = Pattern.compile(
                "\\b(program|var|const|type|function|procedure|begin|end|if|then|else|while|do|write|writeln|repeat|until|for|to|downto|case|of|or|and|not)\\b" +
                "|\\b([A-Za-z_]\\w*)\\b" +
                "|(\\d+(\\.\\d*)?|\\.\\d+)" +
                "|" +
                "(\\+|\\-|\\*|\\/|\\=|\\<\\>|\\<|\\>|\\<=|\\>=|\\:|\\,|\\;|\\.|\\(|\\)|\\[|\\]|\\{\\})" +
                "|" +
                "((\\'.*?\\')|(\\(\\*.*?\\*\\)))");
        totalTokens = 0;
        tokenErros = 0;
        int numeroLinha = 0;
        for (String line : linhas) {
            numeroLinha++;
            Matcher matcher = pattern.matcher(line);
            int indice = 0;
            while (matcher.find(indice)) {
                String lexema = matcher.group();
                if (lexema.matches("\\d+(\\.\\d*)?|\\.\\d+")) {
                	
                    tokens.add(new Token(numeroLinha, "Inteiro", lexema));
                } else if (lexema.matches("\\b(program|var|const|type|function|procedure|begin|end|if|then|else|while|write|writeln|do|repeat|until|for|to|downto|case|of|or|and|not)\\b")) {
                	
                    tokens.add(new Token(numeroLinha, "Reservada", lexema));
                } else if (lexema.matches("\\b([A-Za-z_]\\w*)\\b")) {
                	
                    tokens.add(new Token(numeroLinha, "Identificador", lexema));
                } else if (lexema.matches("\\+|\\-|\\*|\\/|\\=|\\<\\>|\\<|\\>|\\<=|\\>=|\\:|\\,|\\;|\\.|\\(|\\)|\\[|\\]|\\{\\}")) {
                
                    tokens.add(new Token(numeroLinha, "Simbolo", lexema));
                } else if (lexema.matches("(\\'.*?\\')|(\\(\\*.*?\\*\\))")) {
               
                    tokens.add(new Token(numeroLinha, "String", lexema));
                } 
                else {
                	tokens.add(new Token(numeroLinha, "Erro", lexema));
                	tokenErros = tokenErros + 1;
                	
                }
                
                totalTokens = totalTokens + 1;
                indice = matcher.end();
            }
           
        }
        
        return tokens;
   
    }
   
    public long tempoFim = System.currentTimeMillis();
    public long tempoEstimado = tempoFim - tempoIn;
    public long getTempo() {
		return tempoEstimado;
    	
    }
    

}
class Lexer1 {
	public static int totalTokens;
	public static int totalChars;
	public static int totalErros;
	private static int tokenErros;
	private long tempoIn;
	public Lexer1() {
		long tempoIn = System.currentTimeMillis();
	}
    private static final String[] reservada = {"program","begin","end","downto","function","procedure","var","of","write","writeln","if", "else", "while", "for", "do", "break", "continue", "return"};

    public static ArrayList<Token> tokenize(String input) {
        ArrayList<Token> tokens = new ArrayList<>();

        String[] lines = input.split("\n");
        totalTokens = 0;
	      tokenErros = 0;
	      totalChars = input.length();
        int lineNo = 0;
        for (String line : lines) {
            lineNo++;
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (word.isEmpty()) {
                    continue;
                }
                Token1 token;
                if (isReservada(word)) {
                    token = new Token1(TokenType.RESERVADA, word, lineNo);
                } else if (isOperador(word)) {
                    token = new Token1(TokenType.OPERATOR, word, lineNo);
                } else if (isDelimitador(word)) {
                    token = new Token1(TokenType.DELIMITADOR, word, lineNo);
                } else if (isliteral(word)) {
                    token = new Token1(TokenType.LITERAL, word, lineNo);
                } else {
                    token = new Token1(TokenType.IDENTIFICADOR, word, lineNo);
                }
//                tokens.add(token);
            }
            totalTokens = totalTokens + 1;
        }
        return tokens;
    }

    private static boolean isReservada(String word) {
        for (String reservad : reservada) {
            if (reservad.equals(word)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isOperador(String word) {
        String[] operadores = {"+", "-", "*", "/", "=", "<", ">", "<=", ">=", "==", "!="};
        for (String operator : operadores) {
            if (operator.equals(word)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDelimitador(String word) {
        String[] delimitadores = {";", ",", "(", ")", "{", "}"};
        for (String delimitador : delimitadores) {
            if (delimitador.equals(word)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isliteral(String word) {
        return word.matches("\\d+");
    }
    public long tempoFim = System.currentTimeMillis();
	
  public long tempoEstimado = tempoFim - tempoIn;
 

  public long getTempo() {
		return tempoEstimado;
}
  }
