package top.ycshang.address.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

import java.time.LocalDate;

/**
 * @program: address
 * @description:
 * @author: ycshang
 * @create: 2021-10-08 20:27
 **/
public class Person {
    private final StringProperty name;
    private final StringProperty clazz;
    private final StringProperty gender;
    private final StringProperty address;
    private final ObjectProperty<LocalDate> birthday;
    private final ObjectProperty<Image> avatar;

    public Person() {
        this(null, null, null, null, null, null);
    }

    public Person(String name, String clazz, String gender, String address, LocalDate birthday, Image avatar) {
        this.name = new SimpleStringProperty(name);
        this.clazz = new SimpleStringProperty(clazz);
        this.gender = new SimpleStringProperty(gender);
        this.address = new SimpleStringProperty(address);
        this.birthday = new SimpleObjectProperty<>(birthday);
        this.avatar = new SimpleObjectProperty<>(avatar);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getClazz() {
        return clazz.get();
    }

    public void setClazz(String clazz) {
        this.clazz.set(clazz);
    }

    public StringProperty clazzProperty() {
        return clazz;
    }

    public String getGender() {
        return gender.get();
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public StringProperty genderProperty() {
        return gender;
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public StringProperty addressProperty() {
        return address;
    }

    public LocalDate getBirthday() {
        return birthday.get();
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }

    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }

    public Image getAvatar() {
        return avatar.get();
    }

    public void setAvatar(Image avatar) {
        this.avatar.set(avatar);
    }

    public ObjectProperty<Image> avatarProperty() {
        return avatar;
    }
}