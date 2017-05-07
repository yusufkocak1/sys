package yube.com.siparisyonetimsistemi.getJson;

/**
 * Created by yusuf on 4.05.2017.
 */

public class siparisContact {
    private String urun_adi;
    private String adet;
    private String urun_id;


    private String fiyat;

    public siparisContact(String urun_adi, String fiyat, String adet, String urun_id) {
        this.setUrun_id(urun_id);
        this.setFiyat(fiyat);
        this.setUrun_adi(urun_adi);
        this.setAdet(adet);
    }

    public String getUrun_id() {
        return urun_id;
    }

    public void setUrun_id(String urun_id) {
        this.urun_id = urun_id;
    }

    public String getFiyat() {
        return fiyat;
    }

    public void setFiyat(String fiyat) {
        this.fiyat = fiyat;
    }

    public String getUrun_adi() {
        return urun_adi;
    }

    public void setUrun_adi(String urun_adi) {
        this.urun_adi = urun_adi;
    }

    public String getAdet() {
        return adet;
    }

    public void setAdet(String adet) {
        this.adet = adet;
    }
}
