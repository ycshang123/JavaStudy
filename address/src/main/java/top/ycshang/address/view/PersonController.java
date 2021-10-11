package top.ycshang.address.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import top.ycshang.address.MainApp;
import top.ycshang.address.config.AppConstant;
import top.ycshang.address.model.Person;
import top.ycshang.address.utils.DateUtil;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PersonController {
    private MainApp mainApp;

    private FilteredList<Person> filteredData;


    @FXML
    private TableView<Person> personTable;

    @FXML
    private TableColumn<Person, String> nameColumn;


    @FXML
    private TableColumn<Person, String> clazzColumn;


    @FXML
    private Label nameLabel;

    @FXML
    private Label genderLabel;

    @FXML
    private Label addressLabel;

    @FXML
    private Label birthdayLabel;

    @FXML
    private ImageView avatar;

    @FXML
    private TextField inputField;

    public PersonController() {
    }

    @FXML
    private void initialize() {
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        clazzColumn.setCellValueFactory(cellData -> cellData.getValue().clazzProperty());
        showPersonDetails(null);
        personTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showPersonDetails(newValue));

    }

    /**
     * 接收主窗体对象，获取数据
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        filteredData = new FilteredList<>(mainApp.getPersonData(), p -> true);
        inputField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                return person.getName().toLowerCase().contains(lowerCaseFilter)
                        || person.getGender().toLowerCase().contains(lowerCaseFilter)
                        || person.getClazz().toLowerCase().contains(lowerCaseFilter)
                        || person.getAddress().toLowerCase().contains(lowerCaseFilter);
            });
        });
        personTable.setItems(filteredData);
    }

    /**
     * 显示用户信息
     *
     * @param person
     */
    private void showPersonDetails(Person person) {
        if (person != null) {
            nameLabel.setText(person.getName());
            genderLabel.setText(person.getGender());
            addressLabel.setText(person.getAddress());
            birthdayLabel.setText(DateUtil.format(person.getBirthday()));
            avatar.setImage(person.getAvatar());
        } else {
            nameLabel.setText(" ");
            genderLabel.setText(" ");
            addressLabel.setText(" ");
            birthdayLabel.setText(" ");
            avatar.setImage(new Image("https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/pag1.53uyoikvn180.jpg"));
        }
    }

    /**
     * 查询用户
     */
    public void handleSearchPerson() {
        String keywords = inputField.getText().trim();
        ObservableList<Person> items = personTable.getItems();
        List<Person> list = items.stream().filter(p -> p.getName().contains(keywords) || p.getClazz().contains(keywords))
                .collect(Collectors.toList());
        if (list.size() != 0) {
            personTable.setItems(FXCollections.observableList(list));
            showPersonDetails(list.get(0));
        }
        inputField.setText("");
    }

    /**
     * 删除人员
     */
    public void handleDeletePerson() {
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            mainApp.getPersonData().remove(selectedIndex);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("提示");
            a.setHeaderText("错误操作");
            a.setContentText("必选选择人员才能删除");
            a.showAndWait();
        }
    }


    /**
     * 新增人员
     */
    public void handleNewPerson() {
        Person tempPerson = new Person("ycshang", "软件", "女", "江苏南京", LocalDate.of(2000, 11, 28),
                new Image("https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/1.6cr8zznpvjc0.jpg"));
        mainApp.showEditPerson(tempPerson, AppConstant.NEW_PERSON);
    }

    /**
     * 编辑人员
     */
    public void handleEditPerson() {

        Person person = personTable.getSelectionModel().getSelectedItem();
        if (person != null) {
            mainApp.showEditPerson(person, AppConstant.EDIT_PERSON);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("提示");
            alert.setHeaderText("错误操作");
            alert.setContentText("必须选择人员才能编辑");
            alert.showAndWait();
        }
    }
}