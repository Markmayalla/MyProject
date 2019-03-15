package tz.co.comptech.m_safariproduction.Model;/*
*
* m-safari App
* By GrandMaster
* 2018 Nov
*
*/


import com.google.gson.annotations.SerializedName;

public class SingleSeatObj {
 @SerializedName("row")
 private float row;
 @SerializedName("col")
 private float col;
 @SerializedName("level")
 private float level;
 @SerializedName("index")
 private float index;


 // Getter Methods 

 public float getRow() {
  return row;
 }

 public float getCol() {
  return col;
 }

 public float getLevel() {
  return level;
 }

 public float getIndex() {
  return index;
 }

}