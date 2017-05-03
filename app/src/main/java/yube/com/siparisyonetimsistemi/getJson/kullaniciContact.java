package yube.com.siparisyonetimsistemi.getJson;

/**
 * Created by yusuf on 26.04.2017.
 */

public class kullaniciContact {
    private   String kullanici_adi,sifre,yetki;

    public kullaniciContact(String kullanici_adi, String sifre, String yetki) {
        this.setKullanici_adi(kullanici_adi);
        this.setSifre(sifre);
        this.setYetki(yetki);
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getYetki() {
        return yetki;
    }

    public void setYetki(String yetki) {
        this.yetki = yetki;
    }

    public String getKullanici_adi() {
        return kullanici_adi;
    }

    public void setKullanici_adi(String kullanici_adi) {
        this.kullanici_adi = kullanici_adi;
    }
}
