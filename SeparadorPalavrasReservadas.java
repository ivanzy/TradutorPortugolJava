package compilador;

import compilador.Token.Tipo;

public class SeparadorPalavrasReservadas {

	public static Token separa(String substring) {
		Token t = new Token(Tipo.VAZIO, substring);

		switch (substring) {
		case "programa":
			t.setT(Tipo.PROGRAMA);
			break;
		case "inicio":
			t.setT(Tipo.INICIO);
			break;
		case "inteiro":
			t.setT(Tipo.TIPO_VAR);
			break;
		case "real":
			t.setT(Tipo.TIPO_VAR);
			break;
		case "logico":
			t.setT(Tipo.TIPO_VAR);
			break;
		case "caracter":
			t.setT(Tipo.TIPO_VAR);
			break;
		case "cadeia":
			t.setT(Tipo.TIPO_VAR);
			break;
		case "const":
			t.setT(Tipo.CONST);
			break;
		case "verdadeiro":
			t.setT(Tipo.TIPO_LOG);
			break;
		case "false":
			t.setT(Tipo.TIPO_LOG);
			break;
		case "e":
			t.setT(Tipo.OP_LOGICO_BIN);
			break;
		case "ou":
			t.setT(Tipo.OP_LOGICO_BIN);
			break;
		case "nao":
			t.setT(Tipo.OP_LOGICO_UN);
			break;
		case "escreva":
			t.setT(Tipo.ESCREVA);
			break;
		case "leia":
			t.setT(Tipo.LEIA);
			break;
		case "pare":
			t.setT(Tipo.PARE);
			break;
		case "retorne":
			t.setT(Tipo.RETORNE);
			break;
		case "caso":
			t.setT(Tipo.CASO);
			break;
		case "enquanto":
			t.setT(Tipo.ENQUANTO);
			break;
		case "faca":
			t.setT(Tipo.FACA);
			break;
		case "funcao":
			t.setT(Tipo.PAL_FUNCAO);
			break;
		case "classe":
			t.setT(Tipo.PAL_CLASSE);
			break;
		case "para":
			t.setT(Tipo.PARA);
			break;
		case "se":
			t.setT(Tipo.SE);
			break;
		case "senao":
			t.setT(Tipo.SENAO);
			break;
		case "vazio":
			t.setT(Tipo.VAZIO);
			break;
		case "publica":
			t.setT(Tipo.TIPO_CLASSE);
			break;
		case "privada":
			t.setT(Tipo.TIPO_CLASSE);
			break;
		case "abstrata":
			t.setT(Tipo.TIPO_CLASSE);
			break;
		case "estatica":
			t.setT(Tipo.TIPO_CLASSE);
			break;
		case "protegida":
			t.setT(Tipo.TIPO_FUNCAO);
			break;
		default:
			if (Token.isNumeric(substring))
				t.setT(Tipo.NUM);
			else if (Character.isDigit(substring.charAt(0)))
				t.setT(Tipo.ID_INVALIDO);
			else
				t.setT(Tipo.ID);
			break;
		}

		return t;
	}
}
