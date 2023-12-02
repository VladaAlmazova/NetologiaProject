package ru.netology.vlada.domain;

import ru.netology.vlada.Main;

public class Customer {

    private int id;
    private String name;

    public Customer(int id, String name)
    {
        this.id = id;
        this.name = name;

    }

    public Customer()
    {
        this.id = 0;
        this.name = "";
    }

    @Override
    public String toString(){
        return "Customer {"+
                "id= " + id +
                ", name= " + name + "};";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Customer customer = (Customer) obj;
        return id == customer.id;//  && name.equals(customer.name);
    }

    @Override
    public int hashCode() {
        return id*123;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
