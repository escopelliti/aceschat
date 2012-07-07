package User;

import Person.*;
import java.io.Serializable;
import javax.swing.ImageIcon;

/*
 * Classe estesa da Person, rappresenta l'entità User e definisce l'utente dell'applicazione
 */
public class User extends Person implements Serializable{

    public User(String name,String surname,String email,String birthday,String city,String nation,String sex,String job){
        this.name=name;
        this.surname=surname;
        this.birthday=birthday;
        this.email = email;
        this.city=city;
        this.nation=nation;
        this.sex=sex;
        this.job=job;
    }

    //metodi per l'accesso agli attributi della classe
    public String getBirthday() {
        return birthday;
    }

    public ImageIcon getPersonalImage() {
        return personalImage;
    }

    public String getCity() {
        return city;
    }

    public int getIdPerson() {
        return idPerson;
    }
    
    public String getNation() {
        return nation;
    }

    public String getSex() {
        return sex;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getJob() {
        return job;
    }

    public String getEmail() {
        return email;
    }

    public int getLevel() {
        return level;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return Username;
    }

    public String[] getInterests() {
        return interests;
    }

    public int getWarning() {
        return warning;
    }

    public String getIp() {
        return ip;
    }

    //metodi per settare gli attributi della classe
    public void setInterests(String[] interests) {
        this.interests = interests;
    }

    public void setPersonalImage(ImageIcon personalImage) {
        this.personalImage = personalImage;
    }
        
    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setInterests(String interest) {
        int i = 0;

        while(i < interests.length){
            
            if((interests[i] == interest)){
                interests[i] = null;
                break;
            }
            if(interests[i] == null){
                interests[i] = interest;
                break;
            }
            i++;
      }

    }

    public void setWarning(int warning) {
        this.warning = warning;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    private ImageIcon personalImage;
    private String Username;
    private String password;
    private String email;
    private int warning = 0;
    private int level = 1;
    private String ip;

}
