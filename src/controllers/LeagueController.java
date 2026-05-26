package controllers;

import models.League;

public class LeagueController {

    /**
     * Selection Sort ascendente - Ordena por goles activos totales de menor a
     * mayor.
     *
     * @param leagues Arreglo de ligas a ordenar
     * @return Arreglo ordenado
     */
    public League[] sortSelectionAsc(League[] leagues) {
        int n = leagues.length;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (leagues[j].getTotalActiveGoals() < leagues[minIdx].getTotalActiveGoals()) {
                    minIdx = j;
                }
            }
            League temp = leagues[minIdx];
            leagues[minIdx] = leagues[i];
            leagues[i] = temp;
        }

        return leagues;
    }

    /**
     * Insertion Sort descendente - Ordena por goles activos totales de mayor a
     * menor.
     *
     * @param leagues Arreglo de ligas a ordenar
     * @return Arreglo ordenado
     */
    public League[] sortInsertionDesc(League[] leagues) {
        int n = leagues.length;

        for (int i = 1; i < n; i++) {
            League key = leagues[i];
            int j = i - 1;

            while (j >= 0 && leagues[j].getTotalActiveGoals() < key.getTotalActiveGoals()) {
                leagues[j + 1] = leagues[j];
                j--;
            }
            leagues[j + 1] = key;
        }

        return leagues;
    }

    /**
     * Busqueda binaria por goles activos totales.
     * El arreglo debe estar ordenado previamente segun la fila del estudiante.
     * El orden (ascendente o descendente) se detecta automaticamente comparando
     * el primer y ultimo elemento del arreglo.
     *
     * @param leagues          Arreglo de ligas ya ordenado
     * @param totalActiveGoals Valor a buscar
     * @return La liga encontrada o null si no existe
     */
    public League binarySearchByTotalActiveGoals(League[] leagues, int totalActiveGoals) {
        if (leagues == null || leagues.length == 0) {
            return null;
        }

        boolean isAscending = leagues[0].getTotalActiveGoals() <= leagues[leagues.length - 1].getTotalActiveGoals();

        int left = 0;
        int right = leagues.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midGoals = leagues[mid].getTotalActiveGoals();

            if (midGoals == totalActiveGoals) {
                return leagues[mid];
            }

            if (isAscending) {
                if (midGoals < totalActiveGoals) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (midGoals > totalActiveGoals) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return null;
    }

    /**
     * Imprime el arreglo de ligas en consola.
     *
     * @param leagues Arreglo de ligas a imprimir
     */
    public void printLeagues(League[] leagues) {
        for (League league : leagues) {
            System.out.println(league);
        }
    }
}
