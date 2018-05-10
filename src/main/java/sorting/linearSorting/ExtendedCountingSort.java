package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if(array.length != 0 && leftIndex <= rightIndex && rightIndex < array.length) {
			int maior = 0;
			int menor = array[leftIndex];
			for(int i = leftIndex; i <= rightIndex; i++) {
				if(array[i].compareTo(maior) > 0) {
					maior = array[i];
				}
				if(array[i].compareTo(menor) < 0) {
					menor = array[i];
				}
			}
		
			int tamanho = rightIndex - leftIndex + 1;
			int[] aux = new int[maior + 1 + Math.abs(menor)];
			int[] result = new int[tamanho];

			for (int i = leftIndex; i <= rightIndex; i++) {
				aux[array[i] + Math.abs(menor)]++;
			}
		
			for (int i = 1; i < aux.length; i++) {
				aux[i] += aux[i - 1];
			}

			for (int i = tamanho - 1; i >= 0; i--) {
				result[aux[array[i] + Math.abs(menor)] - 1] = array[i];
				aux[array[i] + Math.abs(menor)]--;
			}
        
			for (int i = leftIndex; i <= rightIndex ; i++) {
				array[i] = result[i];
			}
        
		}
	}
}
