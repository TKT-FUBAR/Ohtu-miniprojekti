package fi.fubar.bibtex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws Exception {
        // Postgres DATABASE_URL: 
        //postgres://myxhqcqhrmknke:aaba9a491e66671c013575ece44221ff450e3b39de62c74a98300487864c5ac7@ec2-54-225-236-102.compute-1.amazonaws.com:5432/d6dfmrb6fjuq10

        SpringApplication.run(Main.class, args);
    }
}
