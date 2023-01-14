package com.sa.tav.cinema.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "tickets", schema = "dbo", catalog = "cinema")
public class TicketsEntity {
    private int idTicket;
    private Date date;
    private String description;
    private BigDecimal price;
    private String seat;
    private FunctionsEntity function;

    @Id
    @Column(name = "idTicket", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    @Basic
    @Column(name = "date", nullable = true)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
    @Column(name = "price", nullable = true, precision = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "seat", nullable = true, length = 50)
    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketsEntity that = (TicketsEntity) o;
        return idTicket == that.idTicket && Objects.equals(date, that.date) && Objects.equals(description, that.description) && Objects.equals(price, that.price) && Objects.equals(seat, that.seat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTicket, date, description, price, seat);
    }

    @ManyToOne
    @JoinColumn(name ="idFunction", referencedColumnName = "idFunction", nullable = false)
    public FunctionsEntity getFunction(){
        return this.function;
    }

    public void setFunction(FunctionsEntity functionsEntity){
        this.function = functionsEntity;
    }
}
