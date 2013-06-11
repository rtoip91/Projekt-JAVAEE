package entities;

import entities.Mieszkanie;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-06-11T22:15:35")
@StaticMetamodel(Oplata.class)
public class Oplata_ { 

    public static volatile SingularAttribute<Oplata, Integer> id;
    public static volatile SingularAttribute<Oplata, Float> kwota;
    public static volatile SingularAttribute<Oplata, Mieszkanie> mieszkanieID;
    public static volatile SingularAttribute<Oplata, String> status;
    public static volatile SingularAttribute<Oplata, Date> data;
    public static volatile SingularAttribute<Oplata, String> opis;
    public static volatile SingularAttribute<Oplata, String> typ;

}