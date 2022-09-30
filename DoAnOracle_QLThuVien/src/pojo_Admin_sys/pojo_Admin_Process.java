package pojo_Admin_sys;

public class pojo_Admin_Process {
    private  String addr,pname,username,terminal,program,tracefile;

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getTracefile() {
        return tracefile;
    }

    public void setTracefile(String tracefile) {
        this.tracefile = tracefile;
    }

    @Override
    public String toString() {
        return "pojo_Admin_Process{" + "addr=" + addr + ", pname=" + pname + ", username=" + username + ", terminal=" + terminal + ", program=" + program + ", tracefile=" + tracefile + '}';
    }

    public pojo_Admin_Process(String addr, String pname, String username, String terminal, String program, String tracefile) {
        this.addr = addr;
        this.pname = pname;
        this.username = username;
        this.terminal = terminal;
        this.program = program;
        this.tracefile = tracefile;
    }

    public pojo_Admin_Process() {
    
        addr=pname=username=terminal=program=tracefile="";
    }
    
}
