package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
    private StringProperty name;
    private StringProperty age;//表格只能添加string类型

    public User(String name, int age) {
        this.name = new SimpleStringProperty(name);
        this.age = new SimpleStringProperty(String.valueOf(age));
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public int getAge() {
        return Integer.parseInt(age.get());
    }

    public StringProperty ageProperty() {
        return age;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setAge(int age) {
        this.age.set(String.valueOf(age));
    }

}
