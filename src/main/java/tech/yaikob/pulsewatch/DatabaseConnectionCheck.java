package tech.yaikob.pulsewatch;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component 
public class DatabaseConnectionCheck implements CommandLineRunner{

    private final DataSource dataSource;
    public DatabaseConnectionCheck(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void run(String... args) throws Exception {

        try( Connection connection = dataSource.getConnection()){
            System.out.println("Connected to database: " + connection.getCatalog());
            System.out.println("Connected as user: " + connection.getMetaData().getUserName());
        }
    }
    
}
