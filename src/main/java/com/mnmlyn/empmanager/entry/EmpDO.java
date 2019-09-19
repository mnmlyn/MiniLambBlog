package com.mnmlyn.empmanager.entry;

import lombok.Getter;
import lombok.Setter;

/**
 * 员工信息的数据对象
 *
 * @author mnmlyn
 */
@Getter
@Setter
public class EmpDO {
    private Integer id;
    private String name;
    private Integer age;

    public EmpDO() {
        System.out.println("init Emp");
    }

    @Override
    public String toString() {
        return "EmpDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
