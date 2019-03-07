package com.dashu.AutoBulider.service;

public interface CodeCreatorService {
    public String createControllerCode(String eneity);

    public String createServiceCode(String eneity);

    public String createServiceImplCode(String eneity);

    public String createRepositoryCode(String eneity);

    public String createEntityCode(String eneity);

    public String createVOCode(String eneity);

    public String createFormCode(String eneity);

    public String createHtmlCode(String eneity);
}
