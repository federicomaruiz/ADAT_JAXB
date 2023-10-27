package com.utad;

import com.utad.models.Countries;
import com.utad.models.Country;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Main {

    private static String path = "./src/main/resources/countries.xml";// Accedo a la path del archivo xml a leer

    public static void main(String[] args) {
        readXML();
    }
    private static void readXML() {
        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(Countries.class); // Le paso el objeto de la clase countries
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller(); // Deserializar convertir lo que nos llega en un objeto
            Countries countries = (Countries) unmarshaller.unmarshal(new File(path)); // Accedo al objeto

            for (Country c : countries.getCountryList()) {
                System.out.println("-------------------");
                System.out.println("Pais: " + c.getName());
                System.out.println("Capital: " + c.getCapital());
                System.out.println("Poblacion: " + c.getPopulation());

            }

            addNewCountry(countries);

        } catch (JAXBException e) {
            System.out.println("error");
            System.err.println(e.getMessage());
        }
    }

    private static void addNewCountry(Countries countries) throws JAXBException {
        Country country = new Country();  // Creo un objeto country con sus atributos
        country.setName("Portugal");
        country.setCapital("Lisboa");
        country.setPopulation("9029130");

        countries.getCountryList().add(country); // Lo añado a la lista de countries

        JAXBContext jaxbContext = JAXBContext.newInstance(Countries.class); // añado al fichero xml lo escribo
        Marshaller marshaller = jaxbContext.createMarshaller(); // lo convierto a string lo serializo
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // para que lo añada en varias lineas PROLIJO
        marshaller.marshal(countries, new File(path)); // lo meto dentro del fichero

    }

}