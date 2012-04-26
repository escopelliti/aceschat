/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Person;

import java.io.Serializable;




/**
 *
 * @author enrico
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
