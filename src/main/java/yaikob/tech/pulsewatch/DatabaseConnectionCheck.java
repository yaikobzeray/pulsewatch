package yaikob.tech.pulsewatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component 
public class DatabaseConnectionCheck implements CommandLineRunner{

    private final JdbcTemplate jdbcTemplate;
    public DatabaseConnectionCheck(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) throws Exception {

        String database = jdbcTemplate.queryForObject("SELECT current_database()", String.class);
        String user = jdbcTemplate.queryForObject("SELECT current_user", String.class);
        System.out.println("Connected to database: " + database + " as user: " + user);
    }
    
}
// https://github.com/yaikobzeray/pulsewatch.git
