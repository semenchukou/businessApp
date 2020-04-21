package model.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Club.class)
public abstract class Club_ {

	public static volatile SingularAttribute<Club, Integer> club_id;
	public static volatile SingularAttribute<Club, String> name;
	public static volatile SingularAttribute<Club, Integer> foundation_year;
	public static volatile SingularAttribute<Club, String> coach;

	public static final String CLUB_ID = "club_id";
	public static final String NAME = "name";
	public static final String FOUNDATION_YEAR = "foundation_year";
	public static final String COACH = "coach";

}

