package fr.maif.devquest.hero_management.hero_manamgement;

import java.io.IOException;

import fr.maif.devquest.hero_management.hero_manamgement.datastore.GameDatastore;
import fr.maif.devquest.hero_management.hero_manamgement.datastore.GroupeDatastore;
import fr.maif.devquest.hero_management.hero_manamgement.datastore.HeroDatastore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class Config implements WebMvcConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(Config.class);

    public Config(
            @Value("${nobackend}") Boolean isOff) {
        if(isOff) {
            logger.info("Application was started without backend, to re-activate backend restart it with \"nobackend\" parameter at false");
        } else {
            logger.info("Backend is up and running !");
        }
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        // By setting this, you instruct Spring to prioritize this handler above the
        // default one (which is order 0), obviously don't do this. But it's good to
        // understand.
        // -- registry.setOrder(-1);

        registry
                // Capture everything (REST controllers get priority over this, see above)
                .addResourceHandler("/**")
                // Add locations where files might be found
                .addResourceLocations("classpath:/static/")
                // Needed to allow use of `addResolver` below
                .resourceChain(true)
                // This thing is what does all the resolving. This impl. is responsible for
                // resolving ALL files. Meaning nothing gets resolves automatically by pointing
                // out "static" above.
                .addResolver(new PathResourceResolver() {
                    @Override
                    protected Resource getResource(String resourcePath, Resource location) throws IOException {
                        Resource requestedResource = location.createRelative(resourcePath);

                        // If we actually hit a file, serve that. This is stuff like .js and .css files.
                        if (requestedResource.exists() && requestedResource.isReadable()) {
                            return requestedResource;
                        }

                        // Anything else returns the index.
                        return new ClassPathResource("/static/index.html");
                    }
                });

    }
}