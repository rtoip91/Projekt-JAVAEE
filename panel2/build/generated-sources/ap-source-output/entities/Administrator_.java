package entities;

import entities.Budynek;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-06-11T22:15:35")
@StaticMetamodel(Administrator.class)
public class Administrator_ { 

    public static volatile SingularAttribute<Administrator, Integer> id;
    public static volatile SingularAttribute<Administrator, String> haslo;
    public static volatile SingularAttribute<Administrator, String> imie;
    public static volatile SingularAttribute<Administrator, String> nazwa;
    public static volatile SingularAttribute<Administrator, String> login;
    public static volatile SingularAttribute<Administrator, Budynek> budynekID;
    public static volatile SingularAttribute<Administrator, String> nazwisko;
    public static volatile SingularAttribute<Administrator, Integer> uprawnienieID;

}