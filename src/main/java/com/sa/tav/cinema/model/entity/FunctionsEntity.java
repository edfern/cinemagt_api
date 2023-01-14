package com.sa.tav.cinema.model.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Functions", schema = "dbo", catalog = "cinema")
public class FunctionsEntity {
    private int idFunction;
    private Timestamp time;
    private Date startDate;
    private Date endDate;
    private String state;
    private BigDecimal ticketPrice;

    private RoomsEntity room;
    private MoviesEntity movie;

    private transient List<TicketsEntity> tickets;


    @Id
    @Column(name = "idFunction", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdFunction() {
        return idFunction;
    }

    public void setIdFunction(int idFunction) {
        this.idFunction = idFunction;
    }

    @Basic
    @Column(name = "time", nullable = true)
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Basic
    @Column(name = "startDate", nullable = true)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "endDate", nullable = true)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "state", nullable = true, length = 50)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "ticketPrice", nullable = false)
    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal price) {
        this.ticketPrice = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FunctionsEntity that = (FunctionsEntity) o;
        return idFunction == that.idFunction && Objects.equals(time, that.time) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate) && Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFunction, time, startDate, endDate, state);
    }

    @ManyToOne
    @JoinColumn(name = "idRoom", referencedColumnName = "idRoom" ,nullable = false)
    public RoomsEntity getRoom() {
        return room;
    }

    public void setRoom(RoomsEntity roomsByIdRoom) {
        this.room = roomsByIdRoom;
    }

    @ManyToOne
    @JoinColumn(name = "idMovie", referencedColumnName = "idMovie",nullable = false)
    public MoviesEntity getMovie() {
        return movie;
    }

    public void setMovie(MoviesEntity moviesByIdMovie) {
        this.movie = moviesByIdMovie;
    }

    @OneToMany(mappedBy = "function")
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<TicketsEntity> getTickets(){
        return this.tickets;
    }

    public void setTickets(List<TicketsEntity> tickets){
        this.tickets = tickets;
    }

}
