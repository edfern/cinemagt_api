package com.sa.tav.cinema.model.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "sales", schema = "dbo", catalog = "cinema")
public class SalesEntity {
    private int idSale;
    private String customerName;
    private BigDecimal total;
    private Date date;
    private List<SalesDetailEntity> details;

    @Id
    @Column(name = "idSale", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdSale() {
        return idSale;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }

    @Basic
    @Column(name = "customerName", nullable = true, length = 50)
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String nameCustomer) {
        this.customerName = nameCustomer;
    }

    @Basic
    @Column(name = "total", nullable = true, precision = 2)
    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Basic
    @Column(name = "date", nullable = true)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesEntity that = (SalesEntity) o;
        return idSale == that.idSale && Objects.equals(customerName, that.customerName) && Objects.equals(total, that.total) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSale, customerName, total, date);
    }


    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "salesByIdSale")
    public List<SalesDetailEntity> getDetails() {
        return details;
    }

    public void setDetails(List<SalesDetailEntity> salesDetailsByIdSale) {
        this.details = salesDetailsByIdSale;
    }
}
