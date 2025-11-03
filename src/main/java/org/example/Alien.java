package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.List;

@Entity
public class Alien {

    @Id
    private int aid;
    private String name;
    private String tech;
    @OneToMany(mappedBy = "alien")
    private List<Laptop> laptops;

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", name='" + name + '\'' +
                ", tech='" + tech + '\'' +
                ", laptops=" + laptops +
                '}';
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    public Laptop getLaptop(int index) {
        if (index < 0 || index >= laptops.size()) {
            return null;
        }
        return laptops.get(index);
    }

    public void setLaptop(Laptop laptop) {
        this.laptops.add(laptop);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }
}
