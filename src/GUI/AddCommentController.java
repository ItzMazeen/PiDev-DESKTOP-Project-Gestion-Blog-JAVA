/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Article;
import entities.Commentaire;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import services.CRUDArticle;
import services.CRUDCommentaire;

/**
 * FXML Controller class
 *
 * @author mazee
 */
public class AddCommentController implements Initializable {


    @FXML
    private TextField fxuser;
    @FXML
    private TextArea fxcontenu;
    @FXML
    private Button fxajouter;
    
    private int articleId; // New private variable

    public void setArticleId(int id) {
        this.articleId = id;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void save(ActionEvent event) {
        

        int user = Integer.parseInt(fxuser.getText());
        String contenu = fxcontenu.getText();
        
        Commentaire c = new Commentaire(articleId,user,contenu);
        
        CRUDCommentaire cmnt = new CRUDCommentaire();
        
        cmnt.ajouterCommentaire(c);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Confirmation Dialog");

        alert.setHeaderText(null);

        alert.setContentText("Commentaire insérée avec succés !");

        alert.show();

    }
    
}
