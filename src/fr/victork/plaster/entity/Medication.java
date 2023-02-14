package victork.plaster.entity;

import java.time.LocalDate;

public class Medication {
    //--------------------- CONSTANTS ------------------------------------------
    //--------------------- STATIC VARIABLES -----------------------------------
    //--------------------- INSTANCE VARIABLES ---------------------------------
    private int idMedication;
    private String name;
    private int price;
    private LocalDate commissioningDate;
    private int inventoryQuantity;
    private Category category;

    //--------------------- CONSTRUCTORS ---------------------------------------

    public Medication(int idMedication, String name, int price, LocalDate commissioningDate, int inventoryQuantity,
      Category category) {
        this.setIdMedication(idMedication);
        this.setName(name);
        this.setPrice(price);
        this.setCommissioningDate(commissioningDate);
        this.setInventoryQuantity(inventoryQuantity);
        this.setCategory(category);
    }

    //--------------------- STATIC METHODS -------------------------------------
    //--------------------- INSTANCE METHODS -----------------------------------
    //--------------------- ABSTRACT METHODS -----------------------------------
    //--------------------- STATIC - GETTERS - SETTERS -------------------------
    //--------------------- GETTERS - SETTERS ----------------------------------

    public int getIdMedication() {
        return idMedication;
    }

    public void setIdMedication(int idMedication) {
        this.idMedication = idMedication;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getCommissioningDate() {
        return commissioningDate;
    }

    public void setCommissioningDate(LocalDate commissioningDate) {
        this.commissioningDate = commissioningDate;
    }

    public int getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(int inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    //--------------------- TO STRING METHOD------------------------------------
}
