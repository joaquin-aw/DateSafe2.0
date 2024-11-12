package src.java;

import android.graphics.Bitmap;

public class Profile {

    private String Name;
    private String Birthdate;
    private int Age;
    private String sex;
    private Bitmap pic1;
    private Bitmap pic2;
    private Bitmap pic3;
    private int warnings;
    private String ethnicity;
    private String bio;

    public Profile(String name, int age, String birthdate, String sex, Bitmap pic1, Bitmap pic2, Bitmap pic3, int warnings, String ethnicity, String bio) {
        this.Name = "name";
        this.Age = 0;
        this.Birthdate = "1/1/2024";
        this.sex = "Male";
        this.pic1 = pic1;
        this.pic2 = pic2;
        this.pic3 = pic3;
        this.warnings = 0;
        this.ethnicity = "Good one";
        this.bio = "Hi there I'm looking for love!";
    }

    public String getName() {
        return Name;
    }

    public String getBirthdate() {
        return Birthdate;
    }

    public int getAge() {
        return Age;
    }

    public String getSex() {
        return sex;
    }

    public Bitmap getPic1() {
        return pic1;
    }

    public Bitmap getPic2() {
        return pic2;
    }

    public Bitmap getPic3() {
        return pic3;
    }
    public int getWarnings() {
        return warnings;
    }
    public String getEthnicity() {
        return ethnicity;
    }
    public String getBio() {
        return bio;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setAge(int age) {
        Age = age;
    }
    public void setBirthdate(String birthdate) {
        Birthdate = birthdate;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setPic1(Bitmap pic1) {
        this.pic1 = pic1;
    }
    public void setPic2(Bitmap pic2) {
        this.pic2 = pic2;
    }
    public void setPic3(Bitmap pic3) {
        this.pic3 = pic3;
    }

    public void setWarnings(int warnings) {
        this.warnings = warnings;
    }
    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }
}
