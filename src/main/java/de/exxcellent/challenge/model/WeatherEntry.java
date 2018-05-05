package de.exxcellent.challenge.model;

import java.util.Objects;

/**
 * @author pc
 * @since 05.05.18
 */
public class WeatherEntry {

    private String day;
    private double mxt, mnt, avt, avdp, hrp_tpcpn, pdir, avsp, dir, mxs, skyc, mxr, mn, r_avslp;

    public WeatherEntry() {
    }

    public WeatherEntry(String day, double mxt, double mnt, double avt, double avdp, double hrp_tpcpn, double pdir, double avsp, double dir, double mxs, double skyc, double mxr, double mn, double r_avslp) {
        this.day = day;
        this.mxt = mxt;
        this.mnt = mnt;
        this.avt = avt;
        this.avdp = avdp;
        this.hrp_tpcpn = hrp_tpcpn;
        this.pdir = pdir;
        this.avsp = avsp;
        this.dir = dir;
        this.mxs = mxs;
        this.skyc = skyc;
        this.mxr = mxr;
        this.mn = mn;
        this.r_avslp = r_avslp;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public double getMxt() {
        return mxt;
    }

    public void setMxt(double mxt) {
        this.mxt = mxt;
    }

    public double getMnt() {
        return mnt;
    }

    public void setMnt(double mnt) {
        this.mnt = mnt;
    }

    public double getAvt() {
        return avt;
    }

    public void setAvt(double avt) {
        this.avt = avt;
    }

    public double getAvdp() {
        return avdp;
    }

    public void setAvdp(double avdp) {
        this.avdp = avdp;
    }

    public double getHrp_tpcpn() {
        return hrp_tpcpn;
    }

    public void setHrp_tpcpn(double hrp_tpcpn) {
        this.hrp_tpcpn = hrp_tpcpn;
    }

    public double getPdir() {
        return pdir;
    }

    public void setPdir(double pdir) {
        this.pdir = pdir;
    }

    public double getAvsp() {
        return avsp;
    }

    public void setAvsp(double avsp) {
        this.avsp = avsp;
    }

    public double getDir() {
        return dir;
    }

    public void setDir(double dir) {
        this.dir = dir;
    }

    public double getMxs() {
        return mxs;
    }

    public void setMxs(double mxs) {
        this.mxs = mxs;
    }

    public double getSkyc() {
        return skyc;
    }

    public void setSkyc(double skyc) {
        this.skyc = skyc;
    }

    public double getMxr() {
        return mxr;
    }

    public void setMxr(double mxr) {
        this.mxr = mxr;
    }

    public double getMn() {
        return mn;
    }

    public void setMn(double mn) {
        this.mn = mn;
    }

    public double getR_avslp() {
        return r_avslp;
    }

    public void setR_avslp(double r_avslp) {
        this.r_avslp = r_avslp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherEntry that = (WeatherEntry) o;
        return Double.compare(that.mxt, mxt) == 0 &&
                Double.compare(that.mnt, mnt) == 0 &&
                Double.compare(that.avt, avt) == 0 &&
                Double.compare(that.avdp, avdp) == 0 &&
                Double.compare(that.hrp_tpcpn, hrp_tpcpn) == 0 &&
                Double.compare(that.pdir, pdir) == 0 &&
                Double.compare(that.avsp, avsp) == 0 &&
                Double.compare(that.dir, dir) == 0 &&
                Double.compare(that.mxs, mxs) == 0 &&
                Double.compare(that.skyc, skyc) == 0 &&
                Double.compare(that.mxr, mxr) == 0 &&
                Double.compare(that.mn, mn) == 0 &&
                Double.compare(that.r_avslp, r_avslp) == 0 &&
                Objects.equals(day, that.day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, mxt, mnt, avt, avdp, hrp_tpcpn, pdir, avsp, dir, mxs, skyc, mxr, mn, r_avslp);
    }
}
