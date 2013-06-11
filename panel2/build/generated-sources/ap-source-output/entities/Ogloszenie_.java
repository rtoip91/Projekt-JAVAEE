package entities;

import entities.Budynek;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-06-11T22:15:35")
@StaticMetamodel(Ogloszenie.class)
public class Ogloszenie_ { 

    public static volatile SingularAttribute<Ogloszenie, Integer> id;
    public static volatile SingularAttribute<Ogloszenie, String> tresc;
    public static volatile SingularAttribute<Ogloszenie, Budynek> budynekID;

}