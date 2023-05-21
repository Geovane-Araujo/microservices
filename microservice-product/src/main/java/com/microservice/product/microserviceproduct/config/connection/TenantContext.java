package com.microservice.product.microserviceproduct.config.connection;

public class TenantContext {

    private static ThreadLocal<String> currentTenant = new ThreadLocal<>();
}
