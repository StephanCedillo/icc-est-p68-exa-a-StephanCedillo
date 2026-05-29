package controllers;

import models.League;

public class LeagueController {

    /**
     * FILA A - Implementar este metodo con Selection Sort ascendente.
     * Ordena el arreglo de ligas de menor a mayor segun getTotalActiveGoals().
     *
     * Nombre exacto requerido: sortSelectionAsc
     *
     * @param leagues Arreglo de ligas a ordenar
     * @return Arreglo ordenado
     */
    public League[] sortSelectionAsc(League[] leagues) {
        for (int i = 0; i < leagues.length; i++) {
            int index = i; 
            for (int j = i; j < leagues.length; j++) {
               if (leagues[index].getTotalActiveGoals()>leagues[j].getTotalActiveGoals()) {
                index = j;
               }
            }

            if (i != index) {
                League aux = leagues[i];
                leagues[i] =  leagues[index];
                leagues[index] = aux;

            }
        }
        return leagues;
    }




    /**
     * FILA B - Implementar este metodo con Insertion Sort descendente.
     * Ordena el arreglo de ligas de mayor a menor segun getTotalActiveGoals().
     *
     * Nombre exacto requerido: sortInsertionDesc
     *
     * @param leagues Arreglo de ligas a ordenar
     * @return Arreglo ordenado
     */
    public League[] sortInsertionDesc(League[] leagues) {
        // TODO: Implementar (solo si su fila es B)
        throw new UnsupportedOperationException("Metodo sortInsertionDesc no implementado");
    }

    /**
     * TODOS - Implementar busqueda binaria por goles activos totales.
     *
     * El arreglo recibido ya fue ordenado con el metodo de su fila.
     * Implemente la busqueda conforme al orden que aplico:
     * - Fila A: arreglo ascendente, use logica de busqueda ascendente.
     * - Fila B: arreglo descendente, use logica de busqueda descendente.
     *
     * Nombre exacto requerido: binarySearchByTotalActiveGoals
     *
     * @param leagues          Arreglo de ligas ya ordenado
     * @param totalActiveGoals Total de goles activos a buscar
     * @return La liga encontrada, o null si no existe
     */
    public League binarySearchByTotalActiveGoals(League[] leagues, int totalActiveGoals) {
        int inicio = 0;
        int fin = leagues.length - 1;
        while (inicio<=fin) {
            int centro = inicio + (fin - inicio) / 2;
            if (leagues[centro].getTotalActiveGoals() == totalActiveGoals) {
                return leagues[centro];
            }else if (leagues[centro].getTotalActiveGoals()<totalActiveGoals){
                inicio = centro + 1 ;     
            }else{
                fin = centro - 1;
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
