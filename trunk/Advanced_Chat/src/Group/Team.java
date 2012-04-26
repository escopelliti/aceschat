package Group;


public class Team {

    public Team(int idFounder, String name, String description, String imagePath, String dateTime ){

        this.idFounder = idFounder;
        this.name = name;
        this.description = description;
        this.imagePath = dateTime;
        this.dateTime = dateTime;
    }

    public int getCodGroup() {
        return codGroup;
    }

    public String getDateTime() {
        return dateTime;
    }

    public int getIdFounder() {
        return idFounder;
    }

    public void setCodGroup(int codGroup) {
        this.codGroup = codGroup;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }


    public void setIdFounder(int idFounder) {
        this.idFounder = idFounder;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    
    private int codGroup;
    private int idFounder;
    private String name;
    private String description;
    private String imagePath;
    private String dateTime;


}
