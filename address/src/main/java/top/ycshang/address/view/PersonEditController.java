package top.ycshang.address.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import top.ycshang.address.MainApp;
import top.ycshang.address.model.Person;
import top.ycshang.address.utils.DateUtil;

/**
 * @description:
 * @author: ycshang
 * @date: 2021/10/10
 */
public class PersonEditController {


    private Stage editStage;

    private MainApp mainApp;


    @FXML
    private TextField nameField;

    @FXML
    private TextField clazzField;

    @FXML
    private RadioButton maleButton;

    @FXML
    private RadioButton femaleButton;

    @FXML
    private ToggleGroup group;

    @FXML
    private TextField addressField;

    @FXML
    private TextField birthdayField;

    @FXML
    private TextField avatarField;

    @FXML
    private void initialize() {
    }

    public void setEditStage(Stage editStage) {
        this.editStage = editStage;
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void handleSubmit(ActionEvent actionEvent) {
        Person person = new Person();
        person.setName(nameField.getText());
        person.setClazz(clazzField.getText());
        person.setAddress(addressField.getText());
        person.setAvatar(new Image(avatarField.getText()));
        person.setBirthday(DateUtil.parse(birthdayField.getText()));
        //注意性别单选按钮的写法
        group.selectedToggleProperty().addListener((ov, oldVal, newVal) -> {
            person.setGender(group.getSelectedToggle().getUserData().toString());
        });
        mainApp.getPersonData().add(person);
        editStage.close();
        mainApp.getStage().setIconified(false);
    }

    public void handleCancel(ActionEvent actionEvent) {
        editStage.close();
        mainApp.getStage().setIconified(false);
    }
}
