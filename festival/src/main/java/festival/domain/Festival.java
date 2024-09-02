package festival.domain;

import com.google.gson.annotations.SerializedName;

public class Festival {

    @SerializedName("contentid")
    private String contentid;

    @SerializedName("contenttypeid")
    private String contenttypeid;

    @SerializedName("areacode")
    private String areacode;

    @SerializedName("title")
    private String title;

    @SerializedName("addr1")
    private String addr1;

    @SerializedName("addr2")
    private String addr2;

    @SerializedName("mapx")
    private String mapx;

    @SerializedName("mapy")
    private String mapy;

    @SerializedName("firstimage")
    private String firstimage;

    @SerializedName("firstimage2")
    private String firstimage2;

    @SerializedName("eventstartdate")
    private String eventstartdate; // 날짜를 문자열로

    @SerializedName("eventenddate")
    private String eventenddate; // 날짜를 문자열로

    @SerializedName("overviewYN")
    private String overviewYN;

    @SerializedName("tel")
    private String tel;

    @SerializedName("playtime")
    private String playtime;

    @SerializedName("usetimefestival")
    private String usetimefestival;

    // Constructors, getters, and setters

    public String getContentid() {
        return contentid;
    }

    public void setContentid(String contentid) {
        this.contentid = contentid;
    }

    public String getContenttypeid() {
        return contenttypeid;
    }

    public void setContenttypeid(String contenttypeid) {
        this.contenttypeid = contenttypeid;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    public String getMapx() {
        return mapx;
    }

    public void setMapx(String mapx) {
        this.mapx = mapx;
    }

    public String getMapy() {
        return mapy;
    }

    public void setMapy(String mapy) {
        this.mapy = mapy;
    }

    public String getFirstimage() {
        return firstimage;
    }

    public void setFirstimage(String firstimage) {
        this.firstimage = firstimage;
    }

    public String getFirstimage2() {
        return firstimage2;
    }

    public void setFirstimage2(String firstimage2) {
        this.firstimage2 = firstimage2;
    }

    public String getEventstartdate() {
        return eventstartdate;
    }

    public void setEventstartdate(String eventstartdate) {
        this.eventstartdate = eventstartdate;
    }

    public String getEventenddate() {
        return eventenddate;
    }

    public void setEventenddate(String eventenddate) {
        this.eventenddate = eventenddate;
    }

    public String getOverviewYN() {
        return overviewYN;
    }

    public void setOverviewYN(String overviewYN) {
        this.overviewYN = overviewYN;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPlaytime() {
        return playtime;
    }

    public void setPlaytime(String playtime) {
        this.playtime = playtime;
    }

    public String getUsetimefestival() {
        return usetimefestival;
    }

    public void setUsetimefestival(String usetimefestival) {
        this.usetimefestival = usetimefestival;
    }

    @Override
    public String toString() {
        return "Festival [contentid=" + contentid + ", contenttypeid=" + contenttypeid + ", areacode=" + areacode
                + ", title=" + title + ", addr1=" + addr1 + ", addr2=" + addr2 + ", mapx=" + mapx + ", mapy=" + mapy
                + ", firstimage=" + firstimage + ", firstimage2=" + firstimage2 + ", eventstartdate=" + eventstartdate
                + ", eventenddate=" + eventenddate + ", overviewYN=" + overviewYN + ", tel=" + tel
                + ", playtime=" + playtime + ", usetimefestival=" + usetimefestival + "]";
    }
}
