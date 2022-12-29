package com.vesska;

import java.util.ArrayList;
import java.util.List;

public class Me {
    public String name;
    public int age;
    public List<String> citizenship = new ArrayList<>();
    public String profession;

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public List<String> getCitizenship() {
        return citizenship;
    }
    public String getProfession() {
        return profession;
    }

}
