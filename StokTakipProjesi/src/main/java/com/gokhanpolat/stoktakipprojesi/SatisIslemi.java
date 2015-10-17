/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gokhanpolat.stoktakipprojesi;

import com.gokhanpolat.pojos.Musteriler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

/**
 *
 * @author John
 */
@ManagedBean
@SessionScoped
public class SatisIslemi {
    Musteriler musteri;
    String uAd;
    double kilo;
    
    PreparedStatement ps=null;
    Statement s=null;
    Connection c=null;
    
    String mesaj;
    
    public Musteriler getMusteri() {
        return musteri;
    }

    public void setMusteri(Musteriler musteri) {
        this.musteri = musteri;
    }

    public double getKilo() {
        return kilo;
    }

    public void setKilo(double kilo) {
        this.kilo = kilo;
    }

    public String getUAd() {
        return uAd;
    }

    public void setUAd(String uAd) {
        this.uAd = uAd;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }
    
    public void satisiYap(ActionEvent ae) 
    {
        String sql="UPDATE urunler SET uStok=uStok-"+kilo+" where uAd='"+uAd+"'";
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/stok?characterEncoding=utf-8&useUnicode=true","root","");
            s=c.createStatement();
            
            
            ResultSet rs=s.executeQuery("select uStok from urunler where uAd='"+uAd+"'");
            while (rs.next()) 
            {
                if(rs.getDouble("uStok")<kilo)
                {
                    mesaj="Elimide yeterli kilo yok!";
                    return;
                } 
            }
                        
            s.executeUpdate(sql);
            mesaj="Satış Başarı İle Gerçekleşti!";
            
        } 
        catch (Exception e) 
        { 
            mesaj="İşlem Sırasında Hata Oldu";
            System.err.println("Bir Hata Meydana Geldi:"+e);
            e.printStackTrace();
            
        }
        
        
        
        /*finally
        {
            c.close();
            s.close();
        } */ 
    }
}
