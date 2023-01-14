package com.sa.tav.cinema.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "salesdetail", schema = "dbo", catalog = "cinema")
public class SalesDetailEntity {
    private int idSaleDetail;
    private String description;
    private TicketsEntity ticket;

    private int idSale;
    private transient SalesEntity salesByIdSale;

    @Id
    @Column(name = "idSaleDetail", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdSaledetail() {
        return idSaleDetail;
    }

    public void setIdSaledetail(int idSaleDetail) {
        this.idSaleDetail = idSaleDetail;
    }

    @Basic
    @Column(name = "idSale")
    public int getIdSale(){
        return this.idSale;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 50)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesDetailEntity that = (SalesDetailEntity) o;
        return idSaleDetail == that.idSaleDetail && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSaleDetail, description);
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "idTicket", referencedColumnName = "idTicket", nullable = false)
    public TicketsEntity getTicket(){
        return this.ticket;
    }

    public void setTicket(TicketsEntity ticket) {
        this.ticket = ticket;
    }

    @ManyToOne
    @JoinColumn(name = "idSale", referencedColumnName = "idSale", updatable = false, insertable = false)
    public SalesEntity getSalesByIdSale() {
        return salesByIdSale;
    }

    public void setSalesByIdSale(SalesEntity salesByIdSale) {
        this.salesByIdSale = salesByIdSale;
    }
}
