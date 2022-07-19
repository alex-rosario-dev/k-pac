package com.aurosk.kpac.mapper;

import com.aurosk.kpac.model.Set;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SetRowMapper implements RowMapper<Set> {
    @Override
    public Set mapRow(ResultSet rs, int rowNum) throws SQLException {
        Set set = new Set();
        int id = rs.getInt("id");
        set.setId(id);
        set.setTitle(rs.getString("title"));
        return set ;
    }
}
