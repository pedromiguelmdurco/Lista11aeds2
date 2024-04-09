package num1;

import java.util.Scanner;

public class teste {

	public static int pesquisaBinaria(int[] array, int n, int x) {// n é o tamanho e o x é o valor pesquisado
		boolean resp = false;
		int dir = n - 1, esq = 0, meio=0;
		while (esq <= dir) {
			meio = (esq + dir) / 2;
			if (x == array[meio]) {
				resp = true;
				esq = n;
			} else if (x > array[meio]) {
				esq = meio + 1;
			} else {
				dir = meio - 1;
			}
		}
		if (resp == true) {
			return meio;
		} else {
			return -1;

		}
	}

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		System.out.println("Digite a quantidade de elementos: ");
		int[] array = new int[teclado.nextInt()];
		for (int cont = 0; cont < array.length; cont++) {
			System.out.println("Digite o valor que ficara na posicao " + (cont+1));
			array[cont] = teclado.nextInt();
		}

		System.out.println("Qual Numero gostaria de procurar");
		System.out.println("Posicao do Elemento é "+pesquisaBinaria(array, array.length, teclado.nextInt()));

	

		teclado.close();

	}

}
