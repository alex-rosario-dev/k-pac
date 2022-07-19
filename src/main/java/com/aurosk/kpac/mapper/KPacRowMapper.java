package com.aurosk.kpac.mapper;

import com.aurosk.kpac.model.KPac;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KPacRowMapper implements RowMapper<KPac> {
    @Override
    public KPac mapRow(ResultSet rs, int rowNum) throws SQLException {
        KPac kPac = new KPac();
        Long id = rs.getLong("id");
        kPac.setId(id);
        kPac.setTitle(rs.getString("title"));
        kPac.setDescription(rs.getString("description"));
        kPac.setCreationDate(rs.getDate("creation_date"));
        return kPac ;
    }
}
