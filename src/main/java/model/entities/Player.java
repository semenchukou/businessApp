package model.entities;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Players")
@Table(name = Player.tableName)
public class Player {

    public static final String tableName = "Players";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPlayers;

    private String name;

    private Date birth_date;

    private float transfer_cost;

    private int goals;

    private int club_id;

    public Player(){}

    public Player(String name,
                  Date birth_date,
                  float transfer_cost,
                  int goals,
                  int club_id){
        this.name = name;
        this.birth_date = birth_date;
        this.transfer_cost = transfer_cost;
        this.goals = goals;
        this.club_id = club_id;
    }

    public Player(String name,
                  float transfer_cost,
                  int goals,
                  int club_id){
        this.name = name;
        this.transfer_cost = transfer_cost;
        this.goals = goals;
        this.club_id = club_id;
    }

    public int getIdPlayers() {
        return idPlayers;
    }

    public void setIdPlayers(int idPlayers) {
        this.idPlayers = idPlayers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public float getTransfer_cost() {
        return transfer_cost;
    }

    public void setTransfer_cost(float transfer_cost) {
        this.transfer_cost = transfer_cost;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getClub_id() {
        return club_id;
    }

    public void setClub_id(int club_id) {
        this.club_id = club_id;
    }

    @Override
    public String toString() {
        return "Player{" +
                "idPlayers=" + idPlayers +
                ", name='" + name + '\'' +
                ", birth_date=" + birth_date +
                ", transfer_cost=" + transfer_cost +
                ", goals=" + goals +
                ", club_id=" + club_id +
                '}';
    }
}
