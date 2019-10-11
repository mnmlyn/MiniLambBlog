package com.mnmlyn.empmanager.DAO.impl;

import com.mnmlyn.empmanager.DAO.DAOBase;
import com.mnmlyn.empmanager.DAO.EmpDAO;
import com.mnmlyn.empmanager.entry.EmpDO;

public class EmpDAOImpl extends DAOBase implements EmpDAO {

    @Override
    public EmpDO queryEmp() {
        return getSqlSessionTemplate().selectOne("emp.selectEmp", 1);
    }
}
