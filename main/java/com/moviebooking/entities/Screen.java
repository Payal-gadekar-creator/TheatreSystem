package com.moviebooking.entities;


import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.Hibernate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Builder
public class Screen implements Comparable<Screen> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer screenId;
    private String type;

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private Cinema cinemaDto;

    @OneToOne(mappedBy = "screenDto", orphanRemoval = true)
    private Movie movie;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Screen screen = (Screen) o;
        return screenId != null && Objects.equals(screenId, screen.screenId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public int compareTo(Screen otherScreen) {
        return (this.getScreenId() - otherScreen.getScreenId());
    }
}
