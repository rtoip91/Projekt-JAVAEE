package entities;

import entities.Mieszkaniec;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-06-11T22:15:35")
@StaticMetamodel(Sprawa.class)
public class Sprawa_ { 

    public static volatile SingularAttribute<Sprawa, Integer> id;
    public static volatile SingularAttribute<Sprawa, String> tresc;
    public static volatile SingularAttribute<Sprawa, String> status;
    public static volatile SingularAttribute<Sprawa, Mieszkaniec> mieszkaniecID;

}