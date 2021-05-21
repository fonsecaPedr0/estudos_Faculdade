package trabalhoAFD;

import java.util.Scanner;

public class TrabalhoAFD {
	
	
	
	public static void main(String args[]) {
			Scanner scanner = new Scanner(System.in);
			
			String entrada;
			int estado = 0;
			int posicao = 0;
			
			System.out.print("Informe a cadeia a ser exibida: ");
			entrada = scanner.next();
			
			
			while(posicao < entrada.length()) 
			{
				
				impressaoRegrasP(entrada, estado, posicao);
				
				char elemento = entrada.charAt(posicao);
				
					if(estado == 0 && elemento == '0') {
						estado = 0;
					} 
					else if(estado == 0 && elemento == '1' ) {
						estado = 1;  
					}
					else if(estado == 1 && elemento == '0') {
						estado = 1;
					}
					else if(estado == 1 && elemento == '1') {
						estado = 0;
					}
					
				
				posicao++;
			}
			
			impressaoRegrasP(entrada, estado, posicao);
			
			if(estado == 1) {
				System.out.println("A sentenca informada e valida!!");
			}else if(estado ==0) {
				System.out.println("A sentenca informada nao e valida!");
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