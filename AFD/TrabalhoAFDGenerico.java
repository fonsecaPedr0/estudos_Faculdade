package trabalhoAFD;

import java.util.Scanner;

public class trabalhoAFDGenerico {
	//alterar valores de acordo com a maquina AFD		
	static int[] aceitacao = {1}; 
	static int [][] transicao = {{0,1}, {1,0}};
	static int estadoInicial = 0;
	
		public static void main(String[] args) 
		{	
			Scanner scanner = new Scanner(System.in);
			
			String cadeia;
			int posicao = 0, estado = estadoInicial;
			char simbolo;
			boolean aceita = false;
			
			System.out.print("Informe a cadeia a ser validade: ");
			cadeia = scanner.next();
			
				while(posicao < cadeia.length())
				{
					impressaoRegrasP(cadeia, estado, posicao);
					
					simbolo = cadeia.charAt(posicao);
					int simboloInt = Integer.parseInt(simbolo+"");
						
					estado = transicao[estado][simboloInt];
					
					posicao++;
				}
			
			
			impressaoRegrasP(cadeia, estado, posicao);
			
			for(int i:aceitacao)
			{
				if(estado==i) aceita = true;
			}
			
			if(aceita)
			{
				System.out.println("A cadeia e valida!!");
			}
			else 
			{
				System.out.println("A cadeia nao e valida!");
			}
			
			
			scanner.close();
		}
			
		public static void impressaoRegrasP(String entrada, int estado, int posicao)
		{
			System.out.print(entrada.substring(0, posicao));
			System.out.print("[Q"+estado+"]");
			System.out.println(entrada.substring(posicao));
		}
}
