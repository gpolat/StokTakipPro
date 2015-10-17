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
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.swing.table.DefaultTableModel;

@ManagedBean
@SessionScoped
public class MusterileriGetir {
    String isim;
    
    List<Musteriler> mListe;
    Statement s=null;
    ResultSet rs=null;
    Connection c=null;
    public List<Musteriler> getMusteriler() throws SQLException
    {
        mListe=new ArrayList<>();
        String kolonAdlari[] = { "AD", "FİRMA", "ADRES", "TELEFON" };
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/stok?characterEncoding=utf-8&useUnicode=true","root","");
            s = c.createStatement();
            rs = s.executeQuery("select * from musteriler");
            while(rs.next())
            {
                Musteriler mo=new Musteriler();
                mo.setAd(rs.getString("mAdi"));
                mo.setAdres(rs.getString("mAdres"));
                mo.setFirma(rs.getString("mFirma"));
                mo.setTelefon(rs.getString("mTel"));
                
                /*Object[] o = 
                {
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5)
                };
                dtm.addRow(o);*/
                mListe.add(mo);
            }
            
        } 
        catch (Exception e) 
        { 
            e.printStackTrace();
        }
        finally
        {
            c.close();
            rs.close();
            s.close();
        }
        return mListe;
    }
    
}
