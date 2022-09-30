package pojo_Admin_sys;

public class pojo_Admin_RightsGroup {
    private  String role, password_required, authentication_type, common, oracle_maintained;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPwRequired() {
        return password_required;
    }

    public void setPwRequired(String password_required) {
        this.password_required = password_required;
    }

    public String getAuthenType() {
        return authentication_type;
    }

    public void setAuthenType(String authentication_type) {
        this.authentication_type = authentication_type;
    }

    public String getCommon() {
        return common;
    }

    public void setCommon(String common) {
        this.common = common;
    }

    public String getOMaintained() {
        return oracle_maintained;
    }

    public void setOMaintained(String oracle_maintained) {
        this.oracle_maintained = oracle_maintained;
    }

    public pojo_Admin_RightsGroup(String role, String password_required, 
            String authentication_type, String common, String oracle_maintained) {
        this.role = role;
        this.password_required = password_required;
        this.authentication_type = password_required;
        this.common = common;
        this.oracle_maintained = oracle_maintained;
    }

    

    public pojo_Admin_RightsGroup() {
    
        role=password_required=authentication_type=common=oracle_maintained="";
    }

    @Override
    public String toString() {
        return "pojo_Admin_RightsGroup{" + "role=" + role + ", "
                + "password_required=" + password_required + ", "
                + "authentication_type=" + authentication_type + ", "
                + "common=" + common + ", oracle_maintained=" + oracle_maintained + '}';
    }
}