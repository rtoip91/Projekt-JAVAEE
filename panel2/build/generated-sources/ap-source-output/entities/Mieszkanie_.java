package entities;

import entities.Budynek;
import entities.Mieszkaniec;
import entities.Oplata;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-06-11T22:15:35")
@StaticMetamodel(Mieszkanie.class)
public class Mieszkanie_ { 

    public static volatile SingularAttribute<Mieszkanie, Integer> id;
    public static volatile SingularAttribute<Mieszkanie, Float> zuzycieciepla;
    public static volatile ListAttribute<Mieszkanie, Oplata> oplataList;
    public static volatile SingularAttribute<Mieszkanie, Float> obciazenie;
    public static volatile SingularAttribute<Mieszkanie, String> nazwa;
    public static volatile SingularAttribute<Mieszkanie, String> nrPosesji;
    public static volatile SingularAttribute<Mieszkanie, Mieszkaniec> mieszkaniecID;
    public static volatile SingularAttribute<Mieszkanie, Budynek> budynekID;
    public static volatile SingularAttribute<Mieszkanie, Integer> metrarz;
    public static volatile SingularAttribute<Mieszkanie, Float> ryczaltogrzewania;

}