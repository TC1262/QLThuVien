package pojo_Admin_sys;

public class pojo_Admin_Session {
    private  String sid,serial,username,program,terminal,tracefile;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

  

    public String getTracefile() {
        return tracefile;
    }

    public void setTracefile(String tracefile) {
        this.tracefile = tracefile;
    }

    public pojo_Admin_Session(String sid, String serial, String username, String program, String terminal, String tracefile) {
        this.sid = sid;
        this.serial = serial;
        this.username = username;
        this.program = program;
        this.terminal = terminal;
        this.tracefile = tracefile;
    }

    

    public pojo_Admin_Session() {
    
        sid=serial=username=program=terminal=tracefile="";
    }

    @Override
    public String toString() {
        return "pojo_Admin_Session{" + "sid=" + sid + ", serial=" + serial + ", username=" + username + ", program=" + program + ", terminal=" + terminal + ", tracefile=" + tracefile + '}';
    }
}