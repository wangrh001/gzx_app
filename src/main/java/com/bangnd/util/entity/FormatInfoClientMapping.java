package com.bangnd.util.entity;

import javax.persistence.*;

@Entity
@Table(name="cfg_format_info_client_mapping")
public class FormatInfoClientMapping {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String clientKey;

    @Column
    private String formatInfoKey;

    @Column
    private int ocrFileType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientKey() {
        return clientKey;
    }

    public void setClientKey(String clientKey) {
        this.clientKey = clientKey;
    }

    public String getFormatInfoKey() {
        return formatInfoKey;
    }

    public void setFormatInfoKey(String formatInfoKey) {
        this.formatInfoKey = formatInfoKey;
    }

    public int getOcrFileType() {
        return ocrFileType;
    }

    public void setOcrFileType(int ocrFileType) {
        this.ocrFileType = ocrFileType;
    }
}
