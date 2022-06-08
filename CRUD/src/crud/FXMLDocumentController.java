/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableRow;

/**
 *
 * @author admin
 */
public class FXMLDocumentController implements Initializable {
    
     @FXML
    private TableView<Cake> table;
    
    @FXML
    private TableColumn<Cake, String> IDColumn;

    @FXML
    private TableColumn<Cake, String> ImageColumn;

    @FXML
    private TableColumn<Cake, String> NameColumn;

    @FXML
    private TableColumn<Cake, String> PriceColumn;

    @FXML
    private TableColumn<Cake, String> TypeColumn;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private Label label;

    @FXML
    private TextField txtImages;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtType;
    
    
    
    
// ADD DATA
    @FXML
    void Add(ActionEvent event) {
        String image,name, price,type;
        image = txtImages.getText();
        name = txtName.getText();
        price = txtPrice.getText();
        type = txtType.getText();
       
        try 
        {
            pst = con.prepareStatement("insert into products(image,name,price,type)values(?,?,?)");
            pst.setString(1, image);
            pst.setString(2, name);
            pst.setString(3, price);
            pst.setString(3, type);
            pst.executeUpdate();
          
            	Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Student Registation");

		
		alert.setHeaderText("Student Registation");
		alert.setContentText("Record Addedddd!");

		alert.showAndWait();

            table();
            
            txtImages.setText("");
            txtName.setText("");
            txtPrice.setText("");
            txtType.setText("");
            txtName.requestFocus();
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void table()
      {
          Connect();
          ObservableList<Cake> cakes = FXCollections.observableArrayList();
       try 
       {
           pst = con.prepareStatement("select id,image,name,price,type from products");  
           ResultSet rs = pst.executeQuery();
      {
        while (rs.next())
        {
            Cake st = new Cake();
            st.setId(rs.getString("id"));
            st.setImages(rs.getString("image"));
            st.setName(rs.getString("name"));
            st.setPrice(rs.getString("price"));
            st.setType(rs.getString("type"));
            cakes.add(st);
       }
    } 
                table.setItems(cakes);
                IDColumn.setCellValueFactory(f -> f.getValue().idProperty());
                ImageColumn.setCellValueFactory(f -> f.getValue().imagesProperty());
                NameColumn.setCellValueFactory(f -> f.getValue().nameProperty());
                PriceColumn.setCellValueFactory(f -> f.getValue().priceProperty());
                TypeColumn.setCellValueFactory(f -> f.getValue().typeProperty());
                
               

       }
       
       catch (SQLException ex) 
       {
           Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
       }

                table.setRowFactory( tv -> {
		     TableRow<Cake> myRow = new TableRow<>();
		     myRow.setOnMouseClicked (event -> 
		     {
		        if (event.getClickCount() == 1 && (!myRow.isEmpty()))
		        {
		            myIndex =  table.getSelectionModel().getSelectedIndex();
		 
		           id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
                           txtImages.setText(table.getItems().get(myIndex).getImages());
		           txtName.setText(table.getItems().get(myIndex).getName());
		           txtPrice.setText(table.getItems().get(myIndex).getPrice());
                           txtType.setText(table.getItems().get(myIndex).getType());
                           
                         
                           
		        }
		     });
		        return myRow;
                   });
    
    
      }
// END ADD DATA
  
    
    

    @FXML
    void Delete(ActionEvent event) {

    }

    @FXML
    void Update(ActionEvent event) {

    }
    
    
    
//    CONECT Database
    Connection con;
    PreparedStatement pst;
    int myIndex;
    int id;
    
    
    
     public void Connect()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/javafxcakes","root","");
        } catch (ClassNotFoundException ex) {
          
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
// END //    CONECT Database
    
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Connect();
        table();
    }    
    
}














