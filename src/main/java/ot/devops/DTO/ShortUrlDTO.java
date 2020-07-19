package ot.devops.DTO;

import javax.validation.constraints.NotBlank;

public class ShortUrlDTO {

    @NotBlank(message = "url不能为空")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
