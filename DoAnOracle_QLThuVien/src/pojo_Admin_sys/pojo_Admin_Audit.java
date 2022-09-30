package pojo_Admin_sys;

public class pojo_Admin_Audit {
    private String object_schema, object_name, policy_owner, policy_name, 
            enabled, sel,ins,upd,del;

    public String getObject_schema() {
        return object_schema;
    }

    public void setObject_schema(String object_schema) {
        this.object_schema = object_schema;
    }

    public String getObject_name() {
        return object_name;
    }

    public void setObject_name(String object_name) {
        this.object_name = object_name;
    }

    public String getPolicy_owner() {
        return policy_owner;
    }

    public void setPolicy_owner(String policy_owner) {
        this.policy_owner = policy_owner;
    }

    public String getPolicy_name() {
        return policy_name;
    }

    public void setPolicy_name(String policy_name) {
        this.policy_name = policy_name;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getSel() {
        return sel;
    }

    public void setSel(String sel) {
        this.sel = sel;
    }

    public String getIns() {
        return ins;
    }

    public void setIns(String ins) {
        this.ins = ins;
    }

    public String getUpd() {
        return upd;
    }

    public void setUpd(String upd) {
        this.upd = upd;
    }

    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del;
    }

    public pojo_Admin_Audit(String object_schema, String object_name, String policy_owner, String policy_name, String enabled, String sel, String ins, String upd, String del) {
        this.object_schema = object_schema;
        this.object_name = object_name;
        this.policy_owner = policy_owner;
        this.policy_name = policy_name;
        this.enabled = enabled;
        this.sel = sel;
        this.ins = ins;
        this.upd = upd;
        this.del = del;
    }

    public pojo_Admin_Audit() {
    
        object_schema=object_name=policy_owner=policy_name=enabled=sel=ins=upd=del="";
    }

    
    @Override
    public String toString() {
        return "pojo_Admin_Audit{" + "object_schema=" + object_schema + ", object_name=" + object_name + ", policy_owner=" + policy_owner + ", policy_name=" + policy_name + ", enabled=" + enabled + ", sel=" + sel + ", ins=" + ins + ", upd=" + upd + ", del=" + del + '}';
    }
}