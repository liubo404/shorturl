package ot.devops.DO;

public class ShortUrlDO {
    private Long id;

    /**
     * short url code
     */
    private String code;

    /**
     * original url
     */
    private String url;

    public ShortUrlDO() {
    }


    public Long getId() {
        return this.id;
    }

    public String getCode() {
        return this.code;
    }

    public String getUrl() {
        return this.url;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ShortUrlDO)) return false;
        final ShortUrlDO other = (ShortUrlDO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$code = this.getCode();
        final Object other$code = other.getCode();
        if (this$code == null ? other$code != null : !this$code.equals(other$code)) return false;
        final Object this$url = this.getUrl();
        final Object other$url = other.getUrl();
        if (this$url == null ? other$url != null : !this$url.equals(other$url)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ShortUrlDO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $code = this.getCode();
        result = result * PRIME + ($code == null ? 43 : $code.hashCode());
        final Object $url = this.getUrl();
        result = result * PRIME + ($url == null ? 43 : $url.hashCode());
        return result;
    }

    public String toString() {
        return "ShortUrlDO(id=" + this.getId() + ", code=" + this.getCode() + ", url=" + this.getUrl() + ")";
    }
}
