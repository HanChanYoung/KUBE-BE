package kube.kubecamp;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.salt.StringFixedSaltGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;


@EnableJpaAuditing
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) //종속성 순환 에러 제거
@EnableEncryptableProperties
public class KubeCampApplication {

	public static void main(String[] args) {

		SpringApplication.run(KubeCampApplication.class, args);

	}

}
