package com.soares.RestaurantKafkaConsumer.entity;


public class Order {
    private Long id;
    private String client;
    private String cpf;
    private String product;
    private double value;
    private boolean integrated;

    public Order() {
    }

    public Order(Long id, String client, String cpf, String product, double value, boolean integrated) {
        this.id = id;
        this.client = client;
        this.cpf = cpf;
        this.product = product;
        this.value = value;
        this.integrated = integrated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isIntegrated() {
        return integrated;
    }

    public void setIntegrated(boolean integrated) {
        this.integrated = integrated;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
