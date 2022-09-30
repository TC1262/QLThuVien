package pojo_Admin_sys;

public class pojo_Admin_Database {
    private  String name,created,Log_mode,controlfile_time,open_mode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getLog_mode() {
        return Log_mode;
    }

    public void setLog_mode(String Log_mode) {
        this.Log_mode = Log_mode;
    }

    public String getControlfile_time() {
        return controlfile_time;
    }

    public void setControlfile_time(String controlfile_time) {
        this.controlfile_time = controlfile_time;
    }

    public String getOpen_mode() {
        return open_mode;
    }

    public void setOpen_mode(String open_mode) {
        this.open_mode = open_mode;
    }

    public pojo_Admin_Database(String name, String created, String Log_mode, String controlfile_time, String open_mode) {
        this.name = name;
        this.created = created;
        this.Log_mode = Log_mode;
        this.controlfile_time = controlfile_time;
        this.open_mode = open_mode;
    }

    public pojo_Admin_Database() {
    
        name=created=Log_mode=controlfile_time=open_mode="";
    }

    
    @Override
    public String toString() {
        return "pojo_Admin_Database{" + "name=" + name + ", created=" + created + ", Log_mode=" + Log_mode + ", controlfile_time=" + controlfile_time + ", open_mode=" + open_mode + '}';
    }
}