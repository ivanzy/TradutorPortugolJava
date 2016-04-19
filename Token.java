package compilador;

public class Token {
	public static enum Tipo {// Tipos dos tokens

		/* DELIMITADORES: */ ABRE_PAREN, FECHA_PAREN, ABRE_COLCHETE, FECHA_COLCHETE, ABRE_CHAVE, FECHA_CHAVE, ASPAS_SIMPLES, ASPAS_DUPLAS, PONTO, VIRGULA, PONTOEVIRGULA, DOISPONTOS,
		/* ATRIBUICAO: */ OP_ATRIBUI,
		/* OPERADORES ARITIMÉTICOS: */ OP_ARITMETICO, // OP_AR_ADICAO,
														// OP_AR_SUBTRACAO,
														// OP_AR_MULT,
														// OP_AR_DIV, OP_AR_MOD,
		/* INCREMENTO E DECREMENTO: */INCREMENTO, DECREMENTO,
		/* OPERADORES RELACIONAIS E IGUALDADE: */OP_COMPARA, // , OP_REL_MAIOR,
																// OP_REL_MAIORIGUAL,
																// OP_REL_MENORIGUAL,
																// OP_IGUAL,
																// OP_REL_DIFERENTE,
		/* OPERADORES LOGICOS: */OP_LOGICO_BIN, OP_LOGICO_UN, // OP_LOG_OU,
																// OP_LOG_NAO,
		/* OPERADORES BIT A BIT: */ BITWISE_BIN, NAO_BITWISE, // , OU_BITWISE,
																// XOR_BITWISE,
		/* ATRIBUICAO COMPOSTA: */ATR_COMP, // _ADICAO, ATR_COMP_SUBTRACAO,
											// ATR_COMP_MULTIPLICACAO,
											// ATR_COMP_DIVISAO, ATR_COMP_MOD,
		/* TIPO CONSTANTE: */ CONST,
		/* TIPO LOGICO: */ TIPO_LOG,
		/* TIPO VARIAVEL: */ TIPO_VAR,
		/* DECLARA CLASSE: */ PAL_CLASSE,
		/* TIPO CLASSE: */ TIPO_CLASSE,
		/* DECLARA FUNCAO: */ PAL_FUNCAO,
		/* TIPO FUNCAO: */ TIPO_FUNCAO,
		/* TIPO NUMERO: */ NUM,
		/* TIPO IDENTIFICADOR: */ ID,
		/* LABEL: */ PROGRAMA,
		/* INICIO: */ INICIO,
		/* LEIA: */ LEIA,
		/* ESCREVA: */ ESCREVA,
		/* SE: */ SE,
		/* SENAO: */ SENAO,
		/* ENQUANTO: */ ENQUANTO,
		/* FACA: */ FACA,
		/* PARA : */ PARA,
		/* RETORNE: */ RETORNE,
		/* PARE: */ PARE,
		/* NULL: */ VAZIO,
		/* CASO: */ CASO,
		/* CONTEUDO ENTRE ASPAS */ ENTRE_ASPAS,
		/* ERROS: */ CHAR_INVALIDO, ID_INVALIDO;

	}

	public Tipo t;
	public String c;

	public Token(Tipo t, String c) {
		this.t = t;
		this.c = c;
	}

	public Tipo getT() {
		return t;
	}

	public String getC() {
		return c;
	}

	public void setT(Tipo t) {
		this.t = t;
	}

	public void setC(String c) {
		this.c = c;
	}

	@Override
	public String toString() {

		switch (t) {
		case ID:
			return "ID<" + c + ">";
		case NUM:
			return "NUM<" + c + ">";
		case TIPO_CLASSE:
			return "TIPO_CLASSE<" + c + ">";
		case OP_ARITMETICO:
			return "OP_ARITMETICO<" + c + ">";
		case OP_COMPARA:
			return "OP_COMPARA<" + c + ">";
		case OP_LOGICO_BIN:
			return "OP_LOGICO_BIN<" + c + ">";
		case TIPO_LOG:
			return "TIPO_LOG<" + c + ">";
		case TIPO_VAR:
			return "TIPO_VAR<" + c + ">";
		case BITWISE_BIN:
			return "BITWISE_BIN<" + c + ">";
		case ATR_COMP:
			return "ATR_COMP<" + c + ">";
		case CHAR_INVALIDO:
			return "CHAR_INVALIDO<" + c + ">";
		case ID_INVALIDO:
			return "ID_INVALIDO<" + c + ">";
		case ENTRE_ASPAS:
			return "ENTRE_ASPAS<" + c + ">";

		default:
			return t.toString();

		}

	}

	public static boolean isNumeric(final CharSequence cs) {

		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (Character.isDigit(cs.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}
}
