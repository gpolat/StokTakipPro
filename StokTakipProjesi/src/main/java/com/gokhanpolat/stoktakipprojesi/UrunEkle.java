/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gokhanpolat.stoktakipprojesi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@ManagedBean
@SessionScoped
public class UrunEkle {
    
    Connection c=null;
    Statement s=null;
    
    String uAd;
    double uStok;
    
    public void urunEkle(ActionEvent ae) throws  Exception
    {
        String sql = "update urunler set uStok=uStok+"+uStok+" where uAd='"+uAd+"'";
        
        Class.forName("com.mysql.jdbc.Driver");
        c=DriverManager.getConnection("jdbc:mysql://localhost:3306/stok?characterEncoding=utf-8&useUnicode=true","root","");
        s = c.createStatement();
        s.execute(sql);
        s.close();
        c.close();
    }

    public String getUAd() {
        return uAd;
    }

    public void setUAd(String uAd) {
        this.uAd = uAd;
    }

    public double getUStok() {
        return uStok;
    }

    public void setUStok(double uStok) {
        this.uStok = uStok;
    }

    
    
    

    
    
}
