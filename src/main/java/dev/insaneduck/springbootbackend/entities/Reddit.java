package dev.insaneduck.springbootbackend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reddit",schema = "data")
public class Reddit {

    @Id
    private String id;



    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
