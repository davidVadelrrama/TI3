package model;

public class Organization {
    private String nit;
    private String name;


    public Organization(String nit, String name, String type) {
        this.nit = nit;
        this.name = name;

    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
