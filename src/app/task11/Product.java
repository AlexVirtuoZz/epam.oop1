package app.task11;

import java.util.GregorianCalendar;

/**
 * Created by alexander on 17.05.16.
 */
public class Product {
    //Product's values
    private String name;
    private String manufacturer;
    private int quantity;
    private GregorianCalendar dateOfManufacture;
    private GregorianCalendar dateOfExpiration;
    private String provider;
    private int providerPhoneNumber;
    private int manufacturerPhoneNumber;
    private int value;

    //Getters and setters for all parameters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public GregorianCalendar getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(GregorianCalendar dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public GregorianCalendar getDateOfExpiration() {
        return dateOfExpiration;
    }

    public void setDateOfExpiration(int year, int month, int day) {
        dateOfExpiration.set(year,month,day);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getManufacturerPhoneNumber() {
        return manufacturerPhoneNumber;
    }

    public void setManufacturerPhoneNumber(int manufacturerPhoneNumber) {
        this.manufacturerPhoneNumber = manufacturerPhoneNumber;
    }

    public int getProviderPhoneNumber() {
        return providerPhoneNumber;
    }

    public void setProviderPhoneNumber(int providerPhoneNumber) {
        this.providerPhoneNumber = providerPhoneNumber;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //Constructor, including main parameters
    public Product(String name, int quantity, int value){
        this.name = name;
        this.quantity = quantity;
        this.value = value;
    }

    //Constructor without parameters: set all main parameters to unknown
    public Product(){
        this.name = "unknown";
        this.quantity = -1;
        this.value = -1;
    }

    //Initialization block: set parameters to unknown
    {
        this.manufacturer = "unknown";
        this.provider = "unknown";
        dateOfExpiration = new GregorianCalendar(0000, 00, 00);
        dateOfManufacture = new GregorianCalendar(0000, 00, 00);
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Product ").append(name).append("\n")
                .append("Value ").append(value).append("\n")
                .append("Available quantity ").append(quantity).append("\n")
                .append("Provider ").append(provider).append("\n")
                .append("Provider number ").append(providerPhoneNumber).append("\n")
                .append("Manufacturer ").append(manufacturer).append("\n")
                .append("Manufacturer number ").append(manufacturerPhoneNumber).append("\n")
                .append("Date of manufacture ").append(dateOfManufacture.getTime()).append("\n")
                .append("Date of Expiration ").append(dateOfExpiration.getTime()).toString();
    }

    @Override
    public int hashCode(){
        return 31 * quantity + value + ((name == "unknown") ? 0 : name.hashCode())
                + ((provider == "unknown") ? 0 : provider.hashCode())
                + ((manufacturer == "unknown") ? 0 : manufacturer.hashCode());
    }

    @Override
    public boolean equals(Object object){
        if (object == this) return true;
        if (object == null) return false;
        if (object instanceof Product){
            Product temp = (Product) object;
            return temp.name.equals(this.name)
                    && temp.provider.equals(this.provider)
                    && temp.manufacturer.equals(this.manufacturer)
                    && temp.value == this.value
                    && temp.quantity == this.quantity
                    && temp.dateOfManufacture.equals(this.dateOfManufacture)
                    && temp.dateOfExpiration.equals(this.dateOfExpiration);
        }
        return false;
    }

    //A method to count value of the required amount of product
    public int sellValue(int n){
        if (n <= 0) return 0;
        return value * n;
    }

    //A method to tell user if a product can be sold now
    public boolean canBeSold(){
        if (dateOfExpiration == null) {
            System.out.println("Date of expiration is not set");
            return false;
        }
        return dateOfExpiration.getTime().before(new GregorianCalendar().getTime());
    }


}
