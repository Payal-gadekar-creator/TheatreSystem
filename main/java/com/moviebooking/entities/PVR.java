package com.moviebooking.entities;

import java.util.Objects;

import javax.persistence.Entity;

import org.hibernate.Hibernate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class PVR extends Cinema {

    private String hallNumber;
    private String seatNumber;
    private Float price;
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private String showDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PVR pvr = (PVR) o;
        return getCinemaId() != null && Objects.equals(getCinemaId(), pvr.getCinemaId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
