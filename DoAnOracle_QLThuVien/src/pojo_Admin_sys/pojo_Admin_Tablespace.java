package pojo_Admin_sys;

public class pojo_Admin_Tablespace {
    private String tablespace_name, file_name, logging, online_status,size,tudongtang,maxsize;

    public String getTablespace_name() {
        return tablespace_name;
    }

    public void setTablespace_name(String tablespace_name) {
        this.tablespace_name = tablespace_name;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getLogging() {
        return logging;
    }

    public void setLogging(String logging) {
        this.logging = logging;
    }

    public String getOnline_status() {
        return online_status;
    }

    public void setOnline_status(String online_status) {
        this.online_status = online_status;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTudongtang() {
        return tudongtang;
    }

    public void setTudongtang(String tudongtang) {
        this.tudongtang = tudongtang;
    }

    public String getMaxsize() {
        return maxsize;
    }

    public void setMaxsize(String maxsize) {
        this.maxsize = maxsize;
    }

    public pojo_Admin_Tablespace(String tablespace_name, String file_name, String logging, String online_status, String size, String tudongtang, String maxsize) {
        this.tablespace_name = tablespace_name;
        this.file_name = file_name;
        this.logging = logging;
        this.online_status = online_status;
        this.size = size;
        this.tudongtang = tudongtang;
        this.maxsize = maxsize;
    }

    public pojo_Admin_Tablespace() {
        tablespace_name=file_name=logging=online_status=size=tudongtang=maxsize="";
    }

    @Override
    public String toString() {
        return "pojo_Admin_Tablespace{" + "tablespace_name=" + tablespace_name + ", file_name=" + file_name + ", logging=" + logging + ", online_status=" + online_status + ", size=" + size + ", tudongtang=" + tudongtang + ", maxsize=" + maxsize + '}';
    }
}