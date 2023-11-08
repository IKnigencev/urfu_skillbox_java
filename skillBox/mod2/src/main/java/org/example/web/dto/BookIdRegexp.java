package org.example.web.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BookIdRegexp {

    @NotNull
    @Size(max = 500)
    private String queryRegex;

    public String getQueryRegex() {
        return queryRegex;
    }

    public void setQueryRegex(String queryRegex) {
        this.queryRegex = queryRegex;
    }
}
