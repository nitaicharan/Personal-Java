package personalspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestPersonalSpringApplication {

	public static void main(String[] args) {
		SpringApplication.from(PersonalSpringApplication::main).with(TestPersonalSpringApplication.class).run(args);
	}

}
