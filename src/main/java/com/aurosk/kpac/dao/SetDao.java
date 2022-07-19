package com.aurosk.kpac.dao;

import com.aurosk.kpac.model.Set;

import java.util.List;

public interface SetDao {
    Set addSet(Set set);
    List<Set> listSets();
    void deleteSet(int id);
}
