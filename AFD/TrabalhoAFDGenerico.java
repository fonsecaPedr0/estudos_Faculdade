//package trabalhoAFD;

public class TrabalhoAFDGenerico{
	
	static int[] aceitacao = {1};
	static int[][] transicao = {{0,1}, {1,0}};
	static int estadoInicial = 0;  

	public static void main(String args[]) {
			
		String entrada = args[0];
		int estado = estadoInicial;
		int posicao = 0;
			
			while(posicao < entrada.length()) {
				impressaoRegrasP(entrada, estado, posicao);

				char elemento = entrada.charAt(posicao);

				int elementoInt = Integer.parseInt(elemento+"");
					
				estado = transicao[estado] [elemento];
				
				posicao++;
			}
			
		impressaoRegrasP(entrada, estado, posicao);
		
		boolean aceita = false;

			for(int i:aceitacao){
				if(estado == 1) aceita = true;
			}

		if(aceita){
			System.out.print("Aceita a cadeia!");
		}else{
			System.out.print("Não aceita a cadeia!");
		}
			
	}
	
	
	public static void impressaoRegrasP(String entrada, int estado, int posicao) 
	{
		System.out.print(entrada.substring(0, posicao));
		System.out.print("[Q"+estado+"]");
		System.out.println(entrada.substring(posicao));
		
	}
}
