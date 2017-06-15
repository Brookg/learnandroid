package cn.rabbitb.brook.a23_spinner;

public class Animal {
    // 对应着 layout ，每一个元素对应着一个属性
    private int icon;    // icon 的 id
    private String name;

    // 构造函数
    public Animal() {}
    public Animal(int icon, String name) {
        this.icon = icon;
        this.name = name;
    }

    // Getter and Setter
    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
