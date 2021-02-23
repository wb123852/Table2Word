package com.wangbo.table2word.domain;

/**
 * @author WangBo
 * @since 2020/1/6 17:22
 **/
public class TableFileds {

    private String field;

    private String type;

    private String Null;

    private String key;

    private String comment;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNull() {
        return Null;
    }

    public void setNull(String aNull) {
        Null = aNull;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "TableFileds{" +
                "field='" + field + '\'' +
                ", type='" + type + '\'' +
                ", Null='" + Null + '\'' +
                ", key='" + key + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
