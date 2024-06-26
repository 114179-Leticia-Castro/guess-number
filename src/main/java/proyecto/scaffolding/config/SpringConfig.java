package proyecto.scaffolding.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.core.jackson.ModelResolver;
import io.swagger.v3.oas.models.info.Contact; // fijarse q sean models y no annotacion
import io.swagger.v3.oas.models.info.Info; // fijarse q sean models y no annotacion
import io.swagger.v3.oas.models.servers.Server; // fijarse q sean models y no annotacion
import io.swagger.v3.oas.models.Components; // fijarse q sean models y no annotacion
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Value("${app.url}")
    private String url;
    @Value("${app.dev-name}")
    private  String devName;
    @Value("${app.dev-email}")
    private String devEmail;

    /*
    Esta anotacion se utiliza para indicar que un metodo en una clase de
    configuracion de Spring debe ser tratado como un bean y gestionado por el contenedor de Spring.
    */
    @Bean
    public OpenAPI openApi(
        /*
            Esta anotacion se utiliza para inyectar valores de propiedades en los
            campos de una clase. Permite que las propiedades definidas en un archivo
            de configuracion(como aplication.properties) sean inyectadas en las variables correspondientes.

        */
            @Value("@project.name@") String appName,
            @Value("@project.description@") String appDescription,
            @Value("@project.version@") String appVersion ){

        Info info = new Info()
                .title(appName)
                .version(appVersion)
                .description(appDescription)
                .contact(
                        new Contact()
                                .name(devName)
                                .email(devEmail));

        Server server = new Server()
                .url(url)
                .description(appDescription);
        return new OpenAPI()
                .components(new Components())
                .info(info)
                .addServersItem(server);


    }

    @Bean
    public ModelResolver modelResolver(ObjectMapper objectMapper){
        return new ModelResolver(objectMapper);
    }


}
