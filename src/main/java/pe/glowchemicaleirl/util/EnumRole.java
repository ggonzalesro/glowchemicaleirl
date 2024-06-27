package pe.glowchemicaleirl.util;

import pe.glowchemicaleirl.exception.RoleException;

public enum EnumRole {
    ADMIN,
    USER,
    STORE,
    PRODUCTION;

    public static EnumRole fromString(String roleName) {
        for (EnumRole role : EnumRole.values()) {
            if (role.name().equalsIgnoreCase(roleName)) {
                return role;
            }
        }
        throw new RoleException("Role ".concat(roleName).concat(" not found"));
    }
}
