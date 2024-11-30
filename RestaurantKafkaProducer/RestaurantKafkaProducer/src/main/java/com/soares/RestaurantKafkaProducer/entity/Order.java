package com.soares.RestaurantKafkaProducer.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "tb_orders")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String client;
    @Column(unique = true)
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

    public boolean isIntegrated() {
        return integrated;
    }

    public void setIntegrated(boolean integrated) {
        this.integrated = integrated;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
