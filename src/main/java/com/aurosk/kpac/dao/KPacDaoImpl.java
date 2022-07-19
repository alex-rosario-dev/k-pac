package com.aurosk.kpac.dao;

import com.aurosk.kpac.mapper.KPacRowMapper;
import com.aurosk.kpac.model.KPac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class KPacDaoImpl implements KPacDao {

    private final DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert jdbcInsert;
    private static final String NEXT_SEQUENCE  = "select max(id) from k_pac";

    @Autowired
    public KPacDaoImpl(DataSource dataSourc) {
        this.dataSource = dataSourc;
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("k_pac").usingGeneratedKeyColumns("id");
    }

    @Override
    public KPac addKPac(KPac pac) {
        SqlParameterSource parameters = new BeanPropertySqlParameterSource(pac);
        jdbcInsert.execute(parameters);
        pac.setId(nextSequence());
        return pac;
    }

    @Override
    public List<KPac> listKPacs() {
        String query = "SELECT id, title, description, creation_date FROM k_pac";
        return jdbcTemplate.query(query, new KPacRowMapper());
    }

    @Override
    public void deleteKPac(int id) {
        String updateQuery = "UPDATE k_pac_set SET k_pac_id = NULL WHERE k_pac_id=?" ;
        String query = "DELETE FROM k_pac WHERE id = ?";
        jdbcTemplate.update(updateQuery, id);
        jdbcTemplate.update(query, id);
    }

    @Override
    public List<KPac> findKPacBySet(int setId) {
        String query = "SELECT k_pac.id, title, description, creation_date FROM k_pac JOIN k_pac_set ON k_pac.id = k_pac_set.k_pac_id where set_id = ?";
        return jdbcTemplate.query(query, new Object[] {setId}, new KPacRowMapper());
    }

    private long nextSequence() {
        final SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(NEXT_SEQUENCE);
        sqlRowSet.next();
        return sqlRowSet.getLong(1);
    }
}
