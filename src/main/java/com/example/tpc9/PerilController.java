package com.example.tpc9;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javax.swing.text.Element;
import java.awt.*;
import java.awt.event.AdjustmentListener;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class PerilController implements Initializable, Adjustable {

    @FXML
    private Circle minhafoto;

    @FXML
    private Circle minhafoto2;
    @FXML
    private Circle minhafoto3;
    @FXML
    private Circle minhafoto4;
    @FXML
    private Circle minhafoto5;
    @FXML
    public Label peril;

    //top Perfil bar
    @FXML
    private Button grupos;
    @FXML
    private Button eventos;
    @FXML
    private Button newsFeed;
    @FXML
    private Button posts;
    @FXML
    private Button settings;

    @FXML
    private ScrollPane groups;
    @FXML
    private ScrollPane post;

    public void goHome(MouseEvent event) throws IOException {
        Parent go2 = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene goScene2 = new Scene(go2);
        Stage goStage2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        goStage2.setScene(goScene2);
        goStage2.show();
    }

    public void grupPane(MouseEvent event) {
        groups.setVisible(true);
        post.setVisible(false);
        grupos.setOpacity(1);
        eventos.setOpacity(0.7);
        newsFeed.setOpacity(0.7);
        posts.setOpacity(0.7);
        settings.setOpacity(0.7);
    }

    public void postPane(MouseEvent event) {
        post.setVisible(true);
        groups.setVisible(false);
        grupos.setOpacity(0.7);
        eventos.setOpacity(0.7);
        newsFeed.setOpacity(0.7);
        posts.setOpacity(1);
        settings.setOpacity(0.7);
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SignInUser nome = new SignInUser();
        peril.setText(nome.returnUsername());
        post.setVisible(true);

        DataBaseConnection conected = new DataBaseConnection();
        Connection databaseLink = conected.getConection();

        String sql = "SELECT fotoperfil FROM fotos WHERE nome = ?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = databaseLink.prepareStatement(sql);
            preparedStatement.setString(1, nome.returnUsername());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                if (resultSet.next() == true) {
                    Image img = new Image(resultSet.getString("fotoperfil"));
                    minhafoto.setFill(new ImagePattern(img));
                } else {
                    Image img = new Image("file:src/main/resources/com/example/tpc9/Images/gemstone.png");
                    minhafoto.setFill(new ImagePattern(img));
                }
            }
            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        Image img2 = new Image("file:src/main/resources/com/example/tpc9/Images/logoPD.jpeg");
        minhafoto2.setFill(new ImagePattern(img2));
        Image img3 = new Image("file:src/main/resources/com/example/tpc9/Images/logout.png");
        minhafoto3.setFill(new ImagePattern(img3));
        Image img4 = new Image("file:src/main/resources/com/example/tpc9/Images/pedrada.png");
        minhafoto4.setFill(new ImagePattern(img4));
        Image img5 = new Image("file:src/main/resources/com/example/tpc9/Images/wallpaperSombra.png");
        minhafoto5.setFill(new ImagePattern(img5));

    }













































    @Override
    public int getOrientation() {
        return 0;
    }

    @Override
    public void setMinimum(int min) {

    }

    @Override
    public int getMinimum() {
        return 0;
    }

    @Override
    public void setMaximum(int max) {

    }

    @Override
    public int getMaximum() {
        return 0;
    }

    @Override
    public void setUnitIncrement(int u) {

    }

    @Override
    public int getUnitIncrement() {
        return 0;
    }

    @Override
    public void setBlockIncrement(int b) {

    }

    @Override
    public int getBlockIncrement() {
        return 0;
    }

    @Override
    public void setVisibleAmount(int v) {

    }

    @Override
    public int getVisibleAmount() {
        return 0;
    }

    @Override
    public void setValue(int v) {

    }

    @Override
    public int getValue() {
        return 0;
    }

    @Override
    public void addAdjustmentListener(AdjustmentListener l) {

    }

    @Override
    public void removeAdjustmentListener(AdjustmentListener l) {

    }
}