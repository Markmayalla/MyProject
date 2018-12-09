package tz.co.comptech.m_safariproduction.Model;/*
*
* m-safari App
* By GrandMaster
* 2018 Nov
*
*/


import java.util.ArrayList;

public class BusCenter{
 private String region;
 private String name;
 ArrayList< String > local_points = new ArrayList < String > ();


 // Getter Methods 

 public String getRegion() {
  return region;
 }

 public String getName() {
  return name;
 }

 // Setter Methods 

 public void setRegion(String region) {
  this.region = region;
 }

 public void setName(String name) {
  this.name = name;
 }
}