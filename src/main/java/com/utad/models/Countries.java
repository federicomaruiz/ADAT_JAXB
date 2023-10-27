package com.utad.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "countries")
public class Countries {

    private List<Country> countryList =  new ArrayList<>(); // Creo una lista que va tener los paises

    public List<Country> getCountryList() {
        return countryList;
    }

    @XmlElement(name = "country")
    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }
}
