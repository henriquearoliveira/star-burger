package com.startup.burger.business.model.enums;

public enum AuthorityEnum {

    SUPER(1L, "ROLE_SUPER"),
    ADMIN(2L, "ROLE_ADMIN"),
    USER(3L, "ROLE_USER");

    private Long cod;
    private String desc;

    AuthorityEnum(Long cod, String desc) {
        this.cod = cod;
        this.desc = desc;
    }

    public Long getCod() {
        return this.cod;
    }

    public String getDescricao() {
        return this.desc;
    }

    public static AuthorityEnum toEnum(Long cod) {

        if (cod == null) {
            return null;
        }

        for (AuthorityEnum x : AuthorityEnum.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Invalid : " + cod);
    }
}
