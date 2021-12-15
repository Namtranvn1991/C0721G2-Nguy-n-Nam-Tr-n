package com.example.demo.model;



import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class Theater implements Validator {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "theater_seq")
    @GenericGenerator(
            name = "theater_seq",
            strategy = "com.example.demo.model.IdGenerator",
            parameters = {
                    @Parameter(name = IdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = IdGenerator.VALUE_PREFIX_PARAMETER, value = "CI-"),
                    @Parameter(name = IdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d")})
    private String id;

    @NotNull
    @Pattern(regexp = "CI-\\d{4}",message = "Name wrong format, CI-XXXX")
    @Column(columnDefinition = "VARCHAR(45)",unique = true)
    private String showtimeId;

    @NotNull
    private String releaseDay;

    @NotNull
    @Min(0)
    private Integer quantity;

    @NotNull
    @ManyToOne(targetEntity = Movie.class)
    @JoinColumn(name = "movieId")
    private Movie movie;

    public Theater() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(String showtimeId) {
        this.showtimeId = showtimeId;
    }

    public String getReleaseDay() {
        return releaseDay;
    }

    public void setReleaseDay(String releaseDay) {
        this.releaseDay = releaseDay;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Theater theater = (Theater) target;
        try {
            LocalDate releaseDay = LocalDate.parse(theater.releaseDay);
            LocalDate today = LocalDate.now();
            if(Period.between(today,releaseDay).getDays()<1){
                errors.rejectValue("releaseDay","releaseDay");
            }
        } catch (Exception e){
            errors.rejectValue("releaseDay","releaseDay.empty");
        }

    }
}
