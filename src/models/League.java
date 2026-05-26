package models;

public class League {
    private String name;
    private Team[] teams;

    public League(String name, Team[] teams) {
        this.name = name;
        this.teams = teams;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team[] getTeams() {
        return teams;
    }

    public void setTeams(Team[] teams) {
        this.teams = teams;
    }

    /**
     * Calcula el total de goles anotados por jugadores activos
     * en todos los equipos de esta liga.
     *
     * @return suma de goles de todos los jugadores con isActive = true
     */
    public int getTotalActiveGoals() {
        int total = 0;
        for (Team team : teams) {
            if (team != null && team.getPlayers() != null) {
                for (Player player : team.getPlayers()) {
                    if (player != null && player.isActive()) {
                        total += player.getGoals();
                    }
                }
            }
        }
        return total;
    }

    @Override
    public String toString() {
        return "Liga: " + name + " | Goles activos totales: " + getTotalActiveGoals();
    }
}
