package com.aurosk.kpac.dao;
import com.aurosk.kpac.mapper.SetRowMapper;
import com.aurosk.kpac.model.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SetDaoImpl implements SetDao {


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SetDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Set addSet(Set set) {
        String kpacSetQuery = "INSERT INTO k_pac_set (k_pac_id, set_id) VALUES (?, ?)";
        SimpleJdbcInsert simpleJdbcInsert =  new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert.withTableName("`set`").usingGeneratedKeyColumns("id");
        Map<String, Object> params = new HashMap<>();
        params.put("title", set.getTitle());
        Number id = simpleJdbcInsert.executeAndReturnKey(params);
        set.getkPacIds().forEach( kPac -> jdbcTemplate.update(kpacSetQuery, kPac, id));
        return set;
    }

    @Override
    public List<Set> listSets() {
        String query = "SELECT id, title FROM `set`";
        return jdbcTemplate.query(query, new SetRowMapper());
    }

    @Override
    public void deleteSet(int id) {
        String updateQuery = "UPDATE k_pac_set SET set_id = NULL WHERE set_id=?" ;
        String query = "DELETE FROM `set` WHERE id = ?";
        jdbcTemplate.update(updateQuery, id);
        jdbcTemplate.update(query, id);
    }
}
