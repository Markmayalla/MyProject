package tz.co.comptech.m_safariproduction.Model;/*
*
* m-safari App
* By GrandMaster
* 2018 Nov
*
*/


import java.util.ArrayList;

public class BusRoute {
 private String from_center;
 private String to_center;
 ArrayList<BusCenter> points;


 // Getter Methods 

 public String getFrom_center() {
  return from_center;
 }

 public String getTo_center() {
  return to_center;
 }

 // Setter Methods 

 public void setFrom_center(String from_center) {
  this.from_center = from_center;
 }

 public void setTo_center(String to_center) {
  this.to_center = to_center;
 }
}