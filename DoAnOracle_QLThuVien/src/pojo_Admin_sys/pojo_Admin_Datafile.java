package pojo_Admin_sys;

public class pojo_Admin_Datafile {
    private  String file_name,file_id,tablespace_name,status,bytes,maxbytes;

    public String getFileName() {
        return file_name;
    }

    public void setFileName(String file_name) {
        this.file_name = file_name;
    }

    public String getFileId() {
        return file_id;
    }

    public void setFileId(String file_id) {
        this.file_id = file_id;
    }

    public String getTBSpaceName() {
        return tablespace_name;
    }

    public void setTBSpaceName(String tablespace_name) {
        this.tablespace_name = tablespace_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBytes() {
        return bytes;
    }

    public void setBytes(String bytes) {
        this.bytes = bytes;
    }

    public String getMaxBytes() {
        return maxbytes;
    }

    public void setMaxBytes(String maxbytes) {
        this.maxbytes = maxbytes;
    }

    public pojo_Admin_Datafile(String file_name, String file_id, 
            String tablespace_name, String status, String bytes, String maxbytes) {
        this.file_name = file_name;
        this.file_id = file_id;
        this.tablespace_name = tablespace_name;
        this.status = status;
        this.bytes = bytes;
        this.maxbytes = maxbytes;
    }

    public pojo_Admin_Datafile() {
        file_name=file_id=tablespace_name=status=bytes=maxbytes="";
    }

    
    @Override
    public String toString() {
        return "pojo_Admin_Datafile{" + "file_name=" + file_name + ", "
                + "file_id=" + file_id + ", tablespace_name=" + tablespace_name + ", "
                + "status=" + status + ", bytes=" + bytes + ", maxbytes=" + maxbytes + '}';
    }
}