package pojo_Admin;

public class pojo_Admin_Account {
    private  String cM,pass;

    public String getcM() {
        return cM;
    }

    public void setcM(String cM) {
        this.cM = cM;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public pojo_Admin_Account(String cM, String pass) {
        this.cM = cM;
        this.pass = pass;
    }

    public pojo_Admin_Account() {
    
        cM=pass="";
    }

    @Override
    public String toString() {
        return "pojo_Admin_Account{" + "cM=" + cM + ", pass=" + pass + '}';
    }
}