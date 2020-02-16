package com.sep.NC.dto;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.sep.NC.model.enumeration.ScienceField;

import javax.persistence.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccountDTO {

    // private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String city;
    private String country;
    private String title;
    private String email;
    // private Boolean active;
    // private Boolean reviewer;
    // private Collection<ScienceField> scienceFieldList;
    // private Set<Authority> authorities = new HashSet<>();
    // private Magazine reviewingMagazines;
}
