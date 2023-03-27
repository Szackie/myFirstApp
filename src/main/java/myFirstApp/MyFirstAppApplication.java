package myFirstApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class MyFirstAppApplication implements RepositoryRestConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(MyFirstAppApplication.class, args);
	}

	@Override // po to, żeby błąd wynikający z null description nie był opisywany jako błąd serwera, a błąd klienta
	public void configureValidatingRepositoryEventListener(final ValidatingRepositoryEventListener validatingListener) {

		validatingListener.addValidator("beforeCreate",validator());
		validatingListener.addValidator("berSave",validator());
		RepositoryRestConfigurer.super.configureValidatingRepositoryEventListener(validatingListener);
	}
@Bean
	Validator validator() {
		return new LocalValidatorFactoryBean();
	}

}
