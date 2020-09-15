package ee.valiit.project.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@Repository
public class RepositoryClient {

    @Autowired NamedParameterJdbcTemplate jdbcTemplate;

    public void createClient(String request) {
        String sql = "INSERT INTO clients (client_name) VALUE (:name)";
        Map paramMap = new HashMap();
        paramMap.put("name", request);
        jdbcTemplate.update(sql, paramMap);
    }

    public int getClientId(String name) {
        String sql = "SELECT client_id FROM clients WHERE client_name = :name";
        Map paramMap = new HashMap();
        paramMap.put("name", name);
        return jdbcTemplate.queryForObject(sql, paramMap, int.class);
    }
}
