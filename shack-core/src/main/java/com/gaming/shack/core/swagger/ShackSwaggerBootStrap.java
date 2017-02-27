/*
 * 
 */
package com.gaming.shack.core.swagger;

import javax.servlet.ServletContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.web.context.WebApplicationContext;

import com.gaming.shack.core.utils.PropertyLoader;
import com.gaming.shack.core.utils.SpringApplicationContext;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.models.Contact;
import io.swagger.models.Info;
import io.swagger.models.Swagger;
import io.swagger.models.Tag;


public class ShackSwaggerBootStrap extends ResourceConfig{
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager.getLogger(ShackSwaggerBootStrap.class);

	public ShackSwaggerBootStrap() {
		LOGGER.info("Called Swagger Boostrap Jersey Application...");

		register(io.swagger.jaxrs.listing.ApiListingResource.class);
	    register(io.swagger.jaxrs.listing.SwaggerSerializers.class);
	    BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        Info info = new Info()
			      .title("Shack Swagger Server")
			      .description("This is a Shack Resource server.  You can find all Rest APIs info here.")
			      .termsOfService("http://www.shack.com")
			      .contact(new Contact()
			        .email("andybajajus@gmail.com"));
        WebApplicationContext  appContext=(WebApplicationContext)SpringApplicationContext.getApplicationContext();
        PropertyLoader propertyLoader =(PropertyLoader)appContext.getBean("propertyLoader");
        
        beanConfig.setBasePath(appContext.getServletContext().getContextPath()+propertyLoader.getProperty("shack.resource.ext.path"));
        String rsourcePackage=propertyLoader.getProperty("shack.resource.package");
      
        beanConfig.setResourcePackage(rsourcePackage);
        beanConfig.setScan(true);
        ServletContext context = appContext.getServletContext();
        String tags=propertyLoader.getProperty("shack.resource.swagger.tags");
        Swagger swagger = new Swagger();
	    swagger.info(info);
        String[] tokens=tags.split(";");
        for(String token : tokens){
        	String[] subTokens=token.split(":");
        	swagger.tag(new Tag()
  			      .name(subTokens[0])
  			      .description(subTokens[1]));
        }
	    context.setAttribute("swagger", swagger);
	}

}
