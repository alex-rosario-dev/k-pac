package com.aurosk.kpac.dao;

import com.aurosk.kpac.model.KPac;

import java.util.List;

public interface KPacDao {
    KPac addKPac(KPac pac);
    List<KPac> listKPacs();
    void deleteKPac(int id);
    List<KPac> findKPacBySet(int setId);

}
