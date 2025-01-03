public class PassangerDetails {
    private String name;
    private int age;
    private String gender;
    private String berth;

    PassangerDetails(String name, int age, String gender, String berth){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.berth = berth;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public void setBerth(String berth){
        this.berth = berth;
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getGender(){
        return gender;
    }
    public String getBerth(){
        return berth;
    }
    public void updateBerth(String b){
        this.berth = b;
    }
    public String assignedBerth(){
        return berth;
    }
}
