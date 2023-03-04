public class Address {
    private String streetNum;
    private String streetName;
    private String aptNum;
    private String city;
    private String state;
    private String zip;

    public Address(String stNum, String stName, String apt, String city, String state, String zip)
    {
        streetNum = stNum;
        streetName = stName;
        aptNum = apt;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public Address(Address address)
    {
        streetNum = address.getStreetNum();
        streetName = address.getStreetName();
        aptNum = address.getAptNum();
        city = address.getCity();
        state = address.getState();
        zip = address.getZip();
    }

    public Address(String address)
    {
        String temporary = address;
        streetNum = temporary.substring(0, temporary.indexOf(" "));
        temporary = temporary.substring(temporary.indexOf(" ") + 1);
        if(temporary.indexOf("Apt") != -1) {
            streetName = temporary.substring(0, temporary.indexOf("Apt")-1);
            temporary = temporary.substring(temporary.indexOf("Apt") + 4);
            aptNum = temporary.substring(0, temporary.indexOf(","));
            temporary = temporary.substring(temporary.indexOf(",") + 2);
        }
        else{
            streetName = temporary.substring(0, temporary.indexOf(","));
            temporary = temporary.substring(temporary.indexOf(",") + 2);
        }
        state = temporary.substring(0, temporary.indexOf(" "));
        temporary = temporary.substring(temporary.indexOf(" ") + 1);
        city = temporary.substring(0, temporary.indexOf(","));
        temporary = temporary.substring(temporary.indexOf(",") + 2);
        zip = temporary;
    }

    public String getStreetNum() {
        return streetNum;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getAptNum() {
        return aptNum;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public int getCountryCode() {
        int countryCode =  Integer.parseInt(zip.substring(0, 3));
        return countryCode;
    }

    public void setStreetNum(String streetNum) {
        this.streetNum = streetNum;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setAptNum(String aptNum) {
        this.aptNum = aptNum;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String toString()
    {
        if (aptNum != null){
            return streetNum + " " + streetName + " Apartment " + aptNum + ", " + city + ", " + state + " " + zip;
        }
        return streetNum + " " + streetName + ", " + city + ", " + state + " " + zip;
    }
}

