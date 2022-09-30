package pojo_Admin_sys;

public class pojo_Admin_Instance {
    private  String instance_name,host_name,startup_time,status;

    public String getInstance_name() {
        return instance_name;
    }

    public void setInstance_name(String instance_name) {
        this.instance_name = instance_name;
    }

    public String getHost_name() {
        return host_name;
    }

    public void setHost_name(String host_name) {
        this.host_name = host_name;
    }

    public String getStartup_time() {
        return startup_time;
    }

    public void setStartup_time(String startup_time) {
        this.startup_time = startup_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public pojo_Admin_Instance(String instance_name, String host_name, String startup_time, String status) {
        this.instance_name = instance_name;
        this.host_name = host_name;
        this.startup_time = startup_time;
        this.status = status;
    }

    public pojo_Admin_Instance() {
    
        instance_name=host_name=startup_time=status="";
    }

    
    @Override
    public String toString() {
        return "pojo_Admin_Instance{" + "instance_name=" + instance_name + ", host_name=" + host_name + ", startup_time=" + startup_time + ", status=" + status + '}';
    }
}