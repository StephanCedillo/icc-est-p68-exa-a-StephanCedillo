package models;

import java.util.Arrays;

public class League {
  private String name;
  private Team[] teams;

  public League() {
  }

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

  

  @Override
  public String toString() {
    return "League [name=" + name + ", teams=" + Arrays.toString(teams) + ", getTotalActiveGoals()="
        + getTotalActiveGoals() + "]";
  }

  public int getTotalActiveGoals() {
    int cantidadGoles = 0;

    for (int i = 0; i < teams.length; i++) {
  
      Player[] players = teams[i].getPlayers();
      for (Player player : players) {
        if (player.isActive()) {
            cantidadGoles += player.getGoals();
          } 
      }
      
    }
    return cantidadGoles;
  }

}
