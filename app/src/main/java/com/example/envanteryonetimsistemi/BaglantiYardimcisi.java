package com.example.envanteryonetimsistemi;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaglantiYardimcisi {
  String user,pass,ip,db,port;
@SuppressLint("NewApi")
  public Connection baglanti()
  {
      ip="169.254.12.161";
      db="envanter";
      user="root";
      pass="root1234";
      port="1433";

      StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
      StrictMode.setThreadPolicy(policy);
      Connection bag=null;
      String BaglantiAdresi=null;

      try
      {
          Class.forName("net.sourceforge.jtds.jdbc.Driver");
          BaglantiAdresi="jdbc:jtds:sqlserver://"+ip+":"+port+";databasename="+db+";user="+user+";password="+pass+";";
          bag= DriverManager.getConnection(BaglantiAdresi);
      }
      catch (Exception ex)
      {
          Log.e("Baglanti Hatasi",ex.getMessage());
      }
      return bag;
  }
}
