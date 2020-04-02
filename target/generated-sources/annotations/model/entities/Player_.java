package model.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Player.class)
public abstract class Player_ {

	public static volatile SingularAttribute<Player, Integer> idPlayers;
	public static volatile SingularAttribute<Player, Date> birth_date;
	public static volatile SingularAttribute<Player, Integer> club_id;
	public static volatile SingularAttribute<Player, String> name;
	public static volatile SingularAttribute<Player, Float> transfer_cost;
	public static volatile SingularAttribute<Player, Integer> goals;

	public static final String ID_PLAYERS = "idPlayers";
	public static final String BIRTH_DATE = "birth_date";
	public static final String CLUB_ID = "club_id";
	public static final String NAME = "name";
	public static final String TRANSFER_COST = "transfer_cost";
	public static final String GOALS = "goals";

}

