package com.moviebooking.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.Hibernate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Cinema implements Comparable<Cinema> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cinemaId;
    private String name;
    private String location;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userDto;

    @OneToMany(mappedBy = "cinemaDto", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Screen> screens = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Cinema cinema = (Cinema) o;
        return cinemaId != null && Objects.equals(cinemaId, cinema.cinemaId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public int compareTo(Cinema otherCinema) {
        return (this.getCinemaId() - otherCinema.getCinemaId());
    }
}
