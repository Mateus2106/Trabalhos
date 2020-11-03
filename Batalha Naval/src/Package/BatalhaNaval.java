package Package;

import java.util.Scanner;

class VerificaNumero{
	Scanner obter = new Scanner(System.in);
	int h;
	int v;
	int direcao;
	int tamanho;
	int tamanho2;
	int tamanho3;
	int flag = 0;
	int flag2;
	int flag3 = 0;
	int flag4 = 0;
	int[][] campo = new int[10][10];
	int[][] campo2 = new int[10][10];
	
	public void MostrarCampo(int[][] campo)
	{
		for(int i = 0; i <= 9; i++)
		{
			if(i == 0)
			{
				System.out.println("  0   1   2   3   4   5   6   7   8   9  ");
				System.out.println("|---+---+---+---+---+---+---+---+---+---|");
			}
			for(int f = 0; f <= 9; f++)
			{
				if(f < 9)
				{
					System.out.print("| "+campo[i][f]+" ");
				}
				else
				{
					System.out.print("| "+campo[i][f]+" |");
				}
			}
			System.out.println(" "+i+"");
			System.out.println("|---+---+---+---+---+---+---+---+---+---|");	
		}
	}
	
	public void VerificaNumero(int flag2)
	{
		do
		{
			System.out.print("Informe a linha:");
			h = obter.nextInt();
			System.out.print("Informe a coluna:");
			v = obter.nextInt();
			if(h <= 9 && h >= 0 && v <= 9 && v >= 0)
			{
				flag2 = 1;		
			}
			else 
			{
				System.out.println("");
				System.out.println("Número inválido!!");
				System.out.println("Digite novamente");
				System.out.println("");
			}
		}while(flag2 == 0);
	}
	
	public void VerificaTamanho(int tamanho)
	{
		this.tamanho = tamanho;
	}
	
	public void VerificaDirecao(int direcao)
	{
		this.direcao = direcao;
	}
	
	public void VerificaMatriz(int[][] campo)
	{	
		campo2[h][v] = campo[h][v] + 1;
		if(tamanho == 1 && direcao == 1)
		{
			campo2[h][v+1] = campo[h][v+1] + 1;
		}
		if(tamanho == 1 && direcao == 2)
		{
			campo2[h+1][v] = campo[h+1][v] + 1;
		}
	
		if(flag != 0)
		{
			tamanho2 = 0;
			flag4 = 0;
			while(flag4 <= tamanho)
			{
				flag4 = 0;
				tamanho2 = 0;
				while(tamanho2 <= tamanho)
				{
					if(campo2[h+tamanho2][v] >= 2 || campo2[h][v+tamanho2] >= 2)
					{
						tamanho2 = 0;
						flag4 = 0;
						System.out.println("");
						System.out.println("Posição digitada já preenchida!");
						System.out.println("Digite novamente");
						System.out.println("");
		
						if(tamanho2 == 0)
							campo2[h][v] = 1;
						if(tamanho2 == 1 && direcao == 1)
						{
							campo2[h][v+1] = 1;
						}
						if(tamanho2 == 1 && direcao == 2)
						{
							campo2[h+1][v] = 1;
						}
											
						flag2 = 0;
								
						while(flag2 == 0)
						{
							System.out.print("Informe a linha:");
							h = obter.nextInt();
							System.out.print("Informe a coluna:");
							v = obter.nextInt();
							if(tamanho2 == 0)
								campo2[h][v]++;
							if(h <= 9 && h >= 0 && v <= 9 && v >= 0)
							{
								flag2 = 1;
							}
							else
							{
								System.out.println("");
								System.out.println("Número inválido!!");
								System.out.println("Digite novamente");
								System.out.println("");
							}
						}
					}
					if(tamanho2 == 0)
						campo2[h][v]++;
					if(direcao == 1)
					{
						switch(tamanho2)
						{
							case 1 : {
								if(h < 9)
									{
										campo2[h][v+tamanho2]++;
									}
									else
									{
										System.out.println("Posição inválida!!");
									}
								}break;
							}
						}
						else if(direcao == 2)
						{
							switch(tamanho2)
							{
								case 1 : {
									if(v < 9)
									{
										campo2[h+tamanho2][v]++;
									}
									else
									{
										System.out.println("Posição inválida!!");
									}
								}break;
							}
						}	
					else
					{
						if(tamanho2 == 0)
							campo2[h][v] = 1;
						if(direcao == 1)
						{
							switch(tamanho2)
							{
								case 1 : {
									if(h < 9)
									{
										campo2[h][v+tamanho2] = 2;
									}
									else
									{
										System.out.println("Posição inválida!!");
									}
								}break;
							}
						}
						else if(direcao == 2)
						{
							switch(tamanho2)
							{
								case 1 : {
									if(v < 9)
									{
										campo2[h+tamanho2][v] = 2;
									}
									else
									{
										System.out.println("Posição inválida!!");
									}
								}break;
							}
						}
						tamanho2++;
						flag4++;
					}
				}
			}
		}
		tamanho2 = 0;
		while(tamanho2 <= tamanho)
		{
			if(tamanho == 0)
				campo[h][v] = campo2[h][v];
			if(tamanho == 1 && direcao == 1)
			{
				campo[h][v] = campo2[h][v] + 1;
				campo[h][v+1] = campo2[h][v+1] + 1;
			}
			if(tamanho == 1 && direcao == 2)
			{
				campo[h][v] = campo2[h][v] + 1;
				campo[h+1][v] = campo2[h+1][v] + 1;
			}
			tamanho2++;
		}
		flag++;
	}
}