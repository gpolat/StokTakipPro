/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gokhanpolat.pojos;

/**
 *
 * @author John
 */
public class Urunler {
    String uAd;
    double uStok;
    double uFiyat;

    public String getuAd() {
        return uAd;
    }

    public void setuAd(String uAd) {
        this.uAd = uAd;
    }

    public double getuStok() {
        return uStok;
    }

    public void setuStok(double uStok) {
        this.uStok = uStok;
    }

    public double getuFiyat() {
        return uFiyat;
    }

    public void setuFiyat(double uFiyat) {
        this.uFiyat = uFiyat;
    }
    
    
}
