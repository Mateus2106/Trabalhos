package Package;

import java.util.Scanner;

public class Batalha_Naval {
	public static void main(String[] args) {
		Scanner obter = new Scanner(System.in);
		int[][] campo = new int[10][10];
		int[][] campo2 = new int[10][10];
		int h = 0;
		int v = 0;
		int tamanho;
		int flag = 0;
		int flag1 = 0;
		int flag2 = 0;
		VerificaNumero verificaNumero = new VerificaNumero(); 
		
		do {
			tamanho = 0;
			verificaNumero.VerificaTamanho(tamanho);
			System.out.println("Barco 1x1");
			verificaNumero.VerificaNumero(0);
			verificaNumero.VerificaMatriz(campo);	
			verificaNumero.MostrarCampo(campo);
			flag++;	
			System.out.println("=========================================");
			System.out.println("");
		}while(flag != 4);
		
		flag = 0;
			
		do {
			tamanho = 1;
			verificaNumero.VerificaTamanho(tamanho);
			System.out.println("Barco 2x1");
			System.out.print("Digite 1 para horizontal e 2 para vertical:");
			int direcao = obter.nextInt();
			verificaNumero.VerificaDirecao(direcao);
			verificaNumero.VerificaNumero(0);
			verificaNumero.VerificaMatriz(campo);	
			verificaNumero.MostrarCampo(campo);
			flag++;	
			System.out.println("=========================================");
			System.out.println("");	
		}while(flag != 3);
		
		flag = 0;
		/*
		do {
			System.out.println("Barco 3x1");
			System.out.println("Escolha a direção para qual seu barco estará posicionado:");
			System.out.print("Digite 1 para horizontal e 2 para vertical:");
			int direcao = obter.nextInt();
			switch(direcao)
			{
				case 1 : {
					System.out.print("Informe a linha:");
					h = obter.nextInt();
					System.out.print("Informe a coluna:");
					v = obter.nextInt();
					if(h <= 7)
					{
						campo[h][v] = 1;
						campo[h+1][v] = 2;
						campo[h+2][v] = 3;
						flag++;
					}
				}break;	
				case 2 : {
					System.out.print("Informe a linha:");
					h = obter.nextInt();
					System.out.print("Informe a coluna:");
					v = obter.nextInt();
					if(v <= 7)
					{
						campo[h][v] = 1;
						campo[h][v+1] = 2;
						campo[h][v+2] = 3;
						flag++;
					}	
				}break;
				default : {
					System.out.println("Direção invalida!!");
				}
			}
			
			
		}while(flag != 2);
		
		flag = 0;
		
		do {
			System.out.println("Barco 4x1");
			System.out.println("Escolha a direção para qual seu barco estará posicionado:");
			System.out.print("Digite 1 para horizontal e 2 para vertical:");
			int direcao = obter.nextInt();
			switch(direcao)
			{
				case 1 : {
					System.out.print("Informe a linha:");
					h = obter.nextInt();
					System.out.print("Informe a coluna:");
					v = obter.nextInt();
					if(h <= 6)
					{
						campo[h][v] = 1;
						campo[h+1][v] = 2;
						campo[h+2][v] = 3;
						campo[h+3][v] = 4;
						flag++;
					}
				}break;	
				case 2 : {
					System.out.print("Informe a linha:");
					h = obter.nextInt();
					System.out.print("Informe a coluna:");
					v = obter.nextInt();
					if(v <= 6)
					{
						campo[h][v] = 1;
						campo[h][v+1] = 2;
						campo[h][v+2] = 3;
						campo[h][v+3] = 4;
						flag++;
					}	
				}break;
				default : {
					System.out.println("Direção invalida!!");
				}
			}
			
			
		}while(flag != 1);*/
		
		for(int i = 0; i <= 9; i++)
		{
			for(int f = 0; f <= 9; f++)
			{
				System.out.print(+campo[i][f]+" ");
			}
			System.out.println("");
		}
		
		
		
	}
}
