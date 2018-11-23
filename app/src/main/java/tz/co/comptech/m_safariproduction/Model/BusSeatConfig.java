package tz.co.comptech.m_safariproduction.Model;/*
*
* m-safari App
* By GrandMaster
* 2018 Nov
*
*/


import java.util.ArrayList;

public class BusSeatConfig {
 private float no_rows;
 private float no_cols;
 private String cols_naming_type;
 private String rows_naming_type;
 ArrayList< SingleSeatObj > seats = new ArrayList < SingleSeatObj > ();







 // Getter Methods 

 public float getNo_rows() {
  return no_rows;
 }

 public float getNo_cols() {
  return no_cols;
 }

 public String getCols_naming_type() {
  return cols_naming_type;
 }

 public String getRows_naming_type() {
  return rows_naming_type;
 }

 // Setter Methods 

 public void setNo_rows(float no_rows) {
  this.no_rows = no_rows;
 }

 public void setNo_cols(float no_cols) {
  this.no_cols = no_cols;
 }

 public void setCols_naming_type(String cols_naming_type) {
  this.cols_naming_type = cols_naming_type;
 }

 public void setRows_naming_type(String rows_naming_type) {
  this.rows_naming_type = rows_naming_type;
 }
}