package kube.kubecamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class KubeCampApplication {

	public static void main(String[] args) {
		SpringApplication.run(KubeCampApplication.class, args);
	}

}
