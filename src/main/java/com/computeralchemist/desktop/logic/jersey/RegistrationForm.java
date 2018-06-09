package com.computeralchemist.desktop.logic.jersey;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;

/**
 * @Author
 * Karol Meksuła
 * 09-06-2018
 * */

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class RegistrationForm {
    private String username;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String bornyear;
    private Address address;

    private RegistrationForm(final FormBuilder formBuilder) {
        this.username = formBuilder.username;
        this.name = formBuilder.name;
        this.surname = formBuilder.surname;
        this.email = formBuilder.email;
        this.password = formBuilder.password;
        this.bornyear = formBuilder.bornyear;
        this.address = formBuilder.address;
    }

    public static class FormBuilder {
        private String username;
        private String name;
        private String surname;
        private String email;
        private String password;
        private String bornyear;
        private Address address;

        public FormBuilder username(final String username) {
            this.username = username;
            return this;
        }

        public FormBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public FormBuilder surname(final String surname) {
            this.surname = surname;
            return this;
        }

        public FormBuilder email(final String email) {
            this.email = email;
            return this;
        }

        public FormBuilder password(final String password) {
            this.password = password;
            return this;
        }

        public FormBuilder bornyear(final String bornyear) {
            this.bornyear = bornyear;
            return this;
        }

        public FormBuilder address(final Address address) {
            this.address = address;
            return this;
        }

        public RegistrationForm build() {
            return new RegistrationForm(this);
        }

    }

}

class Address {

}
