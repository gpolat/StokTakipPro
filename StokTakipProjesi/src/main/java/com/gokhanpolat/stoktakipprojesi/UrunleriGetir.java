/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gokhanpolat.stoktakipprojesi;

import com.gokhanpolat.pojos.Urunler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;
@ManagedBean
@SessionScoped
public class UrunleriGetir {
    Connection c=null;
    Statement s=null;
    ResultSet rs=null;
    List<String> uListesi;
    
    public List<String> getUrunler() throws SQLException
    {
        uListesi=new ArrayList<>();
        String sql ="select uAd from urunler order by uAd asc";
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/stok?characterEncoding=utf-8&useUnicode=true","root","");
            s = c.createStatement();
            rs = s.executeQuery(sql);
            while(rs.next())
            {
                uListesi.add(rs.getString("uAd"));
            }
            s.close();
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
        
        
        return uListesi;
    }
    
}
