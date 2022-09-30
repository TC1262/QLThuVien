package pojo_Admin_sys;

public class pojo_Admin_SysPermission {
    private String grantee, privilege, admin_option, common;
       // người nhận quyền, quyền
    
    public String getGrantee() {
        return grantee;
    }

    public void setGrantee(String grantee) {
        this.grantee = grantee;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public String getAdOption() {
        return admin_option;
    }

    public void setAdOption(String admin_option) {
        this.admin_option = admin_option;
    }

    public String getCommon() {
        return common;
    }

    public void setCommon(String common) {
        this.common = common;
    }

    public pojo_Admin_SysPermission(String grantee, String privilege, 
            String admin_option, String common) {
        this.grantee = grantee;
        this.privilege = privilege;
        this.admin_option = admin_option;
        this.common = common;
    }

    public pojo_Admin_SysPermission() {
    
        grantee=privilege=admin_option=common="";
    }

    
    @Override
    public String toString() {
        return "pojo_Admin_SysPermission{" + "grantee=" + grantee + ", "
                + "privilege=" + privilege + ", admin_option=" + admin_option + ", "
                + "common=" + common + '}';
    }
}