package com.mnmlyn.empmanager.DAO;

import com.mnmlyn.empmanager.entry.EmpDO;

import java.util.List;

public interface EmpDAO {
    EmpDO queryEmp();
    List<EmpDO> listAllEmps();
    boolean insertEmp(EmpDO empDO);
    boolean deleteEmpById(int id);
}
