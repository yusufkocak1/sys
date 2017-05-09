package yube.com.siparisyonetimsistemi.getJson;

/**
 * Created by yusuf on 9.05.2017.
 */

public class siparisgosterContact {

    private String urun_adi,fiyat,adet,urun_id,siparis_zamani,durum,personel_id, masa_id;
    public siparisgosterContact(
            String personel_id,
            String masa_id,
            String adet,
            String urun_id,
            String urun_adi,
            String fiyat,
            String siparis_zamani,
            String durum


    ) {
        this.setUrun_id(urun_id);
        this.setUrun_adi(urun_adi);
        this.setPersonel_id(personel_id);
        this.setMasa_id(masa_id);
        this.setAdet(adet);
        this.setFiyat(fiyat);
        this.setSiparis_zamani(siparis_zamani);
        this.setDurum(durum);



    }

    public String getUrun_adi() {
        return urun_adi;
    }

    public void setUrun_adi(String urun_adi) {
        this.urun_adi = urun_adi;
    }

    public String getFiyat() {
        return fiyat;
    }

    public void setFiyat(String fiyat) {
        this.fiyat = fiyat;
    }

    public String getAdet() {
        return adet;
    }

    public void setAdet(String adet) {
        this.adet = adet;
    }

    public String getUrun_id() {
        return urun_id;
    }

    public void setUrun_id(String urun_id) {
        this.urun_id = urun_id;
    }

    public String getSiparis_zamani() {
        return siparis_zamani;
    }

    public void setSiparis_zamani(String siparis_zamani) {
        this.siparis_zamani = siparis_zamani;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }

    public String getPersonel_id() {
        return personel_id;
    }

    public void setPersonel_id(String personel_id) {
        this.personel_id = personel_id;
    }

    public String getMasa_id() {
        return masa_id;
    }

    public void setMasa_id(String masa_id) {
        this.masa_id = masa_id;
    }
}
