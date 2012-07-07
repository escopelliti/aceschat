package Person;

import java.io.Serializable;

/*
 * Classe astratta che rappresenta l'entità Person  separata logicamente da User
 */
public abstract class Person implements Serializable{

    protected int idPerson;
    protected String name;
    protected String surname;
    protected String birthday;
    protected String city;
    protected String nation;
    protected String sex;
    protected String job;
    protected String[] interests = new String [6];


}
