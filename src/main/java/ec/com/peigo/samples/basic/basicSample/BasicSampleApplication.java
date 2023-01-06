package ec.com.peigo.samples.basic.basicSample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"ec.com.peigo.samples.basic.basicSample.application", "ec.com.peigo.samples.basic.basicSample.domain", "ec.com.peigo.samples.basic.basicSample.infrastructure"})
public class BasicSampleApplication {

	public static void main(String[] args) {
			SpringApplication.run(BasicSampleApplication.class, args);
	}

}
