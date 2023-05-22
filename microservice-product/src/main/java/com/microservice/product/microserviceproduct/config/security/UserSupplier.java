package com.microservice.product.microserviceproduct.config.security;

import com.microservice.product.microserviceproduct.config.exceptions.ServiceException;
import io.jsonwebtoken.Claims;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import javax.sql.rowset.serial.SerialException;

@Data
@Builder
public class UserSupplier {

    private Integer id;
    private String name;
    private String email;

    public static UserSupplier getUser(Claims jwtUser){
        try{
            return UserSupplier.builder()
                    .id((Integer) jwtUser.get("id"))
                    .name((String) jwtUser.get("name"))
                    .email((String) jwtUser.get("email"))
                    .build();
        } catch (Exception ex){
            ex.printStackTrace();
            throw new ServiceException(HttpStatus.FORBIDDEN,"Access not authorized");
        }
    }
}
