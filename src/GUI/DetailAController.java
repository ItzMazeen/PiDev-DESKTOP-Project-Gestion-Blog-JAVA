/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Article;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.CRUDArticle;

/**
 * FXML Controller class
 *
 * @author mazee
 */
public class DetailAController implements Initializable {

    @FXML
    private VBox vbox;
    @FXML
    private ScrollPane scrollpanel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       CRUDArticle art = new CRUDArticle();
       int maxChars = 70;
       List<Article> articles = art.afficherArticle();
       StringBuilder sb = new StringBuilder();
       
       
       for (Article article : articles) {
    String contenu = article.getContenu();
    if (contenu.length() > maxChars) {
        contenu = contenu.substring(0, maxChars) + "...";
    }

    Label articleDetails = new Label();
    articleDetails.setText("Auteur : " + article.getId_Auteur() + "\n" +
                            "Views : " + article.getViews() + "\n" +
                            "Date : " + article.getCreated_at() + "\n" +
                            "Sujet Article : " + article.getSujet() + "\n" +
                            "Contenu : " + contenu + "\n\n");

    Button readMoreButton = new Button("Read More article " + article.getId());
    readMoreButton.setOnAction(event -> {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ArticleByID.fxml"));
        Parent root = loader.load();
        ArticleByIDController controller = loader.getController();
        controller.setArticleId(article.getId()); // Set the article ID in the new controller
        controller.initialize(null, null); // Call the initialize() method manually
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("Article By ID");
        stage.setScene(scene);
        stage.show();
    } catch (IOException ex) {
        Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
    }
});


    HBox articleBox = new HBox(articleDetails, readMoreButton);
    articleBox.setAlignment(Pos.CENTER_RIGHT);
    VBox.setMargin(articleBox, new Insets(0, 0, 10, 0)); // Add margin to separate articles
    vbox.getChildren().addAll(articleBox, new Separator());



        




    }
       
    }    
    
}
