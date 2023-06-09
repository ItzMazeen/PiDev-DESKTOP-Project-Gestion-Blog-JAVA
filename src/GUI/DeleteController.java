/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Article;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import services.CRUDArticle;

/**
 * FXML Controller class
 *
 * @author mazee
 */
public class DeleteController implements Initializable {

    @FXML
    private Button fxdelete;
    @FXML
private ChoiceBox<String> idChoiceBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CRUDArticle art = new CRUDArticle();
       List<Article> articles = art.afficherArticle();
       for (Article article : articles) {
        idChoiceBox.getItems().add(article.getSujet());
       }
    }    

    @FXML
    private void save(ActionEvent event) {
                CRUDArticle art = new CRUDArticle();
       List<Article> articles = art.afficherArticle();
    String selectedContent = idChoiceBox.getValue();
    Article selectedArticle = null;
    for (Article article : articles) {
        if (article.getContenu().equals(selectedContent)) {
            selectedArticle = article;
            break;
        }
    }
    if (selectedArticle != null) {
        int id = selectedArticle.getId();
        art.supprimerArticle(new Article(id));
    }


                

        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Confirmation Dialog");

        alert.setHeaderText(null);

        alert.setContentText("Article supprimée avec succés !");

        alert.show();
        

    }

  
    
}
