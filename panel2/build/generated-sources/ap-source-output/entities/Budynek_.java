package entities;

import entities.Administrator;
import entities.Mieszkanie;
import entities.Ogloszenie;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-06-11T22:15:35")
@StaticMetamodel(Budynek.class)
public class Budynek_ { 

    public static volatile SingularAttribute<Budynek, Integer> id;
    public static volatile ListAttribute<Budynek, Mieszkanie> mieszkanieList;
    public static volatile SingularAttribute<Budynek, Integer> powierzchnia;
    public static volatile ListAttribute<Budynek, Ogloszenie> ogloszenieList;
    public static volatile SingularAttribute<Budynek, Float> obciazenieBudynku;
    public static volatile SingularAttribute<Budynek, String> nazwa;
    public static volatile ListAttribute<Budynek, Administrator> administratorList;
    public static volatile SingularAttribute<Budynek, String> miasto;
    public static volatile SingularAttribute<Budynek, String> kodPocztowy;
    public static volatile SingularAttribute<Budynek, Integer> iloscMieszkan;
    public static volatile SingularAttribute<Budynek, String> ulica;
    public static volatile SingularAttribute<Budynek, String> nrDzialki;

}