package main.model;

public class Place {

    public String icon;
    public String name;
    public String formatted_address;
    public String formatted_phone_number;
    public String reference;

//    public Place(String name, String formatted_address) {
//        this.name = name;
//        this.formatted_address = formatted_address;
//    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Place place = (Place) o;
        return (name.equals(place.name)
                && formatted_address.equals(place.formatted_address));
    }



}
