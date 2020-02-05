package com.diboot.iam.vo;

import com.diboot.core.binding.annotation.BindEntityList;
import com.diboot.iam.config.Cons;
import com.diboot.iam.entity.IamPermission;
import com.diboot.iam.entity.IamRole;
import lombok.Data;

import java.util.List;

/**
* 角色 VO定义
* @author mazc@dibo.ltd
* @version 2.0
* @date 2019-12-03
*/
@Data
public class IamRoleVO extends IamRole {
    private static final long serialVersionUID = -6778550575399070076L;

    // 字段关联：this.id=iam_role_permission.role_id AND iam_role_permission.permission_id=id
    @BindEntityList(entity = IamPermission.class, condition = "this.id=iam_role_permission.role_id AND iam_role_permission.permission_id=id AND iam_role_permission.is_deleted=0")
    private List<IamPermission> permissionList;

    /***
     * 是否为超级管理员
     * @return
     */
    public boolean isSuperAdmin(){
        return Cons.ROLE_SUPER_ADMIN.equals(getCode());
    }

}