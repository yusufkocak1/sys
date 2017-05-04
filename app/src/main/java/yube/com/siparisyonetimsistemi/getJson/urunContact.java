package yube.com.siparisyonetimsistemi.getJson;

/**
 * Created by yusuf on 3.05.2017.
 */

public class urunContact {
    private String urun_adi, kategori, fiyat;

    public urunContact(String urun_adi, String kategori, String fiyat) {
        this.setUrun_adi(urun_adi);
        this.setFiyat(fiyat);
        this.setKategori(kategori);

    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
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
}
