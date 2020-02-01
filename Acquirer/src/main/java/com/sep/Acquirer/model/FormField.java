package com.sep.Acquirer.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class FormField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "type", unique = false, nullable = false)
    private String type;

    @Column(name = "optional", unique = false, nullable = false)
    private boolean optional;

    public FormField() {
    }

    public FormField(String id, String name, String type, boolean optional) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.optional = optional;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isOptional() {
        return this.optional;
    }

    public boolean getOptional() {
        return this.optional;
    }

    public void setOptional(boolean optional) {
        this.optional = optional;
    }

    public FormField id(String id) {
        this.id = id;
        return this;
    }

    public FormField name(String name) {
        this.name = name;
        return this;
    }

    public FormField type(String type) {
        this.type = type;
        return this;
    }

    public FormField optional(boolean optional) {
        this.optional = optional;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof FormField)) {
            return false;
        }
        FormField formField = (FormField) o;
        return Objects.equals(id, formField.id) && Objects.equals(name, formField.name)
                && Objects.equals(type, formField.type) && optional == formField.optional;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, optional);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", type='" + getType() + "'"
                + ", optional='" + isOptional() + "'" + "}";
    }

}