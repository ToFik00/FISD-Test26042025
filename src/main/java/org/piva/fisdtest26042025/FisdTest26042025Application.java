package org.piva.fisdtest26042025;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "org.piva.fisdtest26042025.client")
public class FisdTest26042025Application {

    public static void main(String[] args) {
        SpringApplication.run(FisdTest26042025Application.class, args);
    }

}
