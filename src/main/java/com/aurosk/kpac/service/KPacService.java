package com.aurosk.kpac.service;

import com.aurosk.kpac.dao.KPacDao;
import com.aurosk.kpac.dao.SetDao;
import com.aurosk.kpac.model.KPac;
import com.aurosk.kpac.model.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class KPacService {

    private final SetDao setDao;
    private final KPacDao kPacDao;

    @Autowired
    public KPacService(SetDao setDao, KPacDao kPacDao) {
        this.setDao =  setDao;
        this.kPacDao = kPacDao;
    }
    public void deleteKPac(int id) {
        kPacDao.deleteKPac(id);
    }
    public KPac addKPac(KPac kPac) {
        kPac.setCreationDate(new Date());
        return kPacDao.addKPac(kPac);
    }
    public List<KPac> listKPacs() {
        List<KPac> kPacs = kPacDao.listKPacs();
        kPacs.forEach(kPac -> kPac.setCreationDateStr(formatDate(kPac.getCreationDate())));
        return kPacs;
    }

    public void deleteSet(int id) {
        setDao.deleteSet(id);
    }
    public Set addSet(Set set) {
        return setDao.addSet(set);
    }
    public List<Set> listSets() {
        return setDao.listSets();
    }
    public List<KPac> findKPacBySet(int id) {
        return kPacDao.findKPacBySet(id);
    }

    private String formatDate(Date date) {
        SimpleDateFormat mdyFormat = new SimpleDateFormat("dd-MM-yyyy");
        return mdyFormat.format(date);
    }
}
