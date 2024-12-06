package controllers;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utils.BackwardScreen;
import views.PlayingView;

public class PlayingViewController implements BackwardScreen {
    @FXML
    private ImageView homeIcon;
    @FXML
    private ImageView settingIcon;
    @FXML
    private ImageView clear30Lines;
    @FXML
    private ImageView Z_Tetrimino;
    @FXML
    private ImageView O_Tetrimino;
    @FXML
    private ImageView I_Tetrimino;
    @FXML
    private ImageView T_Tetrimino;
    @FXML
    private ImageView reloadIcon;
    @FXML
    private ImageView actionIcon;
    private final Image pauseIcon = new Image(getClass().getResourceAsStream("/images/pause.png"));
    private final Image continueIcon = new Image(getClass().getResourceAsStream("/images/continue.png"));


    public static void view(Stage stage) throws Exception {
        PlayingView.displayView(stage);
    }

    @Override
    public void backToMainScreen() throws Exception {
        ViewController.getMainView();
    }

    @FXML
    public void initialize() {
        homeIcon.setImage(new Image(getClass().getResource("/images/home.png").toExternalForm()));
        settingIcon.setImage(new Image(getClass().getResource("/images/setting.png").toExternalForm()));
        clear30Lines.setImage(new Image(getClass().getResource("/images/clear30Lines.png").toExternalForm()));
        Z_Tetrimino.setImage(new Image(getClass().getResource("/images/Z-Tetrimino.png").toExternalForm()));
        O_Tetrimino.setImage(new Image(getClass().getResource("/images/O-Tetrimino.png").toExternalForm()));
        I_Tetrimino.setImage(new Image(getClass().getResource("/images/I-Tetrimino.png").toExternalForm()));
        T_Tetrimino.setImage(new Image(getClass().getResource("/images/T-Tetrimino.png").toExternalForm()));
        reloadIcon.setImage(new Image(getClass().getResource("/images/reload.png").toExternalForm()));
        actionIcon.setImage(pauseIcon);
    }

    public void handleToggleActionIcon() {
        if (actionIcon.getImage().equals(pauseIcon)) {
            actionIcon.setImage(continueIcon);
        } else {
            actionIcon.setImage(pauseIcon);
        }
    }

    public void openSettingView() throws Exception {
        ViewController.getSettingView();
    }

}

