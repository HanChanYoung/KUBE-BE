package kube.kubecamp.config;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.salt.StringFixedSaltGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JasyptConfig {

    @Bean(name = "jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword("somePassword");
        encryptor.setAlgorithm("PBEWithMD5AndDES");
        encryptor.setSaltGenerator(new StringFixedSaltGenerator("someFixedSalt"));
        String url = "jdbc:mysql://210.109.62.14:3306/camp";
        String user = "kube";
        String passwd = "kube2023";

        String encUrl = encryptor.encrypt(url);
        String decUrl = encryptor.decrypt(encUrl);

        String encUser = encryptor.encrypt(user);
        String decUser = encryptor.decrypt(encUser);

        String encPasswd = encryptor.encrypt(passwd);
        String decPasswd = encryptor.decrypt(encPasswd);

        System.out.println("decUrl : " + decUrl + "\nencUrl : "+ encUrl + "\n\n");
        System.out.println("decUser : " + decUser + "\nencUser : "+ encUser + "\n\n");
        System.out.println("decPasswd : " + decPasswd + "\nencPasswd : "+ encPasswd + "\n\n");

        return encryptor;
    }
}
