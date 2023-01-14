package com.sa.tav.cinema.model.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "rooms", schema = "dbo", catalog = "cinema")
public class RoomsEntity extends AbstractEntity {

    private int idRoom;
    private String name;
    private String description;
    private Integer size;
    //private FunctionsEntity functionsByIdFunctions;

    @Id
    @Column(name = "idRoom", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 50)
    public String getDescription() {
        return description;
    }

    public void setDescription (String descripcion) {
        this.description = descripcion;
    }

    @Basic
    @Column(name = "size", nullable = true)
    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomsEntity that = (RoomsEntity) o;
        return idRoom == that.idRoom && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(size, that.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRoom, name, description, size);
    }

    /*
    @OneToOne
    @JoinColumn(name = "idRoom", referencedColumnName = "idRoom")
    public FunctionsEntity getFunctionsByIdFunctions(){
        return this.functionsByIdFunctions;
    }

    public void setFunctionsByIdFunctions(FunctionsEntity entity){
        this.functionsByIdFunctions = entity;
    }

     */

}
