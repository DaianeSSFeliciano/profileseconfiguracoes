package dioexample.spring.config;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource") // mapea o grupo de propiedades
@Getter //  todas as propiedades irao receber automaticamente os getter e setters
@Setter
public class DbConfiguration {

    private String driverClassName;
    private String url;
    private String usermae;
    private String password;

    // metodo para mapear as propiedades

    @Profile("dev")
    @Bean     /*mostra conteudo mapeado logo na subida do sistema*/
    public String testDatabaseConnection() {
        System.out.println("DB connection for DEV - H2");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB Connection to MySql production - Test instance";

    }


    @Profile("prod")
    @Bean
    public String prodDatabaseConnection(){
        System.out.println("DB connection for MYSQL Database: production");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB Connection to MySql production - Test instance";

    }
}
