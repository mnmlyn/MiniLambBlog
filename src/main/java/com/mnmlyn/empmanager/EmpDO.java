package com.mnmlyn.empmanager;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpDO {
    private int id;
    private String name;
    private int age;

    @Override
    public String toString() {
        return "EmpDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
