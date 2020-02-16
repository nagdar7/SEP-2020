package com.sep.NC.model;

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
@Entity
@ToString
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String country;

    @Column
    private String title;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Boolean active;

    @Column(nullable = false)
    private Boolean reviewer;

    @ElementCollection(targetClass = ScienceField.class)
    @JoinTable(name = "account_science_fields", joinColumns = @JoinColumn(name = "account_id"))
    @Column(name = "science_fields", nullable = false)
    @Enumerated(EnumType.STRING)
    private Collection<ScienceField> scienceFieldList;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "account_authority", joinColumns = {
            @JoinColumn(name = "account_id", referencedColumnName = "account_id") }, inverseJoinColumns = {
                    @JoinColumn(name = "authority_name", referencedColumnName = "name") })
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @BatchSize(size = 20)
    private Set<Authority> authorities = new HashSet<>();

    // @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    // private ScientificCommittee scientificCommittee;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private Magazine reviewingMagazines;

    // @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    // @JoinTable(name = "reviewer_paper", joinColumns = @JoinColumn(name =
    // "account_id"), inverseJoinColumns = @JoinColumn(name = "paper_id"))
    // List<SciencePaper> sciencePapers;

}
