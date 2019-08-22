package com.mnmlyn.empmanager.DAO.impl;

import com.mnmlyn.empmanager.DAO.DAOBase;
import com.mnmlyn.empmanager.DAO.EmpDAO;
import com.mnmlyn.empmanager.entry.EmpDO;

import java.util.ArrayList;
import java.util.List;

public class EmpDAOImpl extends DAOBase implements EmpDAO {

    @Override
    public EmpDO queryEmp() {
        return getSqlSessionTemplate().selectOne("emp.selectEmp", 1);
    }

    @Override
    public List<EmpDO> listAllEmps() {
        List<EmpDO> empList = getSqlSessionTemplate().selectList("emp.listAllEmps");
        if (empList != null) {
            return empList;
        }
        return new ArrayList<>();
    }

    @Override
    public boolean insertEmp(EmpDO empDO) {
        int affectRow = getSqlSessionTemplate().insert("emp.insertEmp", empDO);
        return (affectRow == 1);
    }

    @Override
    public boolean deleteEmpById(int id) {
        int affectRow = getSqlSessionTemplate().delete("emp.deleteEmpById", id);
        return (affectRow == 1);
    }
}
