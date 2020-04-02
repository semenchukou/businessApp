package model.entities;

import javax.persistence.*;

@Entity(name = "Clubs")
@Table(name = Club.tableName)
public class Club implements java.io.Serializable{

    public static final String tableName = "Clubs";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClub;

    private String name;

    private String coach;

    private int foundation_year;

    public Club(){}

    public Club(String name,
                String coach,
                int foundation_year){
        this.name = name;
        this.coach = coach;
        this.foundation_year = foundation_year;
    }

    public int getIdClub() {
        return idClub;
    }

    public void setIdClub(int idClub) {
        this.idClub = idClub;
    }

    public String getName() {
        return name;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public int getFoundation_year() {
        return foundation_year;
    }

    public void setFoundation_year(int foundation_year) {
        this.foundation_year = foundation_year;
    }

    @Override
    public String toString() {
        return "Club{" +
                "idClub=" + idClub +
                ", name='" + name + '\'' +
                ", coach='" + coach + '\'' +
                ", foundation_year=" + foundation_year +
                '}';
    }
}
