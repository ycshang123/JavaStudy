package top.ycshang.address.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import top.ycshang.address.MainApp;
import top.ycshang.address.model.Person;
import top.ycshang.address.utils.DateUtil;

import java.util.List;
import java.util.stream.Collectors;

public class PersonController {
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> nameColumn;
    @FXML
    private TableColumn<Person, String> clazzColumn;
    @FXML
    private Label nameLabel;
    @FXML
    private Label clazzLabel;
    @FXML
    private Label genderLabel;
    @FXML
    private Label addressLabel;
    @FXML
    private Label birthdayLabel;
    @FXML
    private ImageView avatar;
    private MainApp mainApp;
    private ObservableList<Person> personData;
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
        personData = mainApp.getPersonData();
        FilteredList<Person> filteredData = new FilteredList<>(personData, p -> true);
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
            clazzLabel.setText(person.getClazz());
            genderLabel.setText(person.getGender());
            addressLabel.setText(person.getAddress());
            birthdayLabel.setText(DateUtil.format(person.getBirthday()));
            avatar.setImage(person.getAvatar());
        } else {
            nameLabel.setText(" ");
            clazzLabel.setText(" ");
            genderLabel.setText(" ");
            addressLabel.setText(" ");
            birthdayLabel.setText(" ");
            avatar.setImage(new Image("https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/pag1.53uyoikvn180.jpg"));
        }
    }


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

    public void handleResetPerson() {
        personData = mainApp.getPersonData();
        personTable.setItems(personData);
        showPersonDetails(personData.get(0));
    }
}