/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author admin
 */
public class Cake {
    private final StringProperty id;
    private final StringProperty name;
    private final StringProperty images;
    private final StringProperty  price;
    private final StringProperty  type;
     
    public Cake()
    {
        id = new SimpleStringProperty(this, "id");
        name = new SimpleStringProperty(this, "name");
        images = new SimpleStringProperty(this, "images");
        price = new SimpleStringProperty(this, "price");
        type = new SimpleStringProperty(this, "type");
    }

    public StringProperty idProperty() { return id; }
    public String getId() { return id.get(); }
    public void setId(String newId) { id.set(newId); }

    public StringProperty nameProperty() { return name; }
    public String getName() { return name.get(); }
    public void setName(String newName) { name.set(newName); }

    public StringProperty imagesProperty() { return images; }
    public String getImages() { return images.get(); }
    public void setImages(String newImages) { images.set(newImages); }
    
    public StringProperty priceProperty() { return price; }
    public String getPrice() { return price.get(); }
    public void setPrice(String newPrice) { price.set(newPrice); }
    
    public StringProperty typeProperty() { return type; }
    public String getType() { return type.get(); }
    public void setType(String newType) { type.set(newType); }
}
