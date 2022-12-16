/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.awt.Rectangle;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
//import javafx.scene.paint.Color;
//import javafx.scene.text.Font;


/**
 *
 * @author castagno
 */
public class FXMLDocumentController implements Initializable {
    /*
     * Variables globales correspondant à des objets définis dans la vue (fichier .fxml)
     * Ces variables sont ajoutées à la main et portent le même nom que les fx:id dans Scene Builder
     */
    @FXML
    private Label score; // value will be injected by the FXMLLoader
    @FXML
    private GridPane grille;
    @FXML
    private GridPane grille1;
        @FXML
    private GridPane grille2;
    @FXML
    private Pane fond; // panneau recouvrant toute la fenêtre
    @FXML
    private StackPane skin1;
    @FXML
    private StackPane skin2;
    @FXML
    private StackPane skin3;
    @FXML
    private StackPane skin4;
    @FXML
    private Button skin1_name;
    @FXML
    private Button skin2_name;
    @FXML
    private Button skin3_name;
    @FXML
    private Button skin4_name;
    @FXML
    private Button bouton1;
    @FXML
    private Button bouton2;
    @FXML
    private Pane moves;

    // variables globales non définies dans la vue (fichier .fxml)
    private final Pane p = new Pane(); // panneau utilisé pour dessiner une tuile "2"
    private final Label c = new Label("2");
    private int x = 24, y = 191;
    private int objectifx = 24, objectify = 191;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println("le contrôleur initialise la vue");
        // utilisation de styles pour la grille et la tuile (voir styles.css)
        p.getStyleClass().add("pane"); 
        c.getStyleClass().add("tuile");
        grille.getStyleClass().add("gridpane");
        grille1.getStyleClass().add("gridpane");
        grille2.getStyleClass().add("gridpane");
        GridPane.setHalignment(c, HPos.CENTER);
        fond.getChildren().add(p);
        p.getChildren().add(c);

        // on place la tuile en précisant les coordonnées (x,y) du coin supérieur gauche
        p.setLayoutX(x);
        p.setLayoutY(y);
        p.setVisible(true);
        c.setVisible(true);
    }

    /*
     * Méthodes listeners pour gérer les événements (portent les mêmes noms que
     * dans Scene Builder
     */
    @FXML
    private void handleDragAction(MouseEvent event) {
        System.out.println("Glisser/déposer sur la grille avec la souris");
        double x = event.getX();//translation en abscisse
        double y = event.getY();//translation en ordonnée
        if (x > y) {
            for (int i = 0; i < grille.getChildren().size(); i++) { //pour chaque colonne
                //for (int j = 0; j < grille.getRowConstraints().size(); j++) { //pour chaque ligne
                System.out.println("ok1");
                grille.getChildren().remove(i);

                /*Node tuile = grille.getChildren().get(i);
                 if (tuile != null) {
                 int rowIndex = GridPane.getRowIndex(tuile);
                 int rowEnd = GridPane.getRowIndex(tuile);
                 }*/
                // }
            }
        } else if (x < y) {
            System.out.println("ok2");
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    Pane p = new Pane();
                    p.getStyleClass().add("pane");
                    grille.add(p, i, j);
                    p.setVisible(true);
                    grille.getStyleClass().add("gridpane");
                }
            }
        }
    }

    //méthode permettant de choisir le premier "skin" (Sunset)
    @FXML
    private void choix_affichage1(MouseEvent event){
        grille.setVisible(true);
        grille1.setVisible(true);
        grille2.setVisible(true);
        
        p.setVisible(true);
        c.setVisible(true);
        skin1.setVisible(false);
        skin2.setVisible(false);
        skin3.setVisible(false);
        skin4.setVisible(false);
        /*fond.getStyleClass().add("skin1");*/
        fond.setStyle("-fx-background-color:#F9ED69;");
        grille.setStyle("-fx-background-color: #FFFFFF;");
        grille1.setStyle("-fx-background-color: #FFFFFF;");
        grille2.setStyle("-fx-background-color: #FFFFFF;");
          
        p.setStyle("-fx-background-color:#F08A5D;");
        c.setStyle("-fx-text-fill:#6A2C70;");
        bouton1.setStyle("-fx-background-color: #B83B5E; -fx-color:#FFFFFF;");
        bouton2.setStyle("-fx-background-color: #B83B5E;");
        moves.setStyle("-fx-border-color: #B83B5E; -fx-background-color:#FFFFFF;");
    }
    
    //méthode permettant de choisir le deuxième "skin" (Candy)
    @FXML
    private void choix_affichage2(MouseEvent event){
        grille.setVisible(true);
        grille1.setVisible(true);
        grille2.setVisible(true);
        
        p.setVisible(true);
        c.setVisible(true);
        skin1.setVisible(false);
        skin2.setVisible(false);
        skin3.setVisible(false);
        skin4.setVisible(false);
        /*fond.getStyleClass().add("skin1");*/
        fond.setStyle("-fx-background-color:#850E35;");
        grille.setStyle("-fx-background-color: #FFF5E4;");
        grille1.setStyle("-fx-background-color: #FFF5E4;");
        grille2.setStyle("-fx-background-color: #FFF5E4;");
        
        p.setStyle("-fx-background-color:#FFC4C4;");
        c.setStyle("-fx-text-fill:#850E35;");
        bouton1.setStyle("-fx-background-color: #EE6983;");
        bouton2.setStyle("-fx-background-color: #EE6983;"); 
        moves.setStyle("-fx-border-color: #EE6983; -fx-background-color:#FFF5E4");
    }    

    //méthode permettant de choisir le troisième "skin" (Lagoon)
    @FXML
    private void choix_affichage3(MouseEvent event){
        grille.setVisible(true);
        grille1.setVisible(true);
        grille2.setVisible(true);
        
        p.setVisible(true);
        c.setVisible(true);
        skin1.setVisible(false);
        skin2.setVisible(false);
        skin3.setVisible(false);
        skin4.setVisible(false);
        /*fond.getStyleClass().add("skin1");*/
        fond.setStyle("-fx-background-color:#A0E4CB;");
        grille.setStyle("-fx-background-color: #59C1BD;");
        grille1.setStyle("-fx-background-color: #59C1BD;");
        grille2.setStyle("-fx-background-color: #59C1BD;");
        
        p.setStyle("-fx-background-color:#0D4C92;");
        c.setStyle("-fx-text-fill:#A0E4CB;");
        bouton1.setStyle("-fx-background-color: #CFF5E7;");
        bouton2.setStyle("-fx-background-color: #CFF5E7;"); 
        moves.setStyle("-fx-border-color: #59C1BD; -fx-background-color:#CFF5E7"); 
    }
    
    //méthode permettant de choisir le quatrième "skin" (Nature)
    @FXML
    private void choix_affichage4(MouseEvent event){
        grille.setVisible(true);
        grille1.setVisible(true);
        grille2.setVisible(true);
        
        p.setVisible(true);
        c.setVisible(true);
        skin1.setVisible(false);
        skin2.setVisible(false);
        skin3.setVisible(false);
        skin4.setVisible(false);
        /*fond.getStyleClass().add("skin1");*/
        fond.setStyle("-fx-background-color:#F9FCFB;");
        grille.setStyle("-fx-background-color: #B0EACD;");
        grille1.setStyle("-fx-background-color: #B0EACD;");
        grille2.setStyle("-fx-background-color: #B0EACD;");
        
        p.setStyle("-fx-background-color:#21BF73;");
        c.setStyle("-fx-text-fill:#F9FCFB;");
        bouton1.setStyle("-fx-background-color: #FD5E53;");
        bouton2.setStyle("-fx-background-color: #FD5E53;");
        moves.setStyle("-fx-border-color: #FD5E53; -fx-background-color:#FFFFFF");
    }    

    
    @FXML
    private void handleButtonAction(MouseEvent event) {
        grille.setVisible(true);
        p.setVisible(true);
        c.setVisible(true);
        skin1.setVisible(false);
        skin2.setVisible(false);
        skin3.setVisible(false);
        skin4.setVisible(false);
    }
    
    @FXML
    private void changeStyle(MouseEvent event){
        skin1.setVisible(true);
        skin2.setVisible(true);
        skin3.setVisible(true);
        skin4.setVisible(true);
        
        skin1_name.setVisible(true);
        skin1_name.getStyleClass().add("txt");
        skin1_name.setStyle("-fx-background-color:#F08A5D;");
        
        skin2_name.setVisible(true);
        skin2_name.getStyleClass().add("txt");
        skin2_name.setStyle("-fx-background-color:#FFC4C4;");
        
        skin3_name.setVisible(true);
        skin3_name.getStyleClass().add("txt");
        skin3_name.setStyle("-fx-background-color:#59C1BD;");
        
        skin4_name.setVisible(true);
        skin4_name.getStyleClass().add("txt");
        skin4_name.setStyle("-fx-background-color:#21BF73;");
        
        grille.setVisible(false);
        grille1.setVisible(false);
        grille2.setVisible(false);
        p.setVisible(false);
        c.setVisible(false);
    }

    @FXML
    public void keyPressed(KeyEvent ke) {
        System.out.println("touche appuyée");
        String touche = ke.getText();
        if (touche.compareTo("q") == 0) { // utilisateur appuie sur "q" pour envoyer la tuile vers la gauche
            if (objectifx > 24) { // possible uniquement si on est pas dans la colonne la plus à gauche
                objectifx -= (int) 397 / 4; // on définit la position que devra atteindre la tuile en abscisse (modèle). Le thread se chargera de mettre la vue à jour
                score.setText(Integer.toString(Integer.parseInt(score.getText()) + 1)); // mise à jour du compteur de mouvement
            }
        } else if (touche.compareTo("d") == 0) { // utilisateur appuie sur "d" pour envoyer la tuile vers la droite
            if (objectifx < (int) 445 - 2 * 397 / 4 - 24) { // possible uniquement si on est pas dans la colonne la plus à droite (taille de la fenêtre - 2*taille d'une case - taille entre la grille et le bord de la fenêtre)
                objectifx += (int) 397 / 4;
                score.setText(Integer.toString(Integer.parseInt(score.getText()) + 1));
            }
        } else if(touche.compareTo("s") == 0){ // utilisateur appuie sur "s" pour envoyer la tuile vers le haut
            if(objectify < (int) 488){ // possible uniquement si on est pas dans la ligne la plus en bas
                objectify += (int) 397 / 4;
                score.setText(Integer.toString(Integer.parseInt(score.getText()) + 1));
            }
        } else if(touche.compareTo("z") == 0){
            if(objectify > (int) 191){
                objectify -= (int) 397/4;
                score.setText(Integer.toString(Integer.parseInt(score.getText()) + 1));
            }
        } else if(touche.compareTo("f") == 0){
            objectify = 488;
            score.setText(Integer.toString(Integer.parseInt(score.getText()) + 1));
        } else if(touche.compareTo("r") == 0){
            objectify = 191;
            score.setText(Integer.toString(Integer.parseInt(score.getText()) + 1));
        } 
        System.out.println("objectifx=" + objectifx);
        System.out.println("objectify=" + objectify);
        Task task = new Task<Void>() { // on définit une tâche parallèle pour mettre à jour la vue
            @Override
            public Void call() throws Exception { // implémentation de la méthode protected abstract V call() dans la classe Task
                while (x != objectifx) { // si la tuile n'est pas à la place qu'on souhaite attendre en abscisse
                    if (x < objectifx) {
                        x += 1; // si on va vers la droite, on modifie la position de la tuile pixel par pixel vers la droite
                    } else {
                        x -= 1;
                    }
                
                    // Platform.runLater est nécessaire en JavaFX car la GUI ne peut être modifiée que par le Thread courant, contrairement à Swing où on peut utiliser un autre Thread pour ça
                    Platform.runLater(new Runnable() { // classe anonyme
                        @Override
                        public void run() {
                            //javaFX operations should go here
                            //System.out.println("déplacement en cours");
                            p.relocate(x, y); // on déplace la tuile d'un pixel sur la vue, on attend 5ms et on recommence jusqu'à atteindre l'objectif
                            p.setVisible(true);    
                        }
                    }
                    );
                    Thread.sleep(2);
                } // end while
                
                while (y != objectify) { // si la tuile n'est pas à la place qu'on souhaite attendre en abscisse
                    if (y < objectify) {
                        y += 1; // si on va vers la droite, on modifie la position de la tuile pixel par pixel vers la droite
                    } else {
                        y -= 1;
                    }
                
                    // Platform.runLater est nécessaire en JavaFX car la GUI ne peut être modifiée que par le Thread courant, contrairement à Swing où on peut utiliser un autre Thread pour ça
                    Platform.runLater(new Runnable() { // classe anonyme
                        @Override
                        public void run() {
                            //javaFX operations should go here
                            //System.out.println("déplacement en cours");
                            p.relocate(x, y); // on déplace la tuile d'un pixel sur la vue, on attend 5ms et on recommence jusqu'à atteindre l'objectif
                            p.setVisible(true);    
                        }
                    }
                    );
                    Thread.sleep(3);
                } // end while
                return null; // la méthode call doit obligatoirement retourner un objet. Ici on n'a rien de particulier à retourner. Du coup, on utilise le type Void (avec un V majuscule) : c'est un type spécial en Java auquel on ne peut assigner que la valeur null
            } // end call

        };
       
        Thread th = new Thread(task); // on crée un contrôleur de Thread
        th.setDaemon(true); // le Thread s'exécutera en arrière-plan (démon informatique)
        th.start(); // et on exécute le Thread pour mettre à jour la vue (déplacement continu de la tuile horizontalement)
    }
    
}
