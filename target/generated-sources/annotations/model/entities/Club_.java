package model.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Club.class)
public abstract class Club_ {

	public static volatile SingularAttribute<Club, String> name;
	public static volatile SingularAttribute<Club, Integer> foundation_year;
	public static volatile SingularAttribute<Club, String> coach;
	public static volatile SingularAttribute<Club, Integer> idClub;

	public static final String NAME = "name";
	public static final String FOUNDATION_YEAR = "foundation_year";
	public static final String COACH = "coach";
	public static final String ID_CLUB = "idClub";

}

