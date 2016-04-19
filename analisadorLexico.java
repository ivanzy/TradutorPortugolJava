package compilador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import compilador.Token.Tipo;

/**
 *
 * @author Alan Eliabe Ivan Gabriel Lucas
 */
public class analisadorLexico {

	public static boolean isSpecialCharacter(char c) {
		boolean test = (c >= 97 && c <= 127) || (c >= 65 && c <= 93) || (c >= 46 && c <= 62) || (c >= 37 && c <= 45)
				|| c == 32 || c == 34 || c == 95 || (c>=8 &&c<=10) ;
		return !test;
	}

	public static Token getUnid(String s, int i) {
		int j = i;
		Token t;

		for (; j < s.length();) {
			if (Character.isLetterOrDigit(s.charAt(j)) || s.charAt(j) == '_') {
				j++;
			} else {
				t = SeparadorPalavrasReservadas.separa(s.substring(i, j));
				return t;
			}
		}
		t = SeparadorPalavrasReservadas.separa(s.substring(i, j));
		return t;
	}

	public static List<Token> lexico(String input) {
		List<Token> result = new ArrayList<Token>();
		System.out.println(input);
		for (int i = 0; i < input.length();) {
			if (isSpecialCharacter(input.charAt(i))) {
				String s = "" + input.charAt(i);
				result.add(new Token(Tipo.CHAR_INVALIDO, s));
				i++;
			}
			switch (input.charAt(i)) {
			// DELIMITADORES :
			case '(':
				result.add(new Token(Tipo.ABRE_PAREN, "("));
				i++;
				break;
			case ')':
				result.add(new Token(Tipo.FECHA_PAREN, ")"));
				i++;
				break;
			case '[':
				result.add(new Token(Tipo.ABRE_COLCHETE, "["));
				i++;
				break;
			case ']':
				result.add(new Token(Tipo.FECHA_COLCHETE, "]"));
				i++;
				break;
			case '{':
				result.add(new Token(Tipo.ABRE_CHAVE, "{"));
				i++;
				break;
			case '}':
				result.add(new Token(Tipo.FECHA_CHAVE, "}"));
				i++;
				break;
			case '"':
				result.add(new Token(Tipo.ASPAS_DUPLAS, "\""));
				i++;
				String id = "";
				while (input.charAt(i) != '"') {
					id += input.charAt(i);
					i++;
				}
				result.add(new Token(Tipo.ENTRE_ASPAS, id));
				result.add(new Token(Tipo.ASPAS_DUPLAS, "\""));
				i++;
				break;
			case '.':
				result.add(new Token(Tipo.PONTO, "."));
				i++;
				break;
			case ',':
				result.add(new Token(Tipo.VIRGULA, ","));
				i++;
				break;
			case ';':
				result.add(new Token(Tipo.PONTOEVIRGULA, ";"));
				i++;
				break;
			case '\'':
				result.add(new Token(Tipo.ASPAS_SIMPLES, "'"));
				i++;
				String asp = "";
				while (input.charAt(i) != '\'') {
					asp += input.charAt(i);
					i++;
				}
				result.add(new Token(Tipo.ENTRE_ASPAS, asp));
				result.add(new Token(Tipo.ASPAS_SIMPLES, "\""));
				i++;
				break;
			case ':':
				result.add(new Token(Tipo.DOISPONTOS, ":"));
				i++;
				break;
			// OPERADORES BITWISE
			case '&':
				result.add(new Token(Tipo.BITWISE_BIN, "&"));
				i++;
				break;
			case '|':
				result.add(new Token(Tipo.BITWISE_BIN, "|"));
				i++;
				break;
			case '~':
				result.add(new Token(Tipo.NAO_BITWISE, "~"));
				i++;
				break;
			case '^':
				result.add(new Token(Tipo.BITWISE_BIN, "^"));
				i++;
				break;
			// OPERADORES ARITIMERICOS OU ATRIBUICAO COMPOSTA
			case '+':
				if (input.charAt(i + 1) == '+') {
					result.add(new Token(Tipo.INCREMENTO, "++"));
					i += 2;
				} else if (input.charAt(i + 1) == '=') {
					result.add(new Token(Tipo.ATR_COMP, "+="));
					i += 2;
				} else {
					result.add(new Token(Tipo.OP_ARITMETICO, "+"));
					i++;
				}
				break;
			case '-':
				if (input.charAt(i + 1) == '-') {
					result.add(new Token(Tipo.DECREMENTO, "--"));
					i += 2;
				} else if (input.charAt(i + 1) == '=') {
					result.add(new Token(Tipo.ATR_COMP, "-="));
					i += 2;
				} else {
					result.add(new Token(Tipo.OP_ARITMETICO, "-"));
					i++;
				}
				break;
			case '%':
				if (input.charAt(i + 1) == '=') {
					result.add(new Token(Tipo.ATR_COMP, "%="));
					i += 2;
				} else {
					result.add(new Token(Tipo.OP_ARITMETICO, "%"));
					i++;
				}
				break;
			case '/':
				if (input.charAt(i + 1) == '=') {
					result.add(new Token(Tipo.ATR_COMP, "/="));
					i += 2;
				} else {
					result.add(new Token(Tipo.OP_ARITMETICO, "/"));
					i++;
				}
				break;

			case '*':
				if (input.charAt(i + 1) == '=') {
					result.add(new Token(Tipo.ATR_COMP, "*="));
					i += 2;
				} else {
					result.add(new Token(Tipo.OP_ARITMETICO, "*"));
					i++;
				}
				break;
			// OPERADORES RELACIONAIS
			case '>':
				if (input.charAt(i + 1) == '=') {
					result.add(new Token(Tipo.OP_COMPARA, ">="));
					i += 2;
				} else {
					result.add(new Token(Tipo.OP_COMPARA, ">"));
					i++;
				}
				break;
			case '<':
				if (input.charAt(i + 1) == '=') {
					result.add(new Token(Tipo.OP_COMPARA, "<="));
					i += 2;
				} else {
					result.add(new Token(Tipo.OP_COMPARA, "<"));
					i++;
				}
				break;
			case '=':
				if (input.charAt(i + 1) == '=') {
					result.add(new Token(Tipo.OP_COMPARA, "=="));
					i += 2;
				} else {
					result.add(new Token(Tipo.OP_ATRIBUI, "="));
					i++;
				}
				break;
			default:
				if (Character.isWhitespace(input.charAt(i)) || input.charAt(i) == 10) {
					i++;
				} else {
					Token unid = getUnid(input, i);
					i += unid.c.length();
					result.add(unid);
				}
				break;

			}
		}
		return result;

	}

	public static void main(String[] args) throws IOException {
		Scanner ler = new Scanner(System.in);
		String nome = "/home/ivan/compiladores/compilador/src/compilador/";

		System.out.println("Entre com o nome do arquivo:  ");
		nome += ler.nextLine() + ".gol";
		Stack pilha = new Stack();
		try {
			 String content = new Scanner(new File(nome)).useDelimiter("\\Z").next();

			List<Token> tokens = lexico(content);
			for (Token t : tokens) {
				pilha.push(t);
				System.out.println(t);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
