package com.sa.tav.cinema.model.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "movies", schema = "dbo", catalog = "cinema")
public class MoviesEntity {
    private int idMovie;
    private String name;
    private String description;
    private String image;
    private transient List<FunctionsEntity> functionsByIdMovie;


    @OneToMany(mappedBy = "movie")
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<FunctionsEntity> getFunctionsByIdMovie(){
        return this.functionsByIdMovie;
    }
    public void setFunctionsByIdMovie(List<FunctionsEntity> functionsByIdMovie){
        this.functionsByIdMovie = functionsByIdMovie;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMovie", nullable = false)
    public int getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(int idMovie) {
        this.idMovie = idMovie;
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

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "image", nullable = true, length = 200)
    public String getImage(){
        return this.image;
    }

    public void setImage(String image){
        this.image = image;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoviesEntity that = (MoviesEntity) o;
        return idMovie == that.idMovie && Objects.equals(name, that.name) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMovie, name, description);
    }

}
