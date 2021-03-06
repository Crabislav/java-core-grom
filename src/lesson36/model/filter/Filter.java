package lesson36.model.filter;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Filter {
    private Integer numberOfGuests;
    private Double price;
    private Boolean breakfastIncluded;
    private Boolean petsAllowed;
    private Date dateAvailableFrom;

    private String name;
    private String country;
    private String city;
    private String street;

    Filter(Integer numberOfGuests, Double price, Boolean breakfastIncluded, Boolean petsAllowed, Date dateAvailableFrom, String name, String country, String city, String street) {
        this.numberOfGuests = numberOfGuests;
        this.price = price;
        this.breakfastIncluded = breakfastIncluded;
        this.petsAllowed = petsAllowed;
        this.dateAvailableFrom = dateAvailableFrom;
        this.name = name;
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public Integer getNumberOfGuests() {
        return numberOfGuests;
    }

    public Double getPrice() {
        return price;
    }

    public Boolean getBreakfastIncluded() {
        return breakfastIncluded;
    }

    public Boolean getPetsAllowed() {
        return petsAllowed;
    }

    public Date getDateAvailableFrom() {
        return dateAvailableFrom;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public List<Object> getFields() {
        return Arrays.asList(getBreakfastIncluded(), getName(), getCountry(), getCity(), getStreet(), getNumberOfGuests(),
                getPrice(), getBreakfastIncluded(), getDateAvailableFrom(), getPetsAllowed());
    }

    @Override
    public String toString() {
        return "numberOfGuests=" + numberOfGuests +
                ", price=" + price +
                ", breakfastIncluded=" + breakfastIncluded +
                ", petsAllowed=" + petsAllowed +
                ", dateAvailableFrom=" + dateAvailableFrom +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'';
    }
}
