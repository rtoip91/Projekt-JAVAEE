package entities;

import entities.Mieszkanie;
import entities.Sprawa;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-06-11T22:15:35")
@StaticMetamodel(Mieszkaniec.class)
public class Mieszkaniec_ { 

    public static volatile SingularAttribute<Mieszkaniec, Integer> id;
    public static volatile SingularAttribute<Mieszkaniec, String> haslo;
    public static volatile ListAttribute<Mieszkaniec, Mieszkanie> mieszkanieList;
    public static volatile SingularAttribute<Mieszkaniec, String> nrtelefonu;
    public static volatile SingularAttribute<Mieszkaniec, String> imie;
    public static volatile SingularAttribute<Mieszkaniec, String> email;
    public static volatile SingularAttribute<Mieszkaniec, String> nazwa;
    public static volatile SingularAttribute<Mieszkaniec, String> login;
    public static volatile SingularAttribute<Mieszkaniec, String> nazwisko;
    public static volatile SingularAttribute<Mieszkaniec, Integer> uprawnienieID;
    public static volatile ListAttribute<Mieszkaniec, Sprawa> sprawaList;

}