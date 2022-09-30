package pojo_Admin_sys;

public class pojo_Admin_Parameter {
    private String num, name, type, value, display_value, default_value;
    
    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDislayValue() {
        return display_value;
    }

    public void setDislayValue(String display_value) {
        this.display_value = display_value;
    }

    public String getDfValue() {
        return default_value;
    }

    public void setDfValue(String default_value) {
        this.default_value = default_value;
    }

    @Override
    public String toString() {
        return "pojo_Admin_Parameter{" + "num=" + num + ", name=" + name + ", "
                + "type=" + type + ", value=" + value + ", "
                + "display_value=" + display_value + ", "
                + "default_value=" + default_value + '}';
    }

    public pojo_Admin_Parameter(String num, String name, String type, 
            String value, String display_value, String default_value) {
        this.num = num;
        this.name = name;
        this.type = type;
        this.value = value;
        this.display_value = display_value;
        this.default_value = default_value;
    }

    public pojo_Admin_Parameter() {
    
        num = name = type = value = display_value = default_value = "";
    }
}