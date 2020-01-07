package com.gisinfo.sand.auth;

import com.gisinfo.platform.components.auth.web.ws.client.*;
import com.gisinfo.sand.core.auth.*;
import com.gisinfo.sand.core.auth.impl.*;
import com.gisinfo.sand.core.exception.exception.PermissionException;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 集成公司权限系统
 * @date 2018/7/28
 * @author yuzhibin
 */

public class AuthUserService implements IUserService {

    private AuthServiceClient authServiceClient;

    @Override
    public IUser getUserObjectByLoginName(String loginName) {
        return getUserObjectFromGISInfoAuth(authServiceClient,loginName);
    }

    @Override
    public IUser getUserObjectByPermission(String loginName, String password) {
        WsPermissionResult result = null;
        try {
            //调用公司的权限验证
            result = authServiceClient.getPermissionWithAuth(loginName,password, null,null);
        } catch (Exception e) {
            throw new PermissionException(result.getMessage());
        }
        if (result.getUser().getLoginName() != null) {
            WsUser user = result.getUser();
            if(user!=null)
                return getUserObjectFromWsPermissionResult(result);
        }
        return null;
    }


    @Override
    public IUser getCurrentUserObject() {
        Subject subject = SecurityUtils.getSubject();
        Object principal = subject.getPrincipal();
        String user=String.valueOf(principal);
        if (principal instanceof Principal) {
            user= ((Principal) principal).getName();
        }
        if(principal instanceof IUser ){
            return (IUser) principal;
        }
        return getUserObjectByLoginName(user);
    }


    @Override
    public void modifyPassword() {

    }

    private IUser getUserObjectFromWsPermissionResult(WsPermissionResult result){
        User userObject=null;
        if (result != null) {
            WsUser user = result.getUser();
            List<WsPermissionResource> wsPermissionResults = result.getResources();
            List<IResource> resources = new ArrayList<>();
            processSubPermissions(resources, wsPermissionResults);
            int size = result.getOrganizations().size();
            List<Organization> organizations=new ArrayList<>(size);
            if(size>0){
                result.getOrganizations().forEach(organizationWs ->{
                    Organization organization = new Organization();
                    organization.setCode(organizationWs.getOrgCode());
                    organization.setName(organizationWs.getOrgName());
                    organization.setId(organizationWs.getOrgId());
                    organizations.add(organization);
                });
            }
            userObject=getFromWsUser(user,organizations.toArray(new Organization[size]),resources);
            List<WsRole> roles= result.getRoles();
            List<IRole> roleList=new ArrayList<>(roles.size());
            Optional<List<WsRole>> wsRolesOptional = Optional.ofNullable(roles);
            wsRolesOptional.ifPresent(wsRoles -> {
                wsRoles.forEach(wsRole -> {
                    Role role=new Role();
                    role.setCode(wsRole.getRoleCode());
                    role.setId(wsRole.getRoleId());
                    role.setName(wsRole.getRoleName());
                    roleList.add(role);
                });
            });
            userObject.setRoles(roleList.toArray(new Role[roleList.size()]));

        }
        return userObject;
    }

    private   IUser getUserObjectFromGISInfoAuth(AuthServiceClient authServiceClient ,String loginName){
        User userObject ;
        try {
            WsPermissionResult result = authServiceClient.getPermissionByLoginName(loginName,null, null);
            userObject = (User) getUserObjectFromWsPermissionResult(result);
            return userObject;
        } catch (Exception e) {
            return null;
        }
    }

    private User getFromWsUser(WsUser user,Organization[] organizations,List<IResource> permissionInfos){
        User userObject=new User();
        userObject.setId(user.getUserId());
        userObject.setLoginName(user.getLoginName());
        //userObject.setPassword(com.gisinfo.sand.user.getUserPwd());
        userObject.setRealName(user.getUserName());
        userObject.setOrganizations(organizations);
        userObject.setResources(permissionInfos.toArray(new IResource[permissionInfos.size()]));
        return userObject;
    }

    private void processSubPermissions(List<IResource> resources, List<WsPermissionResource> subItems){
        if(subItems == null || subItems.size() <= 0) return ;
        if(resources == null) return ;
        subItems.stream().forEach(wsPermissionResource -> {
            List<WsResourceOperation> wsResourceOperations = wsPermissionResource.getOperations();
            Resource resource=new Resource();
            resource.setCode(wsPermissionResource.getResourceCode());
            resource.setName(wsPermissionResource.getResourceName());
            resource.setId(wsPermissionResource.getResourceId());
            List<IPermission> permissions=wsResourceOperations.stream().map(wsResourceOperation -> {
                Permission permission=new Permission();
                permission.setCode(wsResourceOperation.getOperationCode());
                permission.setId(wsResourceOperation.getOperationId());
                permission.setName(wsPermissionResource.getResourceName());
                permission.setParent(resource);
                return permission;
            }).collect(Collectors.toList());
            resource.setPermissions(permissions.toArray(new IPermission[permissions.size()]));
            resources.add(resource);
            processSubPermissions(resources,wsPermissionResource.getChildren());
        });
    }

    /**
     * 解密密码
     * @param pwd
     * @return
     */
    private String decodePwd(String pwd){
        if(StringUtils.isEmpty(pwd)) return null;
        StringBuffer pd = new StringBuffer();
        String[] s = pwd.split(",");
        for(int i = 0; i < s.length; i++){
            pd.append((char)Integer.parseInt(s[i]));
        }
        return pd.toString();
    }

    public AuthServiceClient getAuthServiceClient() {
        return authServiceClient;
    }

    public void setAuthServiceClient(AuthServiceClient authServiceClient) {
        this.authServiceClient = authServiceClient;
    }
}
