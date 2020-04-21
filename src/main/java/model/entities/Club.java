package model.entities;

import javax.persistence.*;

@Entity(name = "clubs")
@Table(name = Club.tableName)
public class Club implements java.io.Serializable{

    public static final String tableName = "clubs";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int club_id;

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

    public int getClub_id() {
        return club_id;
    }

    public void setClub_id(int idClub) {
        this.club_id = idClub;
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
                "idClub=" + club_id +
                ", name='" + name + '\'' +
                ", coach='" + coach + '\'' +
                ", foundation_year=" + foundation_year +
                '}';
    }
}
